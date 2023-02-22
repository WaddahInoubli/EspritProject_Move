/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.MyDB;

/**
 *
 * @author Andrew
 */
public class ServiceMessage  implements IService<Message>{
        Connection connection;
        private PreparedStatement pste;
    Statement ste;

    public ServiceMessage() {
        
        connection = MyDB.getInstance().getCon();
    }
    
   
    @Override
    public void ajouter(Message t) {
        try {
            
            ste = connection.createStatement();
            String req ="INSERT INTO `move`.`message` (`idm`,`message`,`idp`) VALUES ('"+t.getId()+"','"+t.getMessage()+"','"+t.getIdp()+"');";
            ste.executeUpdate(req);
            
            
            
        } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        
        
       
    }

    @Override
    public void supprimer(int id) {

            String delete = "DELETE FROM `move`.`message` where idm=?";
        try {
            pste = connection.prepareStatement(delete);
            pste.setInt(1,id);
            pste.executeUpdate();
       
        } catch (SQLException ex) {
                  
                     System.out.println("Exception: "+ex.getMessage());
        
       
        }
    }

    
  
 
    @Override
    public void ajouter2(Message t) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO `move`.`message` (`message`) VALUES (?)");
        pre.setString(1, t.getMessage());
        
        pre.executeUpdate();
        
    }

    @Override
    public ArrayList<Message> afficher() {
        ArrayList<Message> listmsgs = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM `move`.`message`";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id = res.getInt(1);
            String message = res.getString("message");
           int idp = res.getInt(3);


            Message msg = new Message(id,message,idp);
            listmsgs.add(msg);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listmsgs;
    }

    @Override
    public void modifier(Message t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
