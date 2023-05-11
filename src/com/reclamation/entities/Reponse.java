package com.reclamation.entities;

import java.util.Date;
import com.reclamation.utils.*;

public class Reponse {
    
    private int id;
     private int reclamation;
     private String objectif;
     private String texte;
     private int user;
    
    public Reponse() {}

    public Reponse(int id, int reclamation, String objectif, String texte, int user) {
        this.id = id;
        this.reclamation = reclamation;
        this.objectif = objectif;
        this.texte = texte;
        this.user = user;
    }

    public Reponse(int reclamation, String objectif, String texte, int user) {
        this.reclamation = reclamation;
        this.objectif = objectif;
        this.texte = texte;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getReclamation() {
        return reclamation;
    }

    public void setReclamation(int reclamation) {
        this.reclamation = reclamation;
    }
    
    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }
    
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
    
    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    
    
    
}