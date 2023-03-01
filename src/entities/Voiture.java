package entities;
public class Voiture {
    private int id;
    private String modele;
    private String marque;
    private int telephone;
    private String email;
    private  Double prix;

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Voiture(int id, String modele, String marque , Double prix) {
        this.id = id;
        this.modele = modele;
        this.marque = marque;
        this.prix= prix;

    }

public  Voiture(int id ){
        this.id=id;
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}