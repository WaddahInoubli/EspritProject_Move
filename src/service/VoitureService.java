/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.voiture;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tools.MyDB;

/**
 *
 * @author Administrateur
 */
public class VoitureService {
        Connection cn;   
  public VoitureService() {
        cn = MyDB.getInstance().getConnection();
    }
 
    
    public void ajoutervoiture(voiture p) {
        try {
            String query = "INSERT INTO voiture (etat, annes, prix_h,id_m) VALUES (?, ?, ?,?)";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, p.getEtat());
            ps.setInt(2, p.getAnnes());
            ps.setInt(3, p.getPrix_h());
            ps.setInt(4, p.getId_m());
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
  public void modifiervoiture(voiture u) throws SQLException, NoSuchAlgorithmException {
        String req = "UPDATE voiture SET "
                + "etat ='"   +   u.getEtat()+"'"
                + ", annes='"+  u.getAnnes()+"'"
                + ", prix_h='"+u.getPrix_h()+"'"
             
      
                + ", id_m ='"+   u.getId_m()+"' where matricule  = "+u.getMatricule()+"";
        Statement stm = cn.createStatement();
        stm.executeUpdate(req);
    }   
    
    public void supprimervoiture(int id) {
        try {
            String query = "DELETE FROM voiture WHERE matricule=?";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
      public void supprimervoiture2(voiture u) throws SQLException {

        String req = "DELETE FROM voiture WHERE matricule=?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, u.getMatricule());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    
      
         public List<voiture> listervoitures() throws SQLException {

        List<voiture> voitures = new ArrayList<>();
         
       
        String req = "select * from voiture";
        Statement stm = cn.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            voiture u = new voiture(rst.getInt("matricule")
                    , rst.getString("etat")
                    , rst.getInt("annes")
                    , rst.getInt("prix_h")
                    , rst.getInt("id_m")
                
            
            );
            voitures.add(u);
        }
        return voitures;
    }  
         public List<voiture> listervoitureParPrix() throws SQLException {

        List<voiture> voitures = new ArrayList<>();
         
       
        String req = "select * from voiture order by prix_h";
        Statement stm = cn.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            voiture u = new voiture(rst.getInt("matricule")
                    , rst.getString("etat")
                    , rst.getInt("annes")
                    , rst.getInt("prix_h")
                    , rst.getInt("id_m")
            
            );
            voitures.add(u);
        }
        return voitures;
    }    
}
