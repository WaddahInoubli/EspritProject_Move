/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import pkg3a11_jdbc_javafx.PidevGui;
import services.IServiceUserImpl;

/**
 * FXML Controller class
 *
 * @author user
 */
public class afficherProfileController implements Initializable {

    @FXML
    private CheckBox cbActive;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label age;
    @FXML
    private Text adresse;
    @FXML
    private Label numT;
    @FXML
    private Label mail;
    @FXML
    private Label role;
     private static User user;
    private IServiceUserImpl serviceUser = new IServiceUserImpl();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom.setText(user.getNom());
        prenom.setText(user.getPrenom());
        age.setText(user.getAge() + "");
        adresse.setText(user.getAdresse());
        numT.setText(user.getNumTel());
        mail.setText(user.getEmail());      
        role.setText(user.getRole());
        cbActive.setSelected(user.getActive());
        
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/newAffichageFXML1.fxml"));
        Scene scene = new Scene(root);
        PidevGui.pStage.setScene(scene);
        PidevGui.pStage.show();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/login.fxml"));
        Scene scene = new Scene(root);
        PidevGui.pStage.setScene(scene);
        PidevGui.pStage.show();
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        afficherProfileController.user = user;
    }

}
