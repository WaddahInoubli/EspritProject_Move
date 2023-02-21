/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3a11_jdbc_javafx;

import entities.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.IServiceUserImpl;
import utils.MyDB;

/**
 *
 * @author Andrew
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
         MyDB db=MyDB.getInstance();
        
//        Personne p1 = new Personne("Dora", "tkaya", 27);
//        Personne p2 = new Personne("Ghada", "Setti", 27);
//        
                   IServiceUserImpl sp = new IServiceUserImpl();
            //sp.modifier(new User(7,"sa", "pa", 0, "a", "54325452", "ehuuuheaaaspr@yy.tn", "ADMIN", "124442",true));
            //System.out.println(sp.login("ehuuuhespr@yy.tn", password));
            // sp.acrivateDesactivateUSer(7, Boolean.FALSE);
          System.out.println(sp.afficher());
           //sp.find("jallali", "f", "54", "Admin", "firas", null).forEach(s->System.out.println(s));
           
//        sp.ajouter(p1);
//        
//        try {
//            sp.ajouter2(p2);
//        } catch (SQLException ex) {
//            System.out.println("Probleme insertion: "+ex.getMessage());
//        }
        //System.out.println(sp.afficher());
       // b6a6d15b2e1c8da34d6fccb2d1dfe04b
    }
    
    }
    

