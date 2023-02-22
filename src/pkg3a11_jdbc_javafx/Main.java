/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3a11_jdbc_javafx;

import entities.Personne;
import entities.Message; 

import java.sql.SQLException;
import services.ServicePersonne;
import services.ServiceMessage;

import utils.MyDB;

/**
 *
 * @author Andrew
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         MyDB db=MyDB.getInstance();
        
 //Personne p1 = new Personne(1, 11111185, "xx", "xxx", 77, "amine@gm.com");
 //     Personne p2 = new Personne(16, 11111185, "amine", "amine", 77, "amine@gm.com");
 
 Message m1 = new Message(1, "hafhoufa") ; 
 ServiceMessage sm = new ServiceMessage();
 sm.ajouter(m1);
 
//        
 //ServicePersonne sp = new ServicePersonne();
 
 //p1.setAge(100);
 //sp.modifier(p1);
         
 //    sp.ajouter(p1);
     
     
     
//          try {
//         sp.ajouter2(p2);
//    } catch (SQLException ex) {
//          System.out.println("Probleme insertion: "+ex.getMessage());
//    }
//          System.out.println(sp.afficher());
    }
    
    }
    

