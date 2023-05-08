<?php

namespace App\Controller\Admin;
use App\Form\CommentsType;
use App\Entity\Comments;
use App\Repository\CommentsRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;

class CommentsController extends AbstractController
{
    #[Route('/admin/comments', name: 'comments')]
    public function index(CommentsRepository $comRepo)
    {
        return $this->render('admin/comments/index.html.twig', [
            'comments' => $comRepo->findAll()
        ]);
    }
    #[Route('admin/comments/ajout', name: 'comments_ajout')]
    public function ajoutcomments(Request $request): Response
    {
        $comment = new Comments;

        $form = $this->createForm(CommentsType::class, $comment);

        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $user=$this->getUser();
            $comment->setUser($user);
            $em->persist($comment);
            $em->flush();

            return $this->redirectToRoute('comments');
        }


        return $this->render('admin/comments/ajout.html.twig', [
            'form' => $form->createView()
        ]);
    }
    #[Route('admin/modifier/{id}', name: 'comments_modifier')]
    public function ModifComment(Comments $comment, Request $request)
    {
        $form = $this->createForm(CommentsType::class, $comment);

        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($comment);
            $em->flush();


            return $this->redirectToRoute('comments');
        }

        return $this->render('admin/comments/ajout.html.twig', [
            'form' => $form->createView()
        ]);
    }

    #[Route('/admin/comments/supprimer/{id}', name: 'supprimercom')]
    public function supprimer(Comments $comment)
    {

        $em = $this->getDoctrine()->getManager();
        $em->remove($comment);
        $em->flush();

        $this->addFlash('message', 'categories supprimée avec succès');
        return $this->redirectToRoute('comments');
    }
}
