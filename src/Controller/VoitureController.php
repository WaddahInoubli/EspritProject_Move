<?php

namespace App\Controller;


use App\Entity\Voiture;
use App\Form\VoitureType;
use App\Repository\VoitureRepository;
use Doctrine\ORM\EntityManagerInterface;
use Dompdf\Dompdf;
// Example assuming the correct namespace is Dompdf\Options
use Dompdf\Options;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class VoitureController extends AbstractController
{
    #[Route('/voiture', name: 'app_voiture')]
    public function index(): Response
    {
        return $this->render('voiture/index.html.twig', [
            'controller_name' => 'VoitureController',
        ]);
    }

    #[Route("/affichervoiture",name :"affichervoiture")]

    public function Affiche(Request $request,VoitureRepository $repository,PaginatorInterface $paginator){
        $tableVoiture=$repository->listvoitureparprix();
        $tableVoiture = $paginator->paginate(
            $tableVoiture,
            $request->query->getInt('page', 1),
            2
        );
        return $this->render('voiture/affichervoiture.html.twig'
            ,['tableVoiture'=>$tableVoiture,
            ]);
    }

    #[Route("/affichervoiturefront",name :"affichervoiturefront")]

    public function Affichefront(Request $request,VoitureRepository $repository,PaginatorInterface $paginator){
        $tableVoiture=$repository->listvoitureparprix();
        $tableVoiture = $paginator->paginate(
            $tableVoiture,
            $request->query->getInt('page', 1),
            2
        );
        return $this->render('voiture/affichervoiturefront.html.twig'
            ,['tableVoiture'=>$tableVoiture,
            ]);
    }


    #[Route("/ajoutervoiture",name:"ajoutervoiture")]

    public function ajoutervoiture(EntityManagerInterface $em,Request $request ,VoitureRepository $voitureRepository){
        $voiture= new Voiture();
        $form= $this->createForm(VoitureType::class,$voiture);
        $form->add('Ajouter',SubmitType::class);
        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){

            $user=$this->getUser();
            $voiture->setUser($user);
            $em->persist($voiture);
            $em->flush();

            return $this->redirectToRoute("affichervoiture");
        }
        return $this->render("voiture/ajoutervoiture.html.twig",array("form"=>$form->createView()));

    }



    #[Route("/supprimervoiture/{id}",name:"supprimervoiture")]

    public function delete($id,EntityManagerInterface $em ,VoitureRepository $repository){
        $rec=$repository->find($id);
        $em->remove($rec);
        $em->flush();

        return $this->redirectToRoute('affichervoiture');
    }




    #[Route("/{id}/modifiervoiture", name:"modifiervoiture")]

    public function edit(Request $request, Voiture $voiture): Response
    {
        $form = $this->createForm(VoitureType::class, $voiture);
        $form->add('Confirmer',SubmitType::class);

        $form->handleRequest($request);


        if ($form->isSubmitted() && $form->isValid()) {


            $this->getDoctrine()->getManager()->flush();


            return $this->redirectToRoute('affichervoiture');
        }

        return $this->render('voiture/ModifVoiture.html.twig', [
            'voituremodif' => $voiture,
            'form' => $form->createView(),
        ]);
    }





    #[Route("/pdf/{id}",name:"pdf", methods: ['GET'])]
    public function pdf($id,VoitureRepository $repository): Response{

        $voiture=$repository->find($id);
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Arial');
        $dompdf = new Dompdf($pdfOptions);
        $html = $this->renderView('voiture/pdf.html.twig', [
            'pdf' => $voiture,

        ]);
        $dompdf->loadHtml($html);

        $dompdf->setPaper('A4', 'portrait');
        $dompdf->render();

        $pdfOutput = $dompdf->output();
        return new Response($pdfOutput, 200, [
            'Content-Type' => 'application/pdf',
            'Content-Disposition' => 'attachment; filename="voiture.pdf"'
        ]);

    }





}
