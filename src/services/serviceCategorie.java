/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.categorie;
import interfaces.IserviceCategorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author Andrew
 */
public class serviceCategorie implements IserviceCategorie<categorie>{
    Connection connection;
    Statement ste;

    public serviceCategorie() {
        
        connection = MyDB.getInstance().getCon();
    }
    
    
    

   @Override
    public void ajouter(categorie t) {
        try {
            
            ste = connection.createStatement();
            String req ="INSERT INTO `esprit3a11`.`categorie` (`nom`,`description`) VALUES ('"+t.getnom()+"',"+t.getdescription()+");";
            ste.executeUpdate(req);
            
            
            
        } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        
        
       
    }

    @Override
   /* public void supprimer(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
 public void supprimer(categorie t) {
          try {
            String requete = "DELETE FROM reclamation WHERE id_categorie=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1, t.getid_categorie());
            pst.executeUpdate();
            System.out.println("Reclamation supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }      
    }
 
   
    

   @Override
    public void ajouter2(categorie t) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO `esprit3a11`.`categorie` (`nom`,`description`) VALUES (?,?)");
     
        pre.setString(1, t.getnom());
         pre.setString(2, t.getdescription());
         
        
        pre.executeUpdate();
        
    }

    @Override
    public ArrayList<categorie> afficher() {
        ArrayList<categorie> listrec = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM `esprit3a11`.`categorie`";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id_categorie = res.getInt(1);
            
            String nom = res.getString("nom");
            String description = res.getString("description");
          

            categorie rec = new categorie(id_categorie,nom,description);
            listrec.add(rec);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listrec;
    }

 

    @Override
    public void modifier(categorie t) {
      try {
            String requete = "UPDATE categorie SET nom=?, description=? where id_categorie=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(3, t.getid_categorie());
        
            pst.setString(1, t.getnom());
            
            pst.setString(2, t.getdescription());
        
            pst.executeUpdate();
            System.out.println(" categorie Modifiée! ");
        } catch (SQLException ex) {
            System.out.println(" erreur de modification! ");
            System.err.println(ex.getMessage());
        }    
    }
}

 