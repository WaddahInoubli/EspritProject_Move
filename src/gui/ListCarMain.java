package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ListCarMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ListCar.fxml"));
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
        launch(args);
    }
}
