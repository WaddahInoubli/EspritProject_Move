/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Andrew
 */
public class MyDB {
    final String url="jdbc:mysql://localhost:3306/esprit3a11";
    final String user="root";
    final String pwd="";
    Connection con;
    
    //creer un 
    public static MyDB db;
    
  
   //rendre le constructeur prive
    public MyDB() {
        
        try {
            System.out.println("Connexion en cours");
            con= (Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etabli");
        } catch (SQLException ex) {
            System.out.println("Problem de connexion : "+ex.getMessage());
            
        }
    }
    
    //une methode static
    public static MyDB getInstance(){
        if(db==null)
            db=new MyDB();
        return db;
        
    }

    public Connection getCon() {
        return con;
    }
    
}
