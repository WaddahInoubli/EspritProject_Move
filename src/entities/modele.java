/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author tekay
 */
public class modele {
     private int id_m;
    private String marque;
    private String modele;
    private String couleur;

    public modele(int id_m, String marque, String modele, String couleur) {
        this.id_m = id_m;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
    }

    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
      //toString
    @Override
    public String toString() {
        return "modele{" + "id_m=" + id_m + ", marque=" + marque + ", modele=" + modele + ", couleur=" + couleur +'}';
    }
}
