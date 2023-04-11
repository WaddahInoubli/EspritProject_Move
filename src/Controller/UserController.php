<?php

namespace App\Controller;

use App\Entity\Publicity;
use App\Entity\User;
use App\Form\PublicityType;
use App\Form\UserType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Encoder\BCryptPasswordEncoder;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;

/**
 * @Route("/admin/users")
 */
class UserController extends AbstractController
{


    /**
     * @Route("/", name="back_users")
     */
    public function users(): Response
    {
        return $this->render('back_template/user/index.html.twig', [
            'controller_name' => 'UserController',
            'users'=> $this->getDoctrine()->getRepository(User::class)->findAll(),
        ]);
    }

    /**
     * @Route("/form", name="back_users_form")
     */
    public function newUser(Request $request, UserPasswordEncoderInterface $passwordEncoder): Response
    {
        $user =new User();
        $form = $this->createForm(UserType::class, $user);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            if(!empty($this->getDoctrine()->getRepository(User::class)->findOneBy(['email' => $form["email"]->getData()]))){
                $this->addFlash('danger', 'Duplicated Email');
                return $this->render('back_template/user/form.html.twig', [
                    'controller_name' => 'UserController',
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
            'controller_name' => 'UserController',
            'form' => $form->createView(),
                'title'=>"Add User",
                'user'=>$user
        ]);
    }

    /**
     * @Route("/form/{id}", name="back_users_form_edit")
     */
    public function editUser(Request $request , $id ,UserPasswordEncoderInterface $passwordEncoder): Response
    {
        $user =$this->getDoctrine()->getRepository(User::class)->find($id);
        $form = $this->createForm(UserType::class, $user);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
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

    /**
     * @Route("/delete/{id}", name="back_users_delete")
     */
    public function deleteUser($id): Response
    {
        $user =$this->getDoctrine()->getRepository(User::class)->find($id);
        $em = $this->getDoctrine()->getManager();
        $em->remove($user);
        $em->flush();
        $this->addFlash('danger', 'user deleted successfully');
        return $this->redirectToRoute('back_users');

    }
}
