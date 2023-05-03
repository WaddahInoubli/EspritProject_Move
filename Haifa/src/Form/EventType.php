<?php

namespace App\Form;

use App\Entity\Event;
use App\Entity\Eventplace;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Validator\Constraints\File;
use Symfony\Component\Form\Extension\Core\Type\ResetType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\DateTimeType;




class EventType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nom')
            ->add('datedeb', DateTimeType::class, [
                'widget' => 'single_text',
                'empty_data' => null,

            ])
            ->add('datefin', DateTimeType::class, [
                'widget' => 'single_text',
                'empty_data' => null,

            ])
            
            ->add('image', FileType::class, [    
                'mapped' => false,
                'required' => false,
                'constraints' => [
                    new File([
                        'maxSize' => '1024k',
                        'mimeTypes' => [
                            'image/png',
                            'image/jpg',
                            'image/jpeg',
                        ],
                        'mimeTypesMessage' => 'déposez votre image',
                    ])
                ],
            ]) 
            ->add('description')
            ->add('place', EntityType::class,[
                'class'=>Eventplace::class,
                    'choice_label'=>'id',
                ])
            ->add('submit', SubmitType::class)
            ->add('cancel', ResetType::class);
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Event::class,
        ]);
    }
}
