package GUI;


import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class confirmadmincontroller implements Initializable {

    @FXML
    private Button confirm;

    @FXML
    private PasswordField password;


    @FXML
    void confirmer(ActionEvent event) throws IOException {
        String prenom = password.getText();
        System.out.println(prenom);
        if (prenom.equals("waddhah")) {

            Parent Home = FXMLLoader.load(getClass().getResource("Listereservations.fxml"));
            Scene home = new Scene(Home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home);
            app_stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid mot de passe");
            alert.setHeaderText(null);
            alert.setContentText(" inserer le bon mot de passe svp");
            alert.showAndWait();

        }
    }
    public int data;
    public void setData(int data) {
        this.data = data;
    }

    User user1=User.getInstance();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(user1.getId());
    }
}
