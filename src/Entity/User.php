<?php

namespace App\Entity;

use App\Repository\UserRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Validator\Constraints as Assert;


#[ORM\Entity(repositoryClass: UserRepository::class)]
class User implements UserInterface
{

    public const ROLE_ADMIN = 'ADMIN';
    public const ROLE_CLIENT = 'CLIENT';
    public const ROLE_CONDUCTEUR = 'CONDUCTEUR';


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

    #[ORM\Column(length: 180,type:"string")]
    private $reset_token="";

    #[ORM\OneToMany(mappedBy: 'iduser', targetEntity: Reclamation::class)]
    private Collection $reclamations;

    #[ORM\OneToMany(mappedBy: 'idUser', targetEntity: Reponse::class)]
    private Collection $reponses;

    #[ORM\OneToMany(mappedBy: 'user', targetEntity: Event::class)]
    private Collection $events;


    #[ORM\OneToMany(mappedBy: 'user', targetEntity: Voiture::class)]
    private Collection $voitures;


    #[ORM\OneToMany(mappedBy: 'Name_User', targetEntity: Annonces::class)]
    private Collection $annonces;

    #[ORM\OneToMany(mappedBy: 'user', targetEntity: Comments::class)]
    private Collection $comments;

    public function __construct()
    {
        $this->reclamations = new ArrayCollection();
        $this->reponses = new ArrayCollection();
        $this->events = new ArrayCollection();
        $this->voitures = new ArrayCollection();
        $this->annonces = new ArrayCollection();
        $this->comments = new ArrayCollection();
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
     * @return mixed
     */
    public function getResetToken()
    {
        return $this->reset_token;
    }


    /**
     * @param mixed $reset_token
     */
    public function setResetToken($reset_token): void
    {
        $this->reset_token = $reset_token;
    }

    /**
     * @return Collection<int, Reclamation>
     */
    public function getReclamations(): Collection
    {
        return $this->reclamations;
    }

    public function addReclamation(Reclamation $reclamation): self
    {
        if (!$this->reclamations->contains($reclamation)) {
            $this->reclamations->add($reclamation);
            $reclamation->setIduser($this);
        }

        return $this;
    }

    public function removeReclamation(Reclamation $reclamation): self
    {
        if ($this->reclamations->removeElement($reclamation)) {
            // set the owning side to null (unless already changed)
            if ($reclamation->getIduser() === $this) {
                $reclamation->setIduser(null);
            }
        }

        return $this;
    }

    /**
     * @return Collection<int, Reponse>
     */
    public function getReponses(): Collection
    {
        return $this->reponses;
    }

    public function addReponse(Reponse $reponse): self
    {
        if (!$this->reponses->contains($reponse)) {
            $this->reponses->add($reponse);
            $reponse->setIdUser($this);
        }

        return $this;
    }

    public function removeReponse(Reponse $reponse): self
    {
        if ($this->reponses->removeElement($reponse)) {
            // set the owning side to null (unless already changed)
            if ($reponse->getIdUser() === $this) {
                $reponse->setIdUser(null);
            }
        }

        return $this;
    }

    /**
     * @return Collection<int, Event>
     */
    public function getEvents(): Collection
    {
        return $this->events;
    }

    public function addEvent(Event $event): self
    {
        if (!$this->events->contains($event)) {
            $this->events->add($event);
            $event->setUser($this);
        }

        return $this;
    }

    public function removeEvent(Event $event): self
    {
        if ($this->events->removeElement($event)) {
            // set the owning side to null (unless already changed)
            if ($event->getUser() === $this) {
                $event->setUser(null);
            }
        }

        return $this;
    }


    /**
     * @return Collection<int, Voiture>
     */
    public function getVoitures(): Collection
    {
        return $this->voitures;
    }

    public function addVoiture(Voiture $voiture): self
    {
        if (!$this->voitures->contains($voiture)) {
            $this->voitures->add($voiture);
            $voiture->setUser($this);
        }

        return $this;
    }

    public function removeVoiture(Voiture $voiture): self
    {
        if ($this->voitures->removeElement($voiture)) {
            // set the owning side to null (unless already changed)
            if ($voiture->getUser() === $this) {
                $voiture->setUser(null);
            }
        }

        return $this;
    }



    /**
     * @return Collection<int, Annonces>
     */
    public function getAnnonces(): Collection
    {
        return $this->annonces;
    }

    public function addAnnonce(Annonces $annonce): self
    {
        if (!$this->annonces->contains($annonce)) {
            $this->annonces->add($annonce);
            $annonce->setNameUser($this);
        }

        return $this;
    }

    public function removeAnnonce(Annonces $annonce): self
    {
        if ($this->annonces->removeElement($annonce)) {
            // set the owning side to null (unless already changed)
            if ($annonce->getNameUser() === $this) {
                $annonce->setNameUser(null);
            }
        }

        return $this;
    }

    /**
     * @return Collection<int, Comments>
     */
    public function getComments(): Collection
    {
        return $this->comments;
    }

    public function addComment(Comments $comment): self
    {
        if (!$this->comments->contains($comment)) {
            $this->comments->add($comment);
            $comment->setUser($this);
        }

        return $this;
    }

    public function removeComment(Comments $comment): self
    {
        if ($this->comments->removeElement($comment)) {
            // set the owning side to null (unless already changed)
            if ($comment->getUser() === $this) {
                $comment->setUser(null);
            }
        }

        return $this;
    }
    public function __toString()
    {
        return $this->nom; // Assuming `name` is a property that holds a string value
    }






}
