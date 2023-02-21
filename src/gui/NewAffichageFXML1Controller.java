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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import pkg3a11_jdbc_javafx.PidevGui;
import services.IServiceUserImpl;

/**
 * FXML Controller class
 *
 * @author user
 */
public class NewAffichageFXML1Controller implements Initializable {

    @FXML
    private TableView<User> tableUser;
    @FXML
    private TableColumn<User, String> cNom;
    @FXML
    private TableColumn<User, String> cPrenom;
    @FXML
    private TableColumn<User, Integer> cAge;
    @FXML
    private TableColumn<User, String> cNumT;
    @FXML
    private TableColumn<User, String> cMail;
    @FXML
    private TableColumn<User, String> cRole;
    @FXML
    private TableColumn<User, Boolean> cActive;
    @FXML
    private AnchorPane detailsAnchorePane;
    @FXML
    private Label adresseLabel;

    private IServiceUserImpl serviceUser = new IServiceUserImpl();
    private User selectedUser;
    @FXML
    private Button activerButton;
    @FXML
    private TextField rNom;
    @FXML
    private TextField rPrenom;
    @FXML
    private TextField rAge;
    @FXML
    private TextField rNumT;
    @FXML
    private TextField rMail;
    @FXML
    private ComboBox<String> rActive;
    @FXML
    private ComboBox<String> rRole;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeComboBox();
        detailsAnchorePane.setVisible(false);
        ObservableList OL = FXCollections.observableArrayList(serviceUser.afficher());
        tableUser.setItems(OL);
        cNom.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        cPrenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        cAge.setCellValueFactory(new PropertyValueFactory<User, Integer>("age"));
        cNumT.setCellValueFactory(new PropertyValueFactory<User, String>("numTel"));
        cMail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        cRole.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
        cActive.setCellValueFactory(new PropertyValueFactory<User, Boolean>("active"));
    }

    @FXML
    private void showProfile(ActionEvent event) throws IOException {
         afficherProfileController.setUser(selectedUser);
        Parent root = FXMLLoader.load(getClass().getResource("../gui/afficherProfile.fxml"));
        Scene scene = new Scene(root);
        PidevGui.pStage.setScene(scene);
        PidevGui.pStage.show();
    }

    @FXML
    private void selectItem(MouseEvent event) {
        selectedUser = tableUser.getSelectionModel().getSelectedItem();
        detailsAnchorePane.setVisible(true);
        adresseLabel.setText(selectedUser.getAdresse());
        if (selectedUser.getActive()) {
            activerButton.setText("Desactiver");
        } else {
            activerButton.setText("Activer");

        }
    }

    @FXML
    private void activerDesactiver(ActionEvent event) {
        if (selectedUser.getActive()) {
            serviceUser.acrivateDesactivateUSer(selectedUser.getId(), Boolean.FALSE);
        } else {
            serviceUser.acrivateDesactivateUSer(selectedUser.getId(), Boolean.TRUE);

        }
        this.initialize(null, null);
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        ModifierController.setUser(selectedUser);
        Parent root = FXMLLoader.load(getClass().getResource("../gui/modifier.fxml"));
        Scene scene = new Scene(root);
        PidevGui.pStage.setScene(scene);
        PidevGui.pStage.show();
    }

    @FXML
    private void Delete(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Voulez vous supprimer " + selectedUser.getNom() + " " + selectedUser.getPrenom(), "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            serviceUser.supprimer(selectedUser);
            this.initialize(null, null);
            JOptionPane.showMessageDialog(null, "Utilisateur supprimé !");
        }

    }

    private void initializeComboBox() {
        rActive.getItems().clear();
        rActive.getItems().add("Tous");
        rActive.getItems().add("Active");
        rActive.getItems().add("Desactive");
        rRole.getItems().clear();
        rRole.getItems().add("Tous");
        rRole.getItems().add("CLIENT");
        rRole.getItems().add("CONDUCTEUR");
        rRole.getItems().add("ADMIN");

    }

    @FXML
    private void Search(ActionEvent event) {
        Boolean active = null;
        if (rActive.getValue() != null) {
            if (rActive.getValue().equals("Active")) {
                active = true;
            }
            if (rActive.getValue().equals("Desactive")) {
                active = false;
            }
        }
        ObservableList OL = null;
        if (rRole.getValue() != null) {
            if (rRole.getValue().equals("Tous")) {
                OL = FXCollections.observableArrayList(serviceUser.find(rNom.getText(), rPrenom.getText(), rNumT.getText(), "", rMail.getText(), active));

            } else {
                OL = FXCollections.observableArrayList(serviceUser.find(rNom.getText(), rPrenom.getText(), rNumT.getText(), rRole.getValue(), rMail.getText(), active));
            }
        } else {
            OL = FXCollections.observableArrayList(serviceUser.find(rNom.getText(), rPrenom.getText(), rNumT.getText(), "", rMail.getText(), active));
        }

        detailsAnchorePane.setVisible(false);
        tableUser.setItems(OL);
        cNom.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        cPrenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        cAge.setCellValueFactory(new PropertyValueFactory<User, Integer>("age"));
        cNumT.setCellValueFactory(new PropertyValueFactory<User, String>("numTel"));
        cMail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        cRole.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
        cActive.setCellValueFactory(new PropertyValueFactory<User, Boolean>("active"));

    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/login.fxml"));
        Scene scene = new Scene(root);
        PidevGui.pStage.setScene(scene);
        PidevGui.pStage.show();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/ajouter.fxml"));
        Scene scene = new Scene(root);
        PidevGui.pStage.setScene(scene);
        PidevGui.pStage.show();
    }

}
