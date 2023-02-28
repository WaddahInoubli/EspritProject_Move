/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author tekay
 */
public class voiture {
     private int matricule;
    private String etat;
    private int annes;
    private int prix_h;
    private int id_m;

    public voiture() {
    }

    public voiture(int matricule, String etat, int annes, int prix_h, int id_m) {
        this.matricule = matricule;
        this.etat = etat;
        this.annes = annes;
        this.prix_h = prix_h;
        this.id_m = id_m;
    }

    public voiture(String etat, int annes, int prix_h, int id_m) {
        this.etat = etat;
        this.annes = annes;
        this.prix_h = prix_h;
        this.id_m = id_m;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getAnnes() {
        return annes;
    }

    public void setAnnes(int annes) {
        this.annes = annes;
    }

    public int getPrix_h() {
        return prix_h;
    }

    public void setPrix_h(int prix_h) {
        this.prix_h = prix_h;
    }

    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }





   
}
