/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import entities.reponse;
import interfaces.IserviceReponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import utils.MyDB;

/**
 *
 * @author Andrew
 */
public class serviceReponse implements IserviceReponse<reponse>{
    Connection connection;
    Statement ste;

    public serviceReponse() {
        
        connection = MyDB.getInstance().getCon();
    }
    
        public reponse OneCat(int id) {
           reponse u = new reponse();
        try {
            String req = "select * from reponse where id= "+id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                u.setid(rs.getInt(1));
                u.setobjectif(rs.getString("objectif"));
                u.settexte(rs.getString("texte"));
                u.setetat(rs.getString("etat"));

                
               
                System.out.println(u);
              
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u ;
    }
    
    

   @Override 
    public void ajouter(reponse t) {
        try {
            
            ste = connection.createStatement();
            String req ="INSERT INTO reponse (`objectif`,`texte`,`objectif`,`etat`) VALUES ('"+t.getobjectif()+"',"+t.gettexte()+","+t.getetat()+");";
            ste.executeUpdate(req);
            
            
            
        } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        
        
       
    }

   /* public void supprimer(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
     @Override
    public void supprimer(int id) throws SQLException{
      try{ 
          String req = "DELETE FROM reponse WHERE id ="+id;
        ste = connection.createStatement();
        ste.executeUpdate(req);
         Alert a = new Alert(Alert.AlertType.INFORMATION, "Suppression effectuée", ButtonType.OK);
         a.showAndWait();
    }
      catch (SQLException ex) {
               
              }
               }
    

   @Override
    public void ajouter2(reponse t) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO `esprit3a11`.`reponse` (`objectif`,`texte`,`etat`) VALUES (?,?,?)");
     
        pre.setString(1, t.getobjectif());
         pre.setString(2, t.getobjectif());
        pre.setString(3, t.getetat());

         
        
        pre.executeUpdate();
        
    }

    @Override
    public ArrayList<reponse> afficher() {
        ArrayList<reponse> listrec = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM `esprit3a11`.`reponse`";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id = res.getInt(1);
            
            String objectif = res.getString("objectif");
            String texte = res.getString("texte");
            String etat = res.getString("etat");

          

            reponse rec = new reponse(id,objectif,texte,etat);
            listrec.add(rec);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listrec;
    }

 

    @Override
    public void modifier(reponse t) {
      try {
            String requete = "UPDATE categorie SET objectif=?, texte=? , etat=? where id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(4, t.getid());
        
            pst.setString(1, t.getobjectif());
            
            pst.setString(2, t.gettexte());
            pst.setString(3, t.getetat());

        
            pst.executeUpdate();
            System.out.println(" reponse Modifiée! ");
        } catch (SQLException ex) {
            System.out.println(" erreur de modification! ");
            System.err.println(ex.getMessage());
        }    
    }
    
      public ObservableList<reponse> getall() {
        ObservableList<reponse> reponse = FXCollections.observableArrayList();
        try {
            String req = "select * from reponse";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
               reponse p = new reponse();
                p.setid(rs.getInt(1));
              
                p.setobjectif(rs.getString("objectif"));
                p.settexte(rs.getString("texte"));
                p.setetat(rs.getString("etat"));
              
               reponse.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reponse;
    }

    
}

 