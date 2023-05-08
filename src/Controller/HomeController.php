<?php

namespace App\Controller;


use App\Entity\User;
use App\Form\UserType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;


class HomeController extends AbstractController
{

    #[Route("/", name:"home")]
    public function index(): Response
    {
        return $this->render('baseBack.html.twig', [
            'controller_name' => 'HomeController',
        ]);
    }
    #[Route("/backUser", name:"backUser")]
    public function back()
    {
        return $this->render('baseBack.html.twig');
    }
    #[Route("/profile", name:"profilFront")]
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
                    return $this->render('home/profileFront.html.twig', [
                        'form' => $form->createView(),
                        'title'=>"Modifier votre profil",
                        'user'=>$user
                    ]);
                }
            }

            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', "Votre profil ".$user->getNom()." ".$user->getPrenom()."a été modifié");
        }

        return $this->render('home/profileFront.html.twig', [
            'form' => $form->createView(),
            'title'=>"Modifier votre profile",
            'user'=>$user

        ]);
    }




}
