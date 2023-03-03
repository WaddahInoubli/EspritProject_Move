/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.offre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import javafxapplication3.FXMLDocumentController;
import utils.MoveDB;


/**
 *
 * @author chedli
 */
public class ServiceOffre implements Iserviceoffre<offre> {

    Connection connection;
    Statement ste;

    public ServiceOffre() {
        
        connection = MoveDB.getInstance().getCon();
    }
    @Override
    public void ajouter(offre t)  {
// try {
//            
//            ste = connection.createStatement();
//            String req ="INSERT INTO `move`.`offre` (`Poste`,`Name_User`,`Comment`) VALUES "
//                    + "('"+t.getPoste()+"','"+t.getName_User()+"','"+t.getComment()+"');";
//            ste.executeUpdate(req);
//            
//            
//            
//        } catch (SQLException ex) {
//            System.out.println("Exception: "+ex.getMessage());
//        }


            }

    
    public void supprimer(int Id_Offre) {
        
        try {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM `esprit3a11`.`offre` WHERE Id_Offre = ?");
        statement.setInt(1, Id_Offre);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
 }

    @Override
    public void modifier(offre t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<offre> afficher() {
        return null;
//ArrayList<offre> listoffre = new ArrayList<>();
//        try{
//        ste= connection.createStatement();
//        String req_select="SELECT * FROM `esprit3a11`.`offre`";
//        ResultSet res = ste.executeQuery(req_select);
//        while(res.next()){
//            int Id_Offre = res.getInt(1);
//            String Name_User = res.getString(2);
//            String content = res.getString(3);
//             String Comment = res.getString(4);
//            String date = res.getString(4);
//            offre off = new offre(Id_Offre,Name_User,content,Comment,date);
//            listoffre.add(off);
//        }
//        }catch(SQLException ex){
//            System.out.println("SQLException "+ex.getMessage());
//        }
//        
//        return listoffre;  
    }

    public void supprimer(offre t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
}
