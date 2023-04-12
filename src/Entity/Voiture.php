<?php

namespace App\Entity;

use App\Repository\VoitureRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
#[ORM\Entity(repositoryClass: VoitureRepository::class)]
class Voiture
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    #[Assert\NotBlank(message:"etat is required")]
    private ?string $etat = null;

    #[ORM\Column]
    #[Assert\NotBlank(message:"annes is required")]
    private ?int $annes = null;

    #[ORM\Column]
    #[Assert\NotBlank(message:"prix is required")]
    private ?int $prix_h = null;

    #[ORM\ManyToOne(inversedBy: 'voiture')]
    private ?Modele $modele = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getEtat(): ?string
    {
        return $this->etat;
    }

    public function setEtat(string $etat): self
    {
        $this->etat = $etat;

        return $this;
    }

    public function getAnnes(): ?int
    {
        return $this->annes;
    }

    public function setAnnes(int $annes): self
    {
        $this->annes = $annes;

        return $this;
    }

    public function getPrixH(): ?int
    {
        return $this->prix_h;
    }

    public function setPrixH(int $prix_h): self
    {
        $this->prix_h = $prix_h;

        return $this;
    }

    public function getModele(): ?Modele
    {
        return $this->modele;
    }

    public function setModele(?Modele $modele): self
    {
        $this->modele = $modele;

        return $this;
    }
}
