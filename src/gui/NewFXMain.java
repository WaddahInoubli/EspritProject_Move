/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.ServicePersonne;
import services.ServiceReservation;
import utils.MyDB;

/**
 *
 * @author Andrew
 */
public class NewFXMain extends Application {
  static    Connection cn = null;
   static Statement st = null;
    static ResultSet rs,rs1 ;
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root =FXMLLoader.load(getClass().getResource("AffichageFXML.fxml"));
            Scene scene =new Scene(root);
            
            primaryStage.setTitle("MOVE");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            //Stage
        } catch (IOException ex) {
            System.out.println("Err"+ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {




        try{
            ServicePersonne p = new ServicePersonne();
            p.afficher();

        }catch (Exception e){
            System.out.println( e.getMessage());
        }




        launch(args);
    }
    
}
