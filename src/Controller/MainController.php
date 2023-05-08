<?php

namespace App\Controller;
use App\Form\CommentsType;
use App\Form\AnnoncesType;
use App\Entity\Annonces;
use App\Entity\Comments;
use App\Form\SearchFormType;
use App\Repository\AnnoncesRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Validator\Constraints\DateTime;

class MainController extends AbstractController
{
    #[Route('/main', name: 'app_main')]
    public function index(AnnoncesRepository $annoncesRepo): Response
    {
        //$annonces = $annoncesRepo->findBy(['active' => true], ['created_at' => 'desc']);
        return $this->render('main/index.html.twig', [
            'annonces' => $annoncesRepo->findBy(['active' => true], ['created_at' => 'desc']),
        ]);
    }

    #[Route('/main/details/{slug}', name: 'details')]
    public function details($slug, AnnoncesRepository $annoncesRepo, Request $request)
    {
        $annonce = $annoncesRepo->findOneBy(['slug' => $slug]);

        if(!$annonce){
            throw new NotFoundHttpException('Pas d\'annonce trouvée');
        }
        // Partie commentaires
        // On crée le commentaire "vierge"
        $comment = new Comments;

        // On génère le formulaire
        $commentForm = $this->createForm(CommentsType::class, $comment);

        $commentForm->handleRequest($request);

        // Traitement du formulaire
        if($commentForm->isSubmitted() && $commentForm->isValid()){
            
            $comment->setAnnonces($annonce);
            $user=$this->getUser();
            $comment->setUser($user);

            // On récupère le contenu du champ parentid
            $parentid = $commentForm->get("parentid")->getData();

            // On va chercher le commentaire correspondant
            $em = $this->getDoctrine()->getManager();

            if($parentid != null){
                $parent = $em->getRepository(Comments::class)->find($parentid);
            }

            // On définit le parent
            $comment->setParent($parent ?? null);

            $em->persist($comment);
            $em->flush();

            $this->addFlash('message', 'Votre commentaire a bien été envoyé');
            return $this->redirectToRoute('details', ['slug' => $annonce->getSlug()]);
        }   

        return $this->render('main/details.html.twig', [
            'annonce' => $annonce,
            'commentForm' => $commentForm->createView()
        ]);
    }
    #[Route('/main/search', name: 'search')]
    public function search(Request $request)
    {
        $form = $this->createForm(SearchFormType::class);
        $form->handleRequest($request);

        $keyword = '';
        $annonces = [];

        if ($form->isSubmitted() && $form->isValid()) {
            $keyword = $form->get('search')->getData();

            $queryBuilder = $this->getDoctrine()->getRepository(Annonces::class)->createQueryBuilder('a');
            $queryBuilder->where('a.title LIKE :keyword');
            $queryBuilder->setParameter('keyword', '%'.$keyword.'%');
            $annonces = $queryBuilder->getQuery()->getResult();
        }

        return $this->render('search/index.html.twig', [
            'form' => $form->createView(),
            'keyword' => $keyword,
            'annonces' => $annonces
        ]);
    }
    #[Route('/main/comments/supprimer/{id}', name: 'supprimercomusr')]
    public function supprimer(Comments $comment)
    {

        $em = $this->getDoctrine()->getManager();
        $em->remove($comment);
        $em->flush();

        $this->addFlash('message', 'categories supprimée avec succès');
        return $this->redirectToRoute('app_main');
    
    }

}
