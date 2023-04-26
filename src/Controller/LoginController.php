<?php

namespace App\Controller;

use App\Entity\User;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Symfony\Component\Security\Csrf\TokenGenerator\TokenGeneratorInterface;
use Symfony\Component\Security\Http\Authentication\AuthenticationUtils;

class LoginController extends AbstractController
{

    #[Route("/login", name:"app_login")]
    public function login(AuthenticationUtils $authenticationUtils)
    {
        if($this->getUser()){
            if($this->getUser()->getRoles()[0]=='ROLE_ADMIN'){
                return $this->redirectToRoute('back_users');
            }
            else{
                return $this->redirectToRoute('home');
            }
        }
        return $this->render('security/login.html.twig', [
            'last_email' => $authenticationUtils->getLastUsername(),
            'error' => $authenticationUtils->getLastAuthenticationError()
        ]);
    }


    #[Route("/logout", name:"app_logout")]
    public function logout(){
    }
    /**
     * @Route("/forget-password", name="forget_password")
     */
    public function forgetPassword(
        Request $request,
        \Swift_Mailer $mailer,
        TokenGeneratorInterface $tokenGenerator
    ): Response
    {
        if($this->getUser()){
            if($this->getUser()->getRoles()[0]=='ROLE_ADMIN'){
                return $this->redirectToRoute('back_users');
            }
            else{
                return $this->redirectToRoute('home');
            }
        }
        if ($request->isMethod('POST')) {
            $email = $request->request->get('email');
            $entityManager = $this->getDoctrine()->getManager();
            $user = $this->getDoctrine()->getRepository(User::class)->findOneBy(['email' => $email]);
            /* @var $user User */
            if ($user === null) {
                $this->addFlash('danger', 'Email introuvable !');
                return $this->redirectToRoute('forget_password');
            }
            $token = $tokenGenerator->generateToken();
            try {
                $user->setResetToken($token);
                $entityManager->flush();
            } catch (\Exception $e) {
                $this->addFlash('warning', 'Please try again');
                return $this->redirectToRoute('forget_password');
            }
            $url = $this->generateUrl('app_reset_password', array('token' => $token), UrlGeneratorInterface::ABSOLUTE_URL);
            $transport = (new \Swift_SmtpTransport('smtp.googlemail.com', 465, 'ssl'))
                ->setUsername('firas.jallali@esprit.tn')
                ->setPassword('HIDDEN')
            ;
            $mailer = new \Swift_Mailer($transport);
            $message = (new \Swift_Message('Réintialiser votre mot de passe'))
                ->setFrom('firas.jallali@esprit.tn')
                ->setTo($email)
                ->setBody(
                    $this->renderView('security/emailresetPassword.twig', ['url' => $url]),
                    'text/html'
                );
            $mailer->send($message);

            $this->addFlash('notice', 'email envoyé!');
            return $this->redirectToRoute('forget_password');
        }
        return $this->render('security/forget_password.html.twig');
    }
    /**
     * @Route("/reset_password/{token}", name="app_reset_password")
     */
    public function resetPassword(Request $request, string $token, UserPasswordEncoderInterface $passwordEncoder)
    {
        if($this->getUser()){
            if($this->getUser()->getRoles()[0]=='ROLE_ADMIN'){
                return $this->redirectToRoute('back_users');
            }
            else{
                return $this->redirectToRoute('home');
            }
        }
        $entityManager = $this->getDoctrine()->getManager();
        $user = $entityManager->getRepository(User::class)->findOneBy(['resetToken' => $token]);
        /* @var $user User */
        if (!$user) {
            $this->addFlash('danger', 'Token Not Found!');
            return $this->redirectToRoute('forget_password');
        }
        if ($request->isMethod('POST')) {

            $user->setResetToken(null);
            $user->setPassword($passwordEncoder->encodePassword($user, $request->request->get('password')));
            $entityManager->flush();
            $this->addFlash('notice', 'Le mot de passe a été modifié avec succès !');
            return $this->redirectToRoute('app_login');
        } else {
            return $this->render('security/reset_password.html.twig', ['token' => $token]);
        }
    }
}
