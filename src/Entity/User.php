<?php

namespace App\Entity;

use App\Repository\UserRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Validator\Constraints as Assert;


#[ORM\Entity(repositoryClass: UserRepository::class)]
class User implements UserInterface
{

    public const ROLE_ADMIN = 'ROLE_ADMIN';
    public const ROLE_CLIENT = 'ROLE_CLIENT';
    public const ROLE_CONDUCTEUR = 'ROLE_CONDUCTEUR';


    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id;


    #[ORM\Column]
    #[Assert\NotBlank(message:"Le nom est requis")]
    #[Assert\Length(max:255, maxMessage:'Le nom ne peut pas dépasser {{ limit }} caractères')]
    private ?string $nom;


    #[ORM\Column]
    #[Assert\NotBlank(message:"Le prénom est requis")]
    #[Assert\Length(max:255, maxMessage:"Le prénom ne peut pas dépasser {{ limit }} caractères")]
    private ?string $prenom;


    #[ORM\Column]
    #[Assert\NotBlank(message:"L'adresse email est requise")]
    #[Assert\Email(message:"L'adresse email '{{ value }}' n'est pas valide.")]
    #[Assert\Length(max:255, maxMessage:"L'adresse email ne peut pas dépasser {{ limit }} caractères")]
    private ?string $email;



    #[ORM\Column]
    #[Assert\NotBlank(message:"Le numéro de téléphone est requis")]
    #[Assert\Length(min:8,minMessage:"Le numéro de téléphone doit etre compose au moins de {{ limit }} chiffres")]
    private ?string $num_tel;


    #[ORM\Column]
    #[Assert\NotBlank(message:"Le rôle est requis")]
    #[Assert\Length(max:255, maxMessage:"Le rôle ne peut pas dépasser {{ limit }} caractères")]
    private ?string $role;


    #[ORM\Column]
    #[Assert\NotBlank(message:"L'adresse est requise")]
    #[Assert\Length(max:255, maxMessage:"L'adresse ne peut pas dépasser {{ limit }} caractères")]
    private ?string $address;


    #[ORM\Column]
    #[Assert\NotBlank(message:"L'âge est requis")]
    #[Assert\Positive(message:"L'âge doit être un nombre positif")]
    private ?int $age;


    #[ORM\Column]
    #[Assert\Length(min:8, minMessage:"Le mot de passe doit contenir au moins {{ limit }} caractéres")]
    private ?string $password;

    #[ORM\Column]
    private ?string  $resetToken;
    public function __construct()
    {

    }

    public function getId(): ?int
    {
        return $this->id;
    }


    public function getNom()
    {
        return $this->nom;
    }


    public function setNom($nom): void
    {
        $this->nom = $nom;
    }



    public function getPrenom()
    {
        return $this->prenom;
    }



    public function setPrenom($prenom): void
    {
        $this->prenom = $prenom;
    }



    public function getNumTel()
    {
        return $this->num_tel;
    }



    public function setNumTel($num_tel): void
    {
        $this->num_tel = $num_tel;
    }


    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): self
    {
        $this->email = $email;

        return $this;
    }



    public function getPassword()
    {
        return $this->password;
    }



    public function setPassword(string $password): void
    {
        $this->password = $password;
    }


    public function getRole()
    {
        return $this->role;
    }



    public function setRole($role): void
    {
        $this->role = $role;
    }




    public function getSalt()
    {
        // TODO: Implement getSalt() method.
    }

    public function getUsername()
    {
        return (string)$this->email;
    }

    public function eraseCredentials()
    {
        // TODO: Implement eraseCredentials() method.
    }


    public function getRoles()
    {
        return [$this->role];
    }



    public function getAddress()
    {
        return $this->address;
    }



    public function setAddress($address): void
    {
        $this->address = $address;
    }



    public function getAge()
    {
        return $this->age;
    }



    public function setAge($age): void
    {
        $this->age = $age;
    }

    /**
     * @return string|null
     */
    public function getResetToken(): ?string
    {
        return $this->resetToken;
    }

    /**
     * @param string|null $resetToken
     */
    public function setResetToken(?string $resetToken): void
    {
        $this->resetToken = $resetToken;
    }



}
