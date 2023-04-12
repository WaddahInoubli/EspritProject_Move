<?php

namespace App\Controller;

use App\Entity\Modele;
use App\Entity\Voiture;
use App\Form\ModeleType;
use App\Form\VoitureType;
use App\Repository\ModeleRepository;
use App\Repository\VoitureRepository;
use Doctrine\ORM\EntityManagerInterface;
use Dompdf\Dompdf;
use Dompdf\Options;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ModeleController extends AbstractController
{
    #[Route('/modele', name: 'app_modele')]
    public function index(): Response
    {
        return $this->render('modele/index.html.twig', [
            'controller_name' => 'ModeleController',
        ]);
    }
    #[Route("/affichermodele",name :"affichermodele")]

    public function Affiche(Request $request,ModeleRepository $repository,PaginatorInterface $paginator){
        $tablemodele=$repository->findAll();
        $tablemodele = $paginator->paginate(
            $tablemodele,
            $request->query->getInt('page', 1),
            2
        );
        return $this->render('modele/affichermodele.html.twig'
            ,['tablemodele'=>$tablemodele,
            ]);
    }




    #[Route("/ajoutermodele",name:"ajoutermodele")]

    public function ajoutermodele(EntityManagerInterface $em,Request $request ,ModeleRepository $modeleRepository){
        $modele= new Modele();
        $form= $this->createForm(ModeleType::class,$modele);
        $form->add('Ajouter',SubmitType::class);
        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){

            $em->persist($modele);
            $em->flush();

            return $this->redirectToRoute("affichermodele");
        }
        return $this->render("modele/ajoutermodele.html.twig",array("form"=>$form->createView()));

    }



    #[Route("/supprimermodele/{id}",name:"supprimermodele")]

    public function delete($id,EntityManagerInterface $em ,ModeleRepository $repository){
        $rec=$repository->find($id);
        $em->remove($rec);
        $em->flush();

        return $this->redirectToRoute('affichermodele');
    }




    #[Route("/{id}/modifiermodele", name:"modifiermodele")]

    public function edit(Request $request, Modele $modele): Response
    {
        $form = $this->createForm(ModeleType::class, $modele);
        $form->add('Confirmer',SubmitType::class);

        $form->handleRequest($request);


        if ($form->isSubmitted() && $form->isValid()) {


            $this->getDoctrine()->getManager()->flush();


            return $this->redirectToRoute('affichermodele');
        }

        return $this->render('modele/Modifmodele.html.twig', [
            'modelemodif' => $modele,
            'form' => $form->createView(),
        ]);
    }





    #[Route("/pdf2/{id}",name:"pdf2", methods: ['GET'])]
    public function pdf($id,ModeleRepository $repository): Response{

        $model=$repository->find($id);
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Arial');
        $dompdf = new Dompdf($pdfOptions);
        $html = $this->renderView('modele/pdf.html.twig', [
            'pdf' => $model,

        ]);
        $dompdf->loadHtml($html);

        $dompdf->setPaper('A4', 'portrait');
        $dompdf->render();

        $pdfOutput = $dompdf->output();
        return new Response($pdfOutput, 200, [
            'Content-Type' => 'application/pdf',
            'Content-Disposition' => 'attachment; filename="model.pdf"'
        ]);

    }
    #[Route("/stat",name:"stat")]

    public function statAction(ModeleRepository $test)
    {
        $modeles= $test->findAll();

        foreach($modeles as $i){
            $marque[]=$i->getMarque();
            $voiture[]=sizeof($i->getVoiture());
        }
        return $this->render('modele/stat.html.twig',
            [

                'marque'=> json_encode($marque),
                'voiture'=> json_encode($voiture),

            ]);


    }

}
