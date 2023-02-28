/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import pkg3a11_jdbc_javafx.PidevGui;
import services.IServiceUserImpl;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjoutereController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField age;
    @FXML
    private TextArea adresse;
    @FXML
    private TextField numT;
    @FXML
    private TextField mail;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;
    @FXML
    private Label passwordError;
    @FXML
    private Label numTelError;
    @FXML
    private Label mailError;
    @FXML
    private ComboBox<String> cbRole;
    private IServiceUserImpl serviceUser = new IServiceUserImpl();
    @FXML
    private Label nomError;
    @FXML
    private Label prenomError;
    @FXML
    private Label ageError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbRole.getItems().add("CLIENT");
        cbRole.getItems().add("ADMIN");
        cbRole.getItems().add("CONDUCTEUR");
        passwordError.setVisible(false);
        numTelError.setVisible(false);
        mailError.setVisible(false);
        nomError.setVisible(false);
        prenomError.setVisible(false);
        ageError.setVisible(false);
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException, SQLException {
        if (controleDeSaisie()) {
            User user = new User(nom.getText(), prenom.getText(), Integer.parseInt(age.getText()), adresse.getText(), numT.getText(), mail.getText(), cbRole.getValue(), password1.getText(), Boolean.TRUE);
            serviceUser.ajouter(user);
            JOptionPane.showMessageDialog(null, "le compte a été créé !");

            Parent root = FXMLLoader.load(getClass().getResource("../gui/newAffichageFXML1.fxml"));
            Scene scene = new Scene(root);
            PidevGui.pStage.setScene(scene);
            PidevGui.pStage.show();
        }
    }

    private Boolean controleDeSaisie() {
        Boolean isValid = true;
        passwordError.setVisible(false);
        numTelError.setVisible(false);
        mailError.setVisible(false);
        nomError.setVisible(false);
        prenomError.setVisible(false);
        ageError.setVisible(false);
        if (!password1.getText().equals(password2.getText())) {
            passwordError.setText("Les deux mot de passe ne sont pas identiques");
            passwordError.setVisible(true);
            isValid = false;
        } else if (!serviceUser.isValidPassword(password1.getText())) {
            passwordError.setText("Les deux mot de passe est tres faible");
            passwordError.setVisible(true);
            isValid = false;
        }
        if (!isValidCaratere(nom.getText()) || nom.getText().isEmpty()) {
            nomError.setVisible(true);
            isValid = false;
        }
        if (!isValidCaratere(prenom.getText()) || prenom.getText().isEmpty()) {
            prenomError.setVisible(true);
            isValid = false;
        }
        if (numT.getText().length() != 8 || !isValidNumber(numT.getText())) {
            numTelError.setVisible(true);
            isValid = false;
        }
        if (!isValidNumber(age.getText()) || age.getText().isEmpty()) {
            ageError.setVisible(true);
            isValid = false;
        }
        if (!serviceUser.isValidEmail(mail.getText())) {
            mailError.setText("Addresse mail non valide");
            mailError.setVisible(true);
            isValid = false;
        } else if (serviceUser.findByEmail(mail.getText()) != null) {
            mailError.setText("Addresse mail indisponible");
            mailError.setVisible(true);
            isValid = false;
        }
        return isValid;
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

    private Boolean isValidCaratere(String str) {
        String regex = "^[a-zA-Z_ ]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private Boolean isValidNumber(String str) {
        String regex = "^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
