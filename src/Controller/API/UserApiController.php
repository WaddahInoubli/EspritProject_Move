<?php

namespace App\Controller\API;

use App\Entity\User;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Symfony\Component\Validator\Validator\ValidatorInterface;


#[Route('/api/users')]
class UserApiController extends AbstractController {



    #[Route("/", name:"index_user_api",methods: "GET")]
    public function users(): Response
    {
        $users=$this->getDoctrine()->getRepository(User::class)->findAll();
        $data = [];

        foreach ($users as $user) {
            $data[] = [
                'id' => $user->getId(),
                'nom' => $user->getNom(),
                'prenom' => $user->getPrenom(),
                'adresse'=>$user->getAddress(),
                'age'=>$user->getAge(),
                'numTel'=>$user->getNumTel(),
                'role'=>$user->getRole(),
                'password'=>$user->getPassword(),
                'email'=>$user->getEmail()
            ];
        }
        return $this->json($data);
    }


    #[Route("/{id}", name:"get_user_api",methods: "GET")]
    public function getOneUser($id): Response
    {
        $user =$this->getDoctrine()->getRepository(User::class)->find($id);
        if (!$user) {
            return $this->json('No user found for id' . $id, 404);
        }

            $data[] = [
                'id' => $user->getId(),
                'nom' => $user->getNom(),
                'prenom' => $user->getPrenom(),
                'adresse'=>$user->getAddress(),
                'age'=>$user->getAge(),
                'numTel'=>$user->getNumTel(),
                'role'=>$user->getRole(),
                'password'=>$user->getPassword(),
                'email'=>$user->getEmail()
            ];

        return $this->json($data);
    }

    #[Route("/", name:"add_user_api",methods: "POST")]
    public function newUser(Request $request, UserPasswordEncoderInterface $passwordEncoder,ValidatorInterface $validator): Response
    {
        $user =new User();
        $user->setNom($request->request->get('nom'));
        $user->setPrenom($request->request->get('prenom'));
        $user->setEmail($request->request->get('email'));
        $user->setAge($request->request->get('age'));
        $user->setAddress($request->request->get('address'));
        $user->setNumTel($request->request->get('num_tel'));
        $user->setRole($request->request->get('role'));
        $user->setPassword($passwordEncoder->encodePassword($user,$request->request->get('password')));
        $errors = $validator->validate($user);
        if (count($errors) > 0) {
            return $this->json('User no valide ' , 404);
        }
        if(!empty($this->getDoctrine()->getRepository(User::class)->findOneBy(['email' => $request->request->get('email')]))){
            return $this->json('Duplicated email' , 404);
        }
        $entityManager = $this->getDoctrine()->getManager();
        $entityManager->persist($user);
        $this->getDoctrine()->getManager()->flush();
        return $this->json('Created new user successfully with id ' . $user->getId());
    }

    #[Route("/{id}", name:"edit_user_api",methods: "PUT")]
    public function editUser(Request $request, $id, UserPasswordEncoderInterface $passwordEncoder,ValidatorInterface $validator): Response
    {
        $user =$this->getDoctrine()->getRepository(User::class)->find($id);
        $user->setNom($request->request->get('nom'));
        $user->setPrenom($request->request->get('prenom'));
        $user->setEmail($request->request->get('email'));
        $user->setAge($request->request->get('age'));
        $user->setAddress($request->request->get('address'));
        $user->setNumTel($request->request->get('num_tel'));
        $user->setRole($request->request->get('role'));
        $user->setPassword($passwordEncoder->encodePassword($user,$request->request->get('password')));
        $errors = $validator->validate($user);
        if (count($errors) > 0) {
            return $this->json('User no valide ' , 404);
        }
        if(count($this->getDoctrine()->getRepository(User::class)->findBy(['email' => $request->request->get('email')]))>1){
            return $this->json('Duplicated email' , 404);
        }
        $entityManager = $this->getDoctrine()->getManager();
        $entityManager->persist($user);
        $this->getDoctrine()->getManager()->flush();
        return $this->json('user modified successfully with id ' . $user->getId());
    }


    #[Route("/{id}", name:"delete_user_api",methods: "DELETE")]
    public function deleteUser($id): Response
    {
        $user =$this->getDoctrine()->getRepository(User::class)->find($id);
        if (!$user) {
            return $this->json('No user found for id ' . $id, 404);
        }
        $em = $this->getDoctrine()->getManager();
        $em->remove($user);
        $em->flush();
        return $this->json('User is deleted successfully with id ' . $id);
    }

}
