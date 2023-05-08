<?php


namespace App\Controller\Admin;

use MercurySeries\FlashyBundle\FlashyNotifier;
use Knp\Component\Pager\PaginatorInterface;
use App\Form\CategoriesType;
use App\Entity\Categories;
use App\Repository\CategoriesRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;

class CategoriesController extends AbstractController
{
    #[Route('/admin/categories', name: 'admin_categories_')]
    public function index(Request $request,CategoriesRepository $catsRepo,PaginatorInterface $paginator)
    {
        $catgs = $catsRepo->findAll();
        $catgs = $paginator->paginate(
            $catgs, /* query NOT result */
            $request->query->getInt('page', 1),
            3
        );
        return $this->render('admin/categories/index.html.twig', [
            'categories' => $catgs,
        ]);
    }
    
    #[Route('admin/categories/ajout', name: 'categories_ajout')]
    public function ajoutcategories(Request $request,FlashyNotifier $flashy): Response
    {
        $categorie = new Categories;

        $form = $this->createForm(CategoriesType::class, $categorie);

        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($categorie);
            $em->flush();
            $flashy->success('categorie created!', 'admin/categories/ajout.html.twig');
            return $this->redirectToRoute('admin_categories_');
        }


        return $this->render('admin/categories/ajout.html.twig', [
            'form' => $form->createView()
        ]);
    }
    #[Route('/modifier/{id}', name: 'categories_modifier')]
    public function ModifCategorie(Categories $categorie, Request $request,FlashyNotifier $flashy)
    {
        $form = $this->createForm(CategoriesType::class, $categorie);

        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($categorie);
            $em->flush();

            $flashy->primary('categorie modifié!', 'admin/categories/ajout.html.twig');
            return $this->redirectToRoute('admin_categories_');
        }

        return $this->render('admin/categories/ajout.html.twig', [
            'form' => $form->createView()
        ]);
    }

    #[Route('/admin/categories/supprimer/{id}', name: 'supprimerc')]
    public function supprimer(Categories $categorie,FlashyNotifier $flashy)
    {

        $em = $this->getDoctrine()->getManager();
        $em->remove($categorie);
        $em->flush();
        $flashy->error('categorie supprimé!', 'admin/categories/ajout.html.twig');

        $this->addFlash('message', 'categories supprimée avec succès');
        return $this->redirectToRoute('admin_categories_');
    }
}
