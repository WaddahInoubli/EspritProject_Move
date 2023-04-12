<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Voiture
 *
 * @ORM\Table(name="voiture")
 * @ORM\Entity
 */
class Voiture
{
    /**
     * @var int
     *
     * @ORM\Column(name="matricule", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $matricule;

    /**
     * @var string
     *
     * @ORM\Column(name="etat", type="string", length=500, nullable=false)
     */
    private $etat;

    /**
     * @var int
     *
     * @ORM\Column(name="annes", type="integer", nullable=false)
     */
    private $annes;

    /**
     * @var int
     *
     * @ORM\Column(name="prix_h", type="integer", nullable=false)
     */
    private $prixH;

    /**
     * @var int
     *
     * @ORM\Column(name="id_m", type="integer", nullable=false)
     */
    private $idM;

    public function getMatricule(): ?int
    {
        return $this->matricule;
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
        return $this->prixH;
    }

    public function setPrixH(int $prixH): self
    {
        $this->prixH = $prixH;

        return $this;
    }

    public function getIdM(): ?int
    {
        return $this->idM;
    }

    public function setIdM(int $idM): self
    {
        $this->idM = $idM;

        return $this;
    }


}
