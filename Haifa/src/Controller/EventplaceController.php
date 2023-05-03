<?php

namespace App\Controller;

use App\Entity\Eventplace;
use App\Form\EventplaceType;
use App\Repository\EventplaceRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/eventplace')]
class EventplaceController extends AbstractController
{
    #[Route('/', name: 'app_eventplace_index', methods: ['GET'])]
    public function index(EventplaceRepository $eventplaceRepository): Response
    {
        return $this->render('eventplace/index.html.twig', [
            'eventplaces' => $eventplaceRepository->findAll(),
        ]);
    }

    #[Route('/new', name: 'app_eventplace_new', methods: ['GET', 'POST'])]
    public function new(Request $request, EventplaceRepository $eventplaceRepository): Response
    {
        $eventplace = new Eventplace();
        $form = $this->createForm(EventplaceType::class, $eventplace);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $eventplaceRepository->save($eventplace, true);

            return $this->redirectToRoute('app_eventplace_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('eventplace/new.html.twig', [
            'eventplace' => $eventplace,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_eventplace_show', methods: ['GET'])]
    public function show(Eventplace $eventplace): Response
    {
        return $this->render('eventplace/show.html.twig', [
            'eventplace' => $eventplace,
        ]);
    }

    #[Route('/{id}/edit', name: 'app_eventplace_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Eventplace $eventplace, EventplaceRepository $eventplaceRepository): Response
    {
        $form = $this->createForm(EventplaceType::class, $eventplace);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $eventplaceRepository->save($eventplace, true);

            return $this->redirectToRoute('app_eventplace_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('eventplace/edit.html.twig', [
            'eventplace' => $eventplace,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_eventplace_delete', methods: ['POST'])]
    public function delete(Request $request, Eventplace $eventplace, EventplaceRepository $eventplaceRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$eventplace->getId(), $request->request->get('_token'))) {
            $eventplaceRepository->remove($eventplace, true);
        }

        return $this->redirectToRoute('app_eventplace_index', [], Response::HTTP_SEE_OTHER);
    }
}
