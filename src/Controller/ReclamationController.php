<?php

namespace App\Controller;
use App\Repository\ReponseRepository;
use App\Entity\Reclamation;
use App\Form\ReclamationType;
use App\Repository\ReclamationRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Component\Mailer\MailerInterface;
use Symfony\Component\Mime\Email;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\HttpFoundation\JsonResponse;
/**
 * @Route("/reclamation")
 */
class ReclamationController extends AbstractController
{
    /**
     * @Route("/", name="app_reclamation_index", methods={"GET"})
     */
    public function index(Request $request,ReclamationRepository $reclamationRepository,PaginatorInterface $paginator): Response
    {
        $data =$reclamationRepository->findAll();
        $user = $this->getUser();
        $reclamations = $paginator->paginate(
            $data,
            $request->query->getInt('page',1),
            6
        );
        return $this->render('reclamation/index.html.twig', [
            'reclamations' => $reclamations,
            'user' => $user,
        ]);
    }
    /**
     * @Route("/front", name="app_reclamation_indexfront", methods={"GET"})
     */
    public function indexfront(Request $request,ReclamationRepository $reclamationRepository): Response
    {
        $user=$this->getUser();
        $reclamations = $reclamationRepository->findBy(['iduser' => $user]);
        return $this->render('reclamation/reclamationfront.html.twig', [
            'reclamations' => $reclamations
        ]);
    }
    private function SendMail(?string $email, MailerInterface $mailer,?string $desc)
    {
        $mail = (new Email())
            ->from('devcompi2023@gmail.com')
            ->to($email)
            ->subject('signaler publication')
            ->text("Bonjour admin, 
                .{$desc}
            ");
        $mailer->send($mail);
    }

    /**
     * @Route("/reclamation/search", name="app_reclamation_search", methods={"GET"})
     */
    public function search(Request $request, ReclamationRepository $reclamationRepository, SerializerInterface $serializer): Response
    {
        $query = $request->query->get('query');

        $recs = $reclamationRepository->createQueryBuilder('u')
            ->where('u.id LIKE :query')
            ->orWhere('u.objectif LIKE :query')
            ->orWhere('u.text LIKE :query')
            ->orWhere('u.etat LIKE :query')
            ->setParameter('query', '%' . $query . '%')
            ->getQuery()
            ->getResult();

        // Serialize the users to HTML
        $json = $serializer->serialize($recs, 'json');

        // Return the search results as JSON
        return new JsonResponse($json);
    }

    /**
     * @Route("/new", name="app_reclamation_new", methods={"GET", "POST"})
     */
    public function new(Request $request,MailerInterface $mailer, ReclamationRepository $reclamationRepository): Response
    {$admin="rania.heni@esprit.tn";
        $reclamation = new Reclamation();
        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $desc="l'ululisateur avec id:".$reclamation->getIduser() . "a ajouté une reclamation d'objectif :" .$reclamation->getObjectif();
            $reclamation->setEtat(0);
            $user=$this->getUser();
            $reclamation->setIduser($user);
            $reclamationRepository->save($reclamation, true);
          $this->SendMail($admin,$mailer,$desc);
            return $this->redirectToRoute('app_reclamation_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('reclamation/new.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form,
        ]);
    }

    /**
     * @Route("/{id}/show", name="app_reclamation_show", methods={"GET"})
     */
    public function show(Reclamation $reclamation,$id,ReponseRepository $reponseRepository): Response
    {
        $id=$reclamation->getId();

        $criteria = ['idrec' => $id];
        $orderBy = ['id' => 'DESC'];
        $limit = 1;
        $offset = 0;
        return $this->render('reclamation/show.html.twig', [
            'reclamation' => $reclamation,
            'reponses'=> $reponseRepository->findBy($criteria, $orderBy, $limit, $offset),
        ]);
    }
    /**
     * @Route("/{id}/showf", name="app_reclamation_showfront", methods={"GET"})
     */
    public function showfront(Reclamation $reclamation,$id,ReponseRepository $reponseRepository): Response
    {
        $id=$reclamation->getId();

        $criteria = ['idrec' => $id];
        $orderBy = ['id' => 'DESC'];
        $limit = 1;
        $offset = 0;
        return $this->render('reclamation/showfront.html.twig', [
            'reclamation' => $reclamation,
            'reponses'=> $reponseRepository->findBy($criteria, $orderBy, $limit, $offset),
        ]);
    }
    /**
     * @Route("/{id}/edit", name="app_reclamation_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Reclamation $reclamation, ReclamationRepository $reclamationRepository): Response
    {
        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $reclamation->setEtat(0);
            $reclamation->setIduser(222);
            $reclamationRepository->add($reclamation, true);

            return $this->redirectToRoute('app_reclamation_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('reclamation/edit.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form,
        ]);
    }

    /**
     * @Route("/{id}", name="app_reclamation_delete", methods={"GET"})
     */
    public function delete(Request $request, Reclamation $reclamation, ReclamationRepository $reclamationRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$reclamation->getId(), $request->request->get('_token'))) {
            $reclamationRepository->remove($reclamation, true);
        }

        return $this->redirectToRoute('app_reclamation_index', [], Response::HTTP_SEE_OTHER);
    }


}
