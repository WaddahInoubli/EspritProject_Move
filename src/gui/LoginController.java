/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkg3a11_jdbc_javafx.PidevGui;
import services.IServiceUserImpl;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tmail;
    @FXML
    private TextField tpassword;

    private IServiceUserImpl serviceUser = new IServiceUserImpl();
    @FXML
    private Label labelError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelError.setVisible(false);
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        String loginReturn = serviceUser.login(tmail.getText(), tpassword.getText());
        if (loginReturn.equals("connected")) {
            String redirectUri="../gui/newAffichageFXML1.fxml";
            if(!serviceUser.getConnectedUser().getRole().equals("ADMIN")){
                 afficherProfileController.setUser(serviceUser.getConnectedUser());
                 redirectUri="../gui/afficherProfile.fxml";
            }
            Parent root = FXMLLoader.load(getClass().getResource(redirectUri));
            Scene scene = new Scene(root);
            PidevGui.pStage.setScene(scene);
            PidevGui.pStage.show();
        } else {
            labelError.setVisible(true);
            labelError.setText(loginReturn);
        }
    }

    @FXML
    private void subscribe(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/Subscribe.fxml"));
            Scene scene = new Scene(root);
            PidevGui.pStage.setScene(scene);
            PidevGui.pStage.show();
    }

}
