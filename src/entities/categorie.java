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
public class categorie{
    private int id_categorie;
    private String nom ;
    private String description ; 
    

    public categorie( String nom ,String description) {
  
        this.nom= nom;
        this.description= description;
       
    }

    public categorie(int id_categorie, String nom ,String description ) {
        this.id_categorie = id_categorie;
        this.nom= nom;
        this.description= description; 
     
       
    }

    public categorie() {
    }
    
    //getters / setters

    public int getid_categorie() {
        return id_categorie;
    }

    public void setid_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

  

    public String  getnom() {
        return nom ;
    }

    public void setnom(String nom) {
        this.nom= nom ;
    }
    
      public String  getdescription() {
        return description ;
    }

    public void setdescription(String description) {
        this.description= description ;
    }
    
   
    
    //toString
    @Override
    public String toString() {
        return "Categorize{" + "id_categorie=" + id_categorie + ",  nom=" + nom +  ", description=" + description +  '}';
    }
    
}


