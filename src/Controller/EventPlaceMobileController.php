<?php


namespace App\Controller;

use App\Entity\Eventplace;


use App\Form\EventplaceType;
use App\Repository\EventplaceRepository;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\String\Slugger\SluggerInterface;
use MercurySeries\FlashyBundle\FlashyNotifier;
use Symfony\Component\HttpFoundation\JsonResponse;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;
use DateTime;

class EventPlaceMobileController extends AbstractController
{


    #[Route('/eventplace/mobile', name: 'app_eventplace_mobile')]
    public function index(): Response
    {
        return $this->render('/index.html.twig', [
            'controller_name' => 'EventPlaceMobileController',
        ]);
    }



    #[Route('/eventplaceJSON', name: 'lapp_eventplace_mobile')]
public function findall(EventPlaceRepository $eventRepository): Response
{
    $events=$eventRepository->findAll();
    $rdvs = [];
    foreach ($events as $eventplace)
    {
        $rdvs[]=[
            'id'=>$eventplace->getId(),
            'nom'=>$eventplace->getNom(),
            'codep'=>$eventplace->getCodep(),
            'adresse'=>$eventplace->getAdresse(),
            

        ];
    }
    $jsonData = json_encode($rdvs);

    return new JsonResponse($jsonData, Response::HTTP_OK, [], true);
}


#[Route('/removeeventplaceJSON', name: 'rapp_eventplace_mobile')]
public function removeJSON2(Request $request,EventPlaceRepository $rep, NormalizerInterface $normalizer, EntityManagerInterface $entityManager): Response
{
    $event = $rep->find($request->get('id'));


    $entityManager->remove($event);


    $entityManager->flush();

    //$jsonContent=$normalizer->normalize($user,'json',['groups'=>'post:read']);
    return new JsonResponse('eventplace supprimé',200);
}   

#[Route('/addeventplaceJSON', name: 'aapp_eventplace_mobile')]
public function addJSON2(Request $request, NormalizerInterface $normalizer, EntityManagerInterface $entityManager): Response
{
    $categorie = new Eventplace();

    $categorie->setNom($request->get('nom'));
    $categorie->setCodep($request->get('codep'));
    $categorie->setAdresse($request->get('adresse'));



    $entityManager->persist($categorie);
    $entityManager->flush();



    //$jsonContent=$normalizer->normalize($user,'json',['groups'=>'post:read']);
    return new JsonResponse('eventplace ajouté',200);
}




#[Route('/editeventplaceJSON', name: 'eapp_eventplace_mobile')]
public function editJSON2(Request $request,EventPlaceRepository $rep, NormalizerInterface $normalizer, EntityManagerInterface $entityManager): Response
{
    $categorie = $rep->find($request->get('id'));


    
    $categorie->setNom($request->get('nom'));
    $categorie->setCodep($request->get('codep'));
    $categorie->setAdresse($request->get('adresse'));

    $entityManager->flush();

    // generate a signed url and email it to the user
    #MAILER



    //$jsonContent=$normalizer->normalize($user,'json',['groups'=>'post:read']);
    return new JsonResponse('event modifié',200);
}



}