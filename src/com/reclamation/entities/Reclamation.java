package com.reclamation.entities;

import java.util.Date;
import com.reclamation.utils.*;

public class Reclamation {
    
    private int id;
     private int user;
     private String objectif;
     private String text;
     private int etat;
    
    public Reclamation() {}

    public Reclamation(int id, int user, String objectif, String text, int etat) {
        this.id = id;
        this.user = user;
        this.objectif = objectif;
        this.text = text;
        this.etat = etat;
    }

    public Reclamation(int user, String objectif, String text, int etat) {
        this.user = user;
        this.objectif = objectif;
        this.text = text;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    
    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    
    
}