/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Andrew
 */
public class User {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String adresse;
    private String numTel;
    private String email;
    private String role;
    private String motDePasse;
    private Boolean active;

    public User(int id, String nom, String prenom, int age, String adresse, String numTel, String email, String role, String motDePasse, Boolean active) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.numTel = numTel;
        this.email = email;
        this.role = role;
        this.motDePasse = motDePasse;
        this.active = active;
    }

    public User(String nom, String prenom, int age, String adresse, String numTel, String email, String role, String motDePasse, Boolean active) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.numTel = numTel;
        this.email = email;
        this.role = role;
        this.motDePasse = motDePasse;
        this.active = active;
    }

   
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", adresse=" + adresse + ", numTel=" + numTel + ", email=" + email + ", role=" + role + ", motDePasse=" + motDePasse + ", active=" + active + '}';
    }

    
   
    
}
