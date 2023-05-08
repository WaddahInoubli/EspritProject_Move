<?php

namespace App\Controller\Admin;

use App\Form\AnnoncesType;
use App\Entity\Annonces;
use App\Entity\User;
use App\Repository\AnnoncesRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;

class AnnoncesController extends AbstractController
{
    #[Route('/admin/annonces', name: 'admin_annonces_')]
    public function index(AnnoncesRepository $AnnoncesRepo): Response
    {
        $user = $this->getUser();
        return $this->render('admin/annonces/index.html.twig', [

            'annonces' => $AnnoncesRepo->findAll(),
            'user' => $user,
        ]);
    }

    #[Route('/admin/annonces/ajout', name: 'admin_annonces_ajout')]
    public function ajoutAnnonces(Request $request): Response
    {
        $annonce = new Annonces;

        $form = $this->createForm(AnnoncesType::class, $annonce);
        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){

           
            
            $em = $this->getDoctrine()->getManager();
            $user=$this->getUser();
            $annonce->setNameUser($user);
            $annonce->setActive(false);

            $em->persist($annonce);
            $em->flush();

            return $this->redirectToRoute('admin_annonces_');
        }

        return $this->render('admin/annonces/ajout.html.twig', [
            'controller_name' => 'AnnoncesController',
            'form' => $form->createView(),
        ]);
    }
    #[Route('/admin/annonces/activer/{id}', name: 'activer')]
    public function activer(Annonces $annonce): Response
    {
        $annonce->setActive(($annonce->isActive())?false:true);

        $em = $this->getDoctrine()->getManager();
        $em->persist($annonce);
        $em->flush();

        return new Response("true");
    }
    #[Route('/admin/annonces/supprimer/{id}', name: 'supprimera')]
    public function supprimer(Annonces $annonce)
    {

        $em = $this->getDoctrine()->getManager();
        $em->remove($annonce);
        $em->flush();

        $this->addFlash('message', 'Annonce supprimée avec succès');
        return $this->redirectToRoute('admin_annonces_');
    }

    #[Route('/admin/annonces/modifier/{id}', name: 'annonce_modifier')]
    public function ModifCategorie(Annonces $annonce, Request $request)
    {
        $form = $this->createForm(AnnoncesType::class, $annonce);

        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($annonce);
            $em->flush();


            return $this->redirectToRoute('admin_annonces_');
        }

        return $this->render('admin/annonces/ajout.html.twig', [
            'form' => $form->createView()
        ]);
    }
   

}
