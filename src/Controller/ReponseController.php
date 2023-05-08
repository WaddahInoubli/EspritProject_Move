<?php

namespace App\Controller;
use App\Entity\Reclamation;
use App\Repository\ReclamationRepository;
use App\Entity\Reponse;
use App\Form\ReponseType;
use App\Repository\ReponseRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/reponse")
 */
class ReponseController extends AbstractController
{
    /**
     * @Route("/", name="app_reponse_index", methods={"GET"})
     */
    public function index(ReponseRepository $reponseRepository): Response
    {
        return $this->render('reponse/index.html.twig', [
            'reponses' => $reponseRepository->findAll(),
        ]);
    }


    /**
     * @Route("/{id}/new", name="app_reponse_Reply", methods={"GET", "POST"})
     */
    public function new(Request $request,$id,ReclamationRepository $r,ReponseRepository $reponseRepository,Reclamation $RECLA): Response
    {


        $reponse = new Reponse();

        $user=$this->getUser();
        $reponse->setIdUser($user);
        $reponse->setIdrec($RECLA);
        $RECLA->setEtat(1);

        $form = $this->createForm(ReponseType::class, $reponse);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

            $reponseRepository->save($reponse, true);


            return $this->redirectToRoute('app_reclamation_show', ['id' => $id], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('reponse/new.html.twig', [
            'reponse' => $reponse,
            'form' => $form,
        ]);
    }

    /**
     * @Route("/{id}", name="app_reponse_show", methods={"GET"})
     */
    public function show(Reponse $reponse,ReclamationRepository $reclamationRepository ): Response
    {   
        $id=$reponse->getIdrec();
        if($id)
        {
        return $this->render('reponse/show.html.twig', [
            'reponse' => $reponse,
            'reclamation'=>$reclamationRepository->find($id),
        ]);}
        else
        {
            return $this->render('reponse/show1.html.twig', [
                'reponse' => $reponse,
                
            ]);
        }
    }
    /**
     * @Route("/{id}/edit", name="app_reponse_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Reponse $reponse, ReponseRepository $reponseRepository): Response
    {
        $form = $this->createForm(ReponseType::class, $reponse);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $reponseRepository->save($reponse, true);

            return $this->redirectToRoute('app_reponse_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('reponse/edit.html.twig', [
            'reponse' => $reponse,
            'form' => $form,
        ]);
    }

    /**
     * @Route("/{id}", name="app_reponse_delete", methods={"POST"})
     */
    public function delete(Request $request, Reponse $reponse,ReclamationRepository $r,ReponseRepository $reponseRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$reponse->getId(), $request->request->get('_token'))) {
            $reclamation=new Reclamation();
            $reclamation=$r->find($reponse->getIdrec());
            $reclamation->setEtat(0);
            $reponseRepository->remove($reponse, true);
        }

        return $this->redirectToRoute('app_reclamation_show', ['id'=>$reponse->getIdrec()], Response::HTTP_SEE_OTHER);
    }
}
