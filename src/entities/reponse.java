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
public class reponse{
    private int id ;
    private String objectif ;
    private String texte ; 
    private String etat ; 
    

    public reponse( String objectif ,String texte , String etat ) {
  
        this.objectif= objectif;
        this.texte= texte;
        this.etat= etat;
       
    }

    public reponse(int id, String objectif ,String texte ,String etat  ) {
        this.id = id;
        this.objectif= texte;
        this.texte= texte;
        this.etat= etat; 
     
       
    }

    public reponse() {
    }
    
    //getters / setters

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

  

    public String  getobjectif() {
        return  objectif ;
    }

    public void setobjectif(String objectif) {
        this.objectif= objectif ;
    }
    
      public String  gettexte() {
        return texte ;
    }

    public void settexte(String texte) {
        this.texte= texte ;
    }
    
       public String  getetat() {
        return  etat ;
    }

    public void setetat(String etat) {
        this.etat= etat ;
    }
    
    //toString
    @Override
    public String toString() {
        return "reponse{" + "id=" + id + ",  objectif=" + objectif +  ", texte=" + texte + ", etat=" + etat + '}';
    }
    
}


