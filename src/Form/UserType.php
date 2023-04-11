<?php

namespace App\Form;

use App\Entity\Event;
use App\Repository\EventRepository;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\CheckboxType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\CountryType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\Extension\Core\Type\EmailType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Extension\Core\Type\HiddenType;
use Symfony\Component\Form\Extension\Core\Type\IntegerType;
use Symfony\Component\Form\Extension\Core\Type\NumberType;
use Symfony\Component\Form\Extension\Core\Type\PasswordType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Validator\Constraints\File;
use Symfony\Component\Validator\Context\ExecutionContextInterface;
use Symfony\Component\Validator\Constraints;

class UserType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('nom', TextType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Nom'

                ],
                'required' => false,

            ])
            ->add('prenom', TextType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Prenom'

                ],
                'required' => false,
            ])
            ->add('password', TextType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Password',

                ],
                'constraints' => [
                    new Constraints\NotBlank(),
                    new Constraints\Callback(function($object, ExecutionContextInterface $context) {
                        $password = strval($object);


                        if (strlen($password)<8) {
                            $context
                                ->buildViolation('Password must be at least 8 characters')
                                ->addViolation();
                        }

                    }),
                ],
                'required' => true,

            ])
            ->add('address', TextType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Adresse'

                ],
                'required' => false,

            ])
            ->add('age', IntegerType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Age'

                ],
                'required' => false,

            ])
            ->add('email', EmailType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'email@exemple.com'

                ],

                'required' => false,

            ])

            ->add('num_tel', IntegerType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Numéro de téléphone',
                ],
                'constraints' => [
                    new Constraints\NotBlank(),
                    new Constraints\Callback(function($object, ExecutionContextInterface $context) {
                        $phone = strval($object);


                        if (strlen($phone)!=8) {
                            $context
                                ->buildViolation('Phone number must be 8 numbers')
                                ->addViolation();
                        }

                    }),
                ],
                'required' => true,

            ])

            ->add('role', ChoiceType::class, [
                'choices' => [
                    'ROLE_ADMIN' => 'ROLE_ADMIN',
                    'ROLE_CLIENT' => 'ROLE_CLIENT',
                    'ROLE_CONDUCTEUR' => 'ROLE_CONDUCTEUR'
                ],
                'attr' => [
                    'class' => 'form-control',
                    'data-style' => 'select-with-transition'
                ],
                'required' => true,
                'placeholder' => 'Select Role',
            ])


        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
        ]);
    }
}
