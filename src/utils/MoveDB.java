/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chedli
 */
public class MoveDB {

   

    
    final String url="jdbc:mysql://localhost:3306/move";
    final String user="root";
    final String pwd="";
    Connection con;

    public static MoveDB db;
    
     private MoveDB() {
        
        try {
            System.out.println("Connexion en cours");
            con= (Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println("Probleme de connexion : "+ex.getMessage());
            
        }
    }
     
     public static MoveDB getInstance(){
        if(db==null)
            db=new MoveDB();
        return db;
        
    }

    public Connection getCon() {
        return con;
    }
}
 
    