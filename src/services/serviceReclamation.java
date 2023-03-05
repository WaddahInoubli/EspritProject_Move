/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import interfaces.IserviceReclamation;
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
public class serviceReclamation implements IserviceReclamation<Reclamation>{
    Connection connection;
    Statement ste;

    public serviceReclamation() {
        
        connection = MyDB.getInstance().getCon();
    }
    
    
    

   @Override
    public void ajouter(Reclamation t) {
        try {
            
            ste = connection.createStatement();
            String req ="INSERT INTO `esprit3a11`.`reclamation` (objectif`,`text`,`iduser`) VALUES ('"+t.getObjectif()+"',"+t.getText()+","+t.getIduser()+");";
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
          String req = "DELETE FROM reclamation WHERE id ="+id;
        ste = connection.createStatement();
        ste.executeUpdate(req);
         Alert a = new Alert(Alert.AlertType.INFORMATION, "Suppression effectuée", ButtonType.OK);
         a.showAndWait();
    }
      catch (SQLException ex) {
               
              }
               }
    

   @Override
    public void ajouter2(Reclamation t) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO `esprit3a11`.`reclamation` (`objectif`,`text`,`iduser`) VALUES (?,?,?)");
     
        pre.setString(1, t.getObjectif());
         pre.setString(2, t.getText());
          pre.setInt(3, t.getIduser());
        
        pre.executeUpdate();
        
    }

    @Override
    public ArrayList<Reclamation> afficher() {
        ArrayList<Reclamation> listrec = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM `esprit3a11`.`reclamation`";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id = res.getInt(1);
            
            String objectif = res.getString("objectif");
            String text = res.getString("text");
             int  iduser = res.getInt("iduser");

            Reclamation rec = new Reclamation(id,objectif,text,iduser,res.getInt(5));
            listrec.add(rec);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listrec;
    }
    public ObservableList<Reclamation> getall() {
        ObservableList<Reclamation> reclamations = FXCollections.observableArrayList();
        try {
            String req = "select * from reclamation";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Reclamation p = new Reclamation();
                p.setId(rs.getInt(1));
                p.setiduser(rs.getInt(4));
                p.setobjectif(rs.getString("objectif"));
                p.settext(rs.getString("text"));
              
               reclamations.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reclamations;
    }
    
    public ObservableList<Reclamation> getallAdmin() {
        ObservableList<Reclamation> reclamations = FXCollections.observableArrayList();
        try {
            String req = "select * from reclamation WHERE reclamation.etat=0";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Reclamation p = new Reclamation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
               
              
               reclamations.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reclamations;
    }

 

    @Override
    public void modifier(Reclamation t) {
      try {
            String requete = "UPDATE reclamation SET objectif=?, text=? where id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(3, t.getId());
        
            pst.setString(1, t.getObjectif());
            
            pst.setString(2, t.getText());
           
            pst.executeUpdate();
            System.out.println(" Reclamation Modifiée! ");
        } catch (SQLException ex) {
            System.out.println(" erreur de modification! ");
            System.err.println(ex.getMessage());
        }    
    }
     public Reclamation Onerec(int id) {
           Reclamation u = new Reclamation();
        try {
            String req = "select * from reclamation where id= "+id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setobjectif(rs.getString("objectif"));
                u.settext(rs.getString("text"));
                u.setiduser(4);
               
                System.out.println(u);
              
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u ;
    }
     
     public List<Reclamation> getMyRtrans(int id) {
        List<Reclamation> list = new ArrayList<>();
        try {
            String req = "Select * from reclamation WHERE reclamation.iduser='"+id+"' ";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                
                
                
                Reclamation c = new Reclamation(rs.getInt(1), rs.getString("objectif"), rs.getString(3),id,rs.getInt(5));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
      public List<Reclamation> getMyRtrans(int id,String rech) {
        List<Reclamation> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement("SELECT * from reclamation WHERE reclamation.iduser=? AND reclamation.objectif LIKE ?");
            p.setInt(1, id);
            p.setString(2,"%"+rech+"%");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                
                
                
                Reclamation c = new Reclamation(rs.getInt(1), rs.getString("objectif"), rs.getString(3),id,rs.getInt(5));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
      public void traiterRec(Reclamation t) throws SQLException {
          
          String requete = "UPDATE reclamation SET etat=1 WHERE reclamation.iduser='"+t.getId()+"'";
          Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(requete);
      }
      }


 