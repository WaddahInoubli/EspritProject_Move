<?php


namespace App\Controller;

use App\Entity\Event;
use App\Entity\Eventplace;
use App\Entity\User;
use App\Form\UserType;

use App\Form\EventplaceType;
use App\Form\EventType;
use App\Repository\EventRepository;
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
class EventMobileController extends AbstractController
{

    #[Route('/event/mobile', name: 'app_event_mobile')]
    public function index(): Response
    {
        return $this->render('/index.html.twig', [
            'controller_name' => 'EventMobileController',
        ]);
    }

   
#[Route('/eventJSON', name: 'lapp_event_mobile')]
public function findall(EventRepository $eventRepository): Response
{
    $events=$eventRepository->findAll();
    $rdvs = [];
    foreach ($events as $event)
    {
        $rdvs[]=[
            'id'=>$event->getId(),
            'nom'=>$event->getNom(),
            'datedeb'=>$event->getDatedeb()->format("Y-m-d"),
            'datefin'=>$event->getDatefin()->format("Y-m-d"),
            'description'=>$event->getDescription()
        ];
    }
    $jsonData = json_encode($rdvs);

    return new JsonResponse($jsonData, Response::HTTP_OK, [], true);
}




#[Route('/removeeventJSON', name: 'rapp_event_mobile')]
public function removeJSON2(Request $request,EventRepository $rep, NormalizerInterface $normalizer, EntityManagerInterface $entityManager): Response
{
    $event = $rep->find($request->get('id'));


    $entityManager->remove($event);


    $entityManager->flush();

    // generate a signed url and email it to the user
    #MAILER



    //$jsonContent=$normalizer->normalize($user,'json',['groups'=>'post:read']);
    return new JsonResponse('event supprimé',200);
}   




#[Route('/addeventJSON', name: 'aapp_event_mobile')]
public function addJSON2(Request $request, NormalizerInterface $normalizer, EntityManagerInterface $entityManager ,EventplaceRepository $epr): Response
{
    $categorie = new Event();

    $id=$request->get('place_id');
    $idUser=$request->get('user_id');
    $entityManager = $this->getDoctrine()->getManager();

    $user=$entityManager->getRepository(User::class)->find($idUser);
    $place = $entityManager->getRepository(Eventplace::class)->find($id);
 

    $categorie->setNom($request->get('nom'));
    $categorie->setDatedeb(new DateTime($request->get('datedeb')));
    $categorie->setDatefin(new DateTime($request->get('datefin')));
    $categorie->setDescription($request->get('description'));
    $categorie->setPlace($place);
    $categorie->setUser($user);
    $categorie->setImage($request->get('image'));



    $entityManager->persist($categorie);
    $entityManager->flush();

    // generate a signed url and email it to the user
    #MAILER



    //$jsonContent=$normalizer->normalize($user,'json',['groups'=>'post:read']);
    return new JsonResponse('event ajouté',200);
}






  
    #[Route('/editeventJSON', name: 'eapp_event_mobile')]
    public function editJSON2(Request $request,EventRepository $rep, NormalizerInterface $normalizer, EntityManagerInterface $entityManager): Response
    {
        $categorie = $rep->find($request->get('id'));


        
        $categorie->setNom($request->get('nom'));
        $categorie->setDatedeb(new DateTime($request->get('datedeb')));
        $categorie->setDatefin(new DateTime($request->get('datefin')));
        $categorie->setDescription($request->get('description'));

        $entityManager->flush();

        // generate a signed url and email it to the user
        #MAILER



        //$jsonContent=$normalizer->normalize($user,'json',['groups'=>'post:read']);
        return new JsonResponse('event modifié',200);
    }

   





}