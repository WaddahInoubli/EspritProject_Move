/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;

/**
 *
 * @author Andrew
 */
public class Reservation {
private  int id ;
private  int id_client_FK ;
private  int id_voiture_FK ;
private  int id_chaufeur_FK ;
 private LocalDate datedebut;
    private LocalDate datefin;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
public Reservation(){

}
    private static final    Reservation reservation=new Reservation();

    public static  Reservation getInstance(){
        return reservation;
    }

 private  Boolean ifdriver;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", id_client_FK=" + id_client_FK +
                ", id_voiture_FK=" + id_voiture_FK +
                ", id_chaufeur_FK=" + id_chaufeur_FK +
                ", datedebut=" + datedebut +
                ", datefin=" + datefin +
                ", ifdriver=" + ifdriver +
                '}';
    }

    public int getId_client_FK() {
        return id_client_FK;
    }

    public void setId_client_FK(int id_client_FK) {
        this.id_client_FK = id_client_FK;
    }

    public int getId_voiture_FK() {
        return id_voiture_FK;
    }

    public void setId_voiture_FK(int id_voiture_FK) {
        this.id_voiture_FK = id_voiture_FK;
    }

    public int getId_chaufeur_FK() {
        return id_chaufeur_FK;
    }

    public void setId_chaufeur_FK(int id_chaufeur_FK) {
        this.id_chaufeur_FK = id_chaufeur_FK;
    }

    public LocalDate getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(LocalDate datedebut) {
        this.datedebut = datedebut;
    }

    public LocalDate getDatefin() {
        return datefin;
    }

    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }

    public Boolean getIfdriver() {
        return ifdriver;
    }

    public void setIfdriver(Boolean ifdriver) {
        this.ifdriver = ifdriver;
    }

    public Reservation(int id) {
        this.id = id;
        this.id_client_FK = id_client_FK;
        this.id_voiture_FK = id_voiture_FK;
        this.id_chaufeur_FK = id_chaufeur_FK;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.ifdriver = ifdriver;
    }
    public Reservation(int id ,LocalDate datedebut, LocalDate datefin,boolean ifdriver){
       this.id = id;
        this.id_client_FK = id_client_FK;
        this.id_voiture_FK = id_voiture_FK;
        this.id_chaufeur_FK = id_chaufeur_FK;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.ifdriver = ifdriver;
}
    public Reservation(LocalDate datedebut, LocalDate datefin,boolean ifdriver) {
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.ifdriver = ifdriver;
    }
    public Reservation(LocalDate datedebut) {
        this.datedebut = datedebut;

    }

}


