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
public class voiture {
     private int matricule;
    private String etat;
    private int annes;
    private int prix_h;
    private int id_m;
    private String marque;
    private String modele;
    private String couleur;

    public voiture(int matricule, String etat, int annes, int prix_h, int id_m) {
        this.matricule = matricule;
        this.etat = etat;
        this.annes = annes;
        this.prix_h = prix_h;
        this.id_m = id_m;
    }

    public voiture(int matricule, String etat, int annes, int prix_h, int id_m, String marque, String modele, String couleur) {
    }

    public voiture(String matricule, String marque, String modele, String couleur, String etat, int annees, double prix_h, int id_modele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public voiture(int parseInt, int parseInt0, String text, String text0, String text1, String text2, int parseInt1, int parseInt2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     //toString
    @Override
    public String toString() {
        return "voiture{" + "matricule=" + matricule + ", etat=" + etat + ", annes=" + annes + ", prix_h=" + prix_h +", id_m=" + id_m +'}';
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setAnnees(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMarque(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setModele(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCouleur(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
