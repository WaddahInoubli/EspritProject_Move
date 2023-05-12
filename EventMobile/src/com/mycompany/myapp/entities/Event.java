/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author Hayfa
 */
public class Event {
    
    int idEvent;
    int idPlace;
    String nom;
    String datedeb;
    String datefin;
    String image;
    String description;
    int idUser;

    public Event(int idEvent, int idPlace, String nom, String datedeb, String datefin, String image, String description, int idUser) {
        this.idEvent = idEvent;
        this.idPlace = idPlace;
        this.nom = nom;
        this.datedeb = datedeb;
        this.datefin = datefin;
        this.image = image;
        this.description = description;
        this.idUser = idUser;
    }

    public Event() {
        this.idEvent = 0;
        this.idPlace = 0;
        this.nom = "";

        this.image = "";
        this.description = "";
        this.idUser = 0;
    }

  


    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Event{" + "idEvent=" + idEvent + ", idPlace=" + idPlace + ", nom=" + nom + ", datedeb=" + datedeb + ", datefin=" + datefin + ", image=" + image + ", description=" + description + ", idUser=" + idUser + '}';
    }


    
    
}
