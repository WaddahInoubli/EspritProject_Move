/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package move;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import service.serviceVoiture;
import utils.MyDB;

/**
 *
 * @author tekay
 */
public class Move extends Application {
   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         MyDB db=MyDB.getInstance();
        
  serviceVoiture sp;
        sp = new serviceVoiture();
//        sp.ajouter(p1);
//        
//        try {
//            sp.ajouter2(p2);
//        } catch (SQLException ex) {
//            System.out.println("Probleme insertion: "+ex.getMessage());
//        }
        System.out.println(sp.afficher());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
