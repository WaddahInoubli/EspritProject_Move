<?php

namespace App\Controller;

use App\Entity\Event;
use App\Form\EventType;
use App\Repository\EventRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\String\Slugger\SluggerInterface;
use MercurySeries\FlashyBundle\FlashyNotifier;




#[Route('/event')]
class EventController extends AbstractController
{
    #[Route('/', name: 'app_event_index', methods: ['GET'])]
    public function index(EventRepository $eventRepository): Response
    {
        $events=$eventRepository->findAll();
        $rdvs = [];
        foreach ($events as $event)
        {
            $rdvs[]=[
                'title'=>$event->getNom(),
                'start'=>$event->getDatedeb()->format("Y-m-d"),
                'end'=>$event->getDatefin()->format("Y-m-d"),
                'backgroundColor'=> '#0ec51',
                'borderColor'=> 'green',
                'textColor' => 'black'
            ];
        }
        $data = json_encode($rdvs);

        return $this->render('event/index.html.twig' ,compact('data', 'events'));
    }

    #[Route('/front', name: 'app_eventfront_index', methods: ['GET'])]
    public function indexfront(EventRepository $eventRepository): Response
    {
        return $this->render('event/events.html.twig', [
            'events' => $eventRepository->findAll(),
        ]);
    }

    #[Route('/new', name: 'app_event_new', methods: ['GET', 'POST'])]
    public function new(Request $request, EventRepository $eventRepository,  SluggerInterface $slugger,  FlashyNotifier $flashy): Response
    {
        $event = new Event();
        $form = $this->createForm(EventType::class, $event);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

            $brochureFile = $form->get('image')->getData();

            // this condition is needed because the 'brochure' field is not required
            // so the PDF file must be processed only when a file is uploaded
            if ($brochureFile) {
                $originalFilename = pathinfo($brochureFile->getClientOriginalName(), PATHINFO_FILENAME);
                // this is needed to safely include the file name as part of the URL
                $safeFilename = $slugger->slug($originalFilename);
                $newFilename = $safeFilename.'-'.uniqid().'.'.$brochureFile->guessExtension();

                // Move the file to the directory where brochures are stored
                try {
                    $brochureFile->move(
                        $this->getParameter('images_directory'),
                        $newFilename
                    );
                } catch (FileException $e) {
                    // ... handle exception if something happens during file upload
                }

                // updates the 'brochureFilename' property to store the PDF file name
                // instead of its contents
                $event->setImage($newFilename);
                $user=$this->getUser();
                $event->setUser($user);
            }
            $eventRepository->save($event, true);
            $this->addFlash('success', 'This event added successfully');

            return $this->redirectToRoute('app_event_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('event/new.html.twig', [
            'event' => $event,
            'form' => $form,
            'flashy' => $flashy,
        ]);
    }

    
    #[Route('/searcheventajax', name: 'app_searchevent')]
     public function searchajax(Request $request ,EventRepository $repository)
     {
         $repository = $this->getDoctrine()->getRepository(Event::class);
         $requestString=$request->get('searchValue');
         $post = $repository->findEventbyname($requestString);
         // $tache=$repository->findAll();
 
         return $this->render('event/ajax.html.twig', [
             "events"=>$post,
         ]);
     }


     #[Route('/date', name: 'app_event_date')]
    function decroissantDate(EventRepository $repository){
        $events = $repository->trie_decroissant_date();
        $rdvs = [];
        foreach ($events as $event)
        {
            $rdvs[]=[
                'title'=>$event->getNom(),
                'start'=>$event->getDatedeb()->format("Y-m-d"),
                'end'=>$event->getDatefin()->format("Y-m-d"),
                'backgroundColor'=> '#0ec51',
                'borderColor'=> 'green',
                'textColor' => 'black'
            ];
        }
        $data = json_encode($rdvs);
        
        return $this->render('event/index.html.twig',compact('data', 'events'));
    }


    #[Route('/dateF', name: 'app_event_dateFin')]
    function decroissantDateF(EventRepository $repository){
        $events = $repository->trie_decroissant_dateF();
        $rdvs = [];
        foreach ($events as $event)
        {
            $rdvs[]=[
                'title'=>$event->getNom(),
                'start'=>$event->getDatedeb()->format("Y-m-d"),
                'end'=>$event->getDatefin()->format("Y-m-d"),
                'backgroundColor'=> '#0ec51',
                'borderColor'=> 'green',
                'textColor' => 'black'
            ];
        }
        $data = json_encode($rdvs);
        
        return $this->render('event/index.html.twig',compact('data', 'events'));
    }

    #[Route('/nom', name: 'app_event_nom')]
    function decroissantNom(EventRepository $repository){
        $events = $repository->trie_decroissant_nom();
        $rdvs = [];
        foreach ($events as $event)
        {
            $rdvs[]=[
                'title'=>$event->getNom(),
                'start'=>$event->getDatedeb()->format("Y-m-d"),
                'end'=>$event->getDatefin()->format("Y-m-d"),
                'backgroundColor'=> '#0ec51',
                'borderColor'=> 'green',
                'textColor' => 'black'
            ];
        }
        $data = json_encode($rdvs);
        
        return $this->render('event/index.html.twig',compact('data', 'events'));
    }


    #[Route('/front/new', name: 'app_eventfront_new', methods: ['GET', 'POST'])]
    public function frontnew(Request $request, EventRepository $eventRepository,  SluggerInterface $slugger): Response
    {
        $event = new Event();
        $form = $this->createForm(EventType::class, $event);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

            $brochureFile = $form->get('image')->getData();

            // this condition is needed because the 'brochure' field is not required
            // so the PDF file must be processed only when a file is uploaded
            if ($brochureFile) {
                $originalFilename = pathinfo($brochureFile->getClientOriginalName(), PATHINFO_FILENAME);
                // this is needed to safely include the file name as part of the URL
                $safeFilename = $slugger->slug($originalFilename);
                $newFilename = $safeFilename.'-'.uniqid().'.'.$brochureFile->guessExtension();

                // Move the file to the directory where brochures are stored
                try {
                    $brochureFile->move(
                        $this->getParameter('post_image'),
                        $newFilename
                    );
                } catch (FileException $e) {
                    // ... handle exception if something happens during file upload
                }

                // updates the 'brochureFilename' property to store the PDF file name
                // instead of its contents
                $event->setImage($newFilename); 
            }
            $eventRepository->save($event, true);

            return $this->redirectToRoute('app_eventfront_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('event/addEvent.html.twig', [
            'event' => $event,
            'form' => $form,
        ]);
    }

    #[Route('/front/{id}', name: 'app_eventfront_details', methods: ['GET'])]
    public function eventdetails(Event $event): Response
    {
        return $this->render('event/event.html.twig', [
            'event' => $event,
        ]);
    }

    #[Route('/{id}', name: 'app_event_show', methods: ['GET'])]
    public function show(Event $event): Response
    {
        return $this->render('event/show.html.twig', [
            'event' => $event,
        ]);
    }

    #[Route('/{id}/edit', name: 'app_event_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Event $event, EventRepository $eventRepository, SluggerInterface $slugger): Response
    {
        $form = $this->createForm(EventType::class, $event);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $brochureFile = $form->get('image')->getData();

            // this condition is needed because the 'brochure' field is not required
            // so the PDF file must be processed only when a file is uploaded
            if ($brochureFile) {
                $originalFilename = pathinfo($brochureFile->getClientOriginalName(), PATHINFO_FILENAME);
                // this is needed to safely include the file name as part of the URL
                $safeFilename = $slugger->slug($originalFilename);
                $newFilename = $safeFilename.'-'.uniqid().'.'.$brochureFile->guessExtension();

                // Move the file to the directory where brochures are stored
                try {
                    $brochureFile->move(
                        $this->getParameter('post_image'),
                        $newFilename
                    );
                } catch (FileException $e) {
                    // ... handle exception if something happens during file upload
                }

                // updates the 'brochureFilename' property to store the PDF file name
                // instead of its contents
                $event->setImage($newFilename); 
            }
            $eventRepository->save($event, true);

            return $this->redirectToRoute('app_event_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('event/edit.html.twig', [
            'event' => $event,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_event_delete', methods: ['POST'])]
    public function delete(Request $request, Event $event, EventRepository $eventRepository,FlashyNotifier $flashy): Response
    {
        if ($this->isCsrfTokenValid('delete'.$event->getId(), $request->request->get('_token'))) {
            $eventRepository->remove($event, true);
            $this->addFlash('danger', 'This post removed successfully');
        }

        return $this->redirectToRoute('app_event_index', [], Response::HTTP_SEE_OTHER);
    }
}
