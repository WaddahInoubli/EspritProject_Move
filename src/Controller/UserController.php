<?php

namespace App\Controller;

use App\Entity\User;
use App\Form\UserType;
use App\Repository\UserRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Symfony\Component\Validator\Validator\ValidatorInterface;


#[Route('/admin/users')]
class UserController extends AbstractController {



    #[Route("/", name:"back_users")]
    public function users(): Response
    {
        return $this->render('back_template/user/index.html.twig', [
            'controller_name' => 'UserController',
            'users'=> $this->getDoctrine()->getRepository(User::class)->findAll(),
        ]);
    }


    #[Route("/form", name:"back_users_form")]
    public function newUser(Request $request, UserPasswordEncoderInterface $passwordEncoder,ValidatorInterface $validator): Response
    {
        $user =new User();
        $form = $this->createForm(UserType::class, $user);
        $form->handleRequest($request);
        if ($form->isSubmitted()) {

            $errors = $validator->validate($user);
            if (count($errors) > 0) {
                return $this->render('back_template/user/form.html.twig', [
                    'form' => $form->createView(),
                    'title'=>"Add User",
                    'user'=>$user,
                ]);
            }
            if(!empty($this->getDoctrine()->getRepository(User::class)->findOneBy(['email' => $form["email"]->getData()]))){
                $this->addFlash('danger', 'Duplicated Email');
                return $this->render('back_template/user/form.html.twig', [
                    'form' => $form->createView(),
                    'title'=>"Add User",
                    'user'=>$user
                ]);
            }
            $entityManager = $this->getDoctrine()->getManager();


            $user->setPassword($passwordEncoder->encodePassword($user, $form["password"]->getData()));

            $entityManager->persist($user);
            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', 'User added successfully');
            return $this->redirectToRoute('back_users');
        }

            return $this->render('back_template/user/form.html.twig', [
            'form' => $form->createView(),
                'title'=>"Add User",
                'user'=>$user
        ]);
    }


    #[Route("/form/{id}", name:"back_users_form_edit")]
    public function editUser(Request $request , $id ,UserPasswordEncoderInterface $passwordEncoder,ValidatorInterface $validator): Response
    {
        $user =$this->getDoctrine()->getRepository(User::class)->find($id);
        $form = $this->createForm(UserType::class, $user);
        $form->handleRequest($request);
        if ($form->isSubmitted()) {
            $errors = $validator->validate($user);
            if (count($errors) > 0) {
                return $this->render('back_template/user/form.html.twig', [
                    'form' => $form->createView(),
                    'title'=>"Modifier ".$user->getNom()." ".$user->getPrenom(),
                    'user'=>$user,
                ]);
            }
            if(!empty($this->getDoctrine()->getRepository(User::class)->findOneBy(['email' => $form["email"]->getData()]))){
                if($this->getDoctrine()->getRepository(User::class)->findOneBy(['email' => $form["email"]->getData()])!=$user){
                    $this->addFlash('danger', 'Duplicated Email');
                    return $this->render('back_template/user/form.html.twig', [
                        'controller_name' => 'UserController',
                        'form' => $form->createView(),
                        'title'=>"Modifier ".$user->getNom()." ".$user->getPrenom(),
                        'user'=>$user
                    ]);
                }
            }

             $entityManager = $this->getDoctrine()->getManager();

            $entityManager->persist($user);
            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', 'User edited successfully');
            return $this->redirectToRoute('back_users');
        }

        return $this->render('back_template/user/form.html.twig', [
            'controller_name' => 'UserController',
            'form' => $form->createView(),
            'title'=>"Modifier ".$user->getNom()." ".$user->getPrenom(),
            'user'=>$user

        ]);
    }


    #[Route("/delete/{id}", name:"back_users_delete")]
    public function deleteUser($id): Response
    {
        $user =$this->getDoctrine()->getRepository(User::class)->find($id);
        $em = $this->getDoctrine()->getManager();
        $em->remove($user);
        $em->flush();
        $this->addFlash('danger', 'user deleted successfully');
        return $this->redirectToRoute('back_users');

    }
    public function searchUser(Request $request, UserRepository $userRepository): Response
    {
        $name = $request->query->get('name');
        $users = $userRepository->searchUsersByName($name);

        return $this->render('user/search.html.twig', [
            'users' => $users,
            'name' => $name,
        ]);
    }

    #[Route("/profile", name:"profileback")]
    public function showProfile(Request $request ,UserPasswordEncoderInterface $passwordEncoder): Response
    {
        $user =$this->getUser();
        $form = $this->createForm(UserType::class, $user);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            if(!empty($this->getDoctrine()->getRepository(User::class)->findOneBy(['email' => $form["email"]->getData()]))){
                if($this->getDoctrine()->getRepository(User::class)->findOneBy(['email' => $form["email"]->getData()])!=$user){
                    $this->addFlash('danger', 'Duplicated Email');
                    //To change
                    return $this->render('back_template/user/profile.html.twig', [
                        'form' => $form->createView(),
                        'title'=>"Modifier votre profil",
                        'user'=>$user
                    ]);
                }
            }

            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', "Votre profil ".$user->getNom()." ".$user->getPrenom()."a été modifié");
        }

        return $this->render('back_template/user/profile.html.twig', [
            'form' => $form->createView(),
            'title'=>"Modifier votre profile",
            'user'=>$user

        ]);
    }

}
