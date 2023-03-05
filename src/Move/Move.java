/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Move;
import entities.Discussion;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.ServiceDiscussion;
import utils.MyDB;


/**
 *
 * @author Z4RGA
 */
public class Move extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
 try {
            primaryStage.initStyle(StageStyle.DECORATED);
            URL fxURL = getClass().getResource("../gui/ChatScreen.fxml");
            FXMLLoader loader = new FXMLLoader(fxURL);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }    }
    
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
