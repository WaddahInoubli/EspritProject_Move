package entities;

public class Car {


    public String couleur ;
    public String modele;
    public Double prix;
    public String matricule;

    public Car(String couleur, String modele, double prix, String matricule) {
        this.couleur = couleur;
        this.modele = modele;
        this.prix = prix;
        this.matricule = matricule;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getModele() {
        return modele;
    }

    public double getPrix() {
        return prix;
    }

    public String getMatricule() {
        return matricule;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}
