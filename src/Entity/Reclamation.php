<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\ReclamationRepository;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation")
 * @ORM\Entity(repositoryClass="App\Repository\ReclamationRepository")
 */
class Reclamation
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="objectif", type="string", length=60, nullable=false)
     */
    private $objectif;

    /**
     * @var string
     *
     * @ORM\Column(name="text", type="string", length=300, nullable=false)
     *@Assert\Length(
     *      min = 5,
     *      max = 10,
     *      minMessage = "Your Type must be at least {{ limit }} characters long",
     *      maxMessage = "Your Type cannot be longer than {{ limit }} characters"
     * )
     * @Assert\NotBlank
     */
    private $text;

    /**
     * @var int
     *
     * @ORM\Column(name="etat", type="integer", nullable=false)
    
     */

    private $etat;
     /**
     * @var int
     *
     * @ORM\Column(name="iduser", type="integer", nullable=false)
     * @Assert\NotBlank
     */
    private $iduser;

  
    public function getId(): ?int
    {
        return $this->id;
    }

    public function getObjectif(): ?string
    {
        return $this->objectif;
    }

    public function setObjectif(string $objectif): self
    {
        $this->objectif = $objectif;

        return $this;
    }

    public function getText(): ?string
    {
        return $this->text;
    }

    public function setText(string $text): self
    {
        $this->text = $text;

        return $this;
    }

    public function getEtat(): ?int
    {
        return $this->etat;
    }

    public function setEtat(int $etat): self
    {
        $this->etat = $etat;

        return $this;
    }

    public function getIduser(): ?int
    {
        return $this->iduser;
    }

    public function setIduser(int $iduser): self
    {
        $this->iduser = $iduser;

        return $this;
    }

}
