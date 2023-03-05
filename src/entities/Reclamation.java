/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class Reclamation{
    private int id;
    private String objectif ;
    private String text ; 
    private int iduser;
    private int etat;

    public Reclamation( String objectif ,String text,int iduser,int etat) {
  
        this.objectif= objectif;
        this.text= text;
        this.iduser=iduser;
        this.etat=etat;
    }

    public Reclamation(int id, String objectif ,String text ,int iduser,int etat) {
        this.id = id;
        this.objectif= objectif;
        this.text= text; 
        this.iduser=iduser;
        this.etat=etat;
       
    }

    public Reclamation() {
    }

    public Reclamation(String text, String text0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        this.objectif= text;
        this.text= text0; 
    }
    
    //getters / setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public String  getObjectif() {
        return objectif;
    }

    public void setobjectif(String objectif) {
        this.objectif= objectif ;
    }
    
      public String  getText() {
        return text ;
    }

    public void settext(String text) {
        this.text= text ;
    }
    
    public  int getIduser() {
        return iduser;
    }

    public void setiduser(int iduser) {
        this.iduser = iduser;
    }
    
    //toString
    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ",  obejectif=" + objectif +  ", text=" + text +  '}';
    }
    

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    
    
    
}


