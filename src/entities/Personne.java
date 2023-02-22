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
public class Personne {
    private int id;
        private int cin;
    private String nom;
    private String prenom;
    private int age;   
    private String email;

    public Personne() {
    }

    public Personne(int cin, String nom, String prenom, int age, String email) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.email = email;
    }

    
    public Personne(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne(int id, int cin, String nom, String prenom, int age , String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.cin = cin;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public int getCin() {
        return cin;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", cin=" + cin + ", email=" + email + '}';
    }
  
    
    
}
