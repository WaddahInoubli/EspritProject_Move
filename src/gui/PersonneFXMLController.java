/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.*;

import javafx.event.EventHandler;
import entities.Personne;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.MyDB;


import java.io.File;
import java.io.IOException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import services.evenement.Serviceevenement;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;
import services.ServicePersonne;

/**
 * FXML Controller class
 *
 * @author Z4RGA
 */
public class PersonneFXMLController implements Initializable {

    public static Stage stg1;

    /* Buttons */
    @FXML
    private Button bsave;
    @FXML
    private Button bupdate;
    @FXML
    private Button bdelete;

    //********* Z4RGA ******************//
    @FXML
    private TextField idp;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField age;

    @FXML
    private TextField cin;
    
    
    @FXML
    private TextField email;

    //********* Z4RGA ******************//
    Personne Personne;

    @FXML
    private TableView<Personne> table;

    @FXML
    private TableColumn<Personne, Integer> eidp;
    @FXML
    private TableColumn<Personne, Integer> ecin;
    @FXML
    private TableColumn<Personne, String> enom;
    @FXML
    private TableColumn<Personne, String> eprenom;

    @FXML
    private TableColumn<Personne, Integer> eage;
    @FXML
    private TableColumn<Personne, String> eemail;

    //********* Connexion au BD  ******************//
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement st = null;
    Statement stmt = null;

    //****** *** Z4RGA ******************//
    ServicePersonne se;
    
    @FXML
    private Label file_path;
    @FXML
    private ImageView image_view;
    @FXML
    private AnchorPane left_main;
    @FXML
    private DatePicker Date_event;
    @FXML
    private Label seee;
    @FXML
    private TextField filterField;
    @FXML
    private AnchorPane left_main1;


    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        eidp.setVisible(false);
        
                                 

        affiche();

        //observalble list to store data
        ObservableList<Personne> FiltreddataList = FXCollections.observableArrayList();
        ObservableList<Personne> dataList = getEvent();
        
        ecin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        enom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        eprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        eage.setCellValueFactory(new PropertyValueFactory<>("age"));
        eemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        eidp.setCellValueFactory(new PropertyValueFactory<>("idp"));


        table.setItems(dataList);

        /* Search Bar */
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Personne> filteredData = new FilteredList<>(dataList, b -> true);
// 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(evenement -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Personne.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (Personne.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(Personne.getId()).contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

// 3. Wrap the FilteredList in a SortedList. 
        SortedList<Personne> sortedData = new SortedList<>(filteredData);
        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        table.setItems(sortedData);

    }

    /* Les methodes des buttons */
    @FXML
    private void saveEvent(ActionEvent event) {
        insert();
        clear();
    }

    @FXML
    private void updateEvent(ActionEvent event) {
        update();
        clear();
        bsave.setDisable(false);
    }

    @FXML
    private void deleteEvent(ActionEvent event) {
        delete();
        clear();
    }

    @FXML
    private void clearEvent(ActionEvent event) {
        clear();

    }

    private void clear() {
        Ide.setText(null);
        Type_event.setText(null);
        Chanteur.setText(null);
        Adresse.setText(null);
        Date_event.setValue(null);
        prix_e.setText(null);
        table.refresh();
        //   bsave.setDisable(false);

    }

    @FXML
    private void tablehandleButtonAction(MouseEvent event) {
        Personne e = table.getSelectionModel().getSelectedItem();
        idp.setText(String.valueOf(e.getId()));
        cin.setText(String.valueOf(e.getCin()));
        nom.setText(e.getNom());
        prenom.setText(e.getPrenom());
        age.setText(String.valueOf(e.getAge()));

        // bsave.setDisable(true);
    }

    // Affichage 
    public ObservableList<Personne> getEvent() {
        ObservableList<Personne> list = FXCollections.observableArrayList();

        con = MyDB.getInstance().getCon();
        String select = "select * from personne ;";

        try {
            st = con.prepareStatement(select);
            rs = st.executeQuery();
            while (rs.next()) {
                Personne e = new Personne();

                e.setId(rs.getInt("idp"));
                 e.setCin(rs.getInt("cin"));
                 e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setAge(rs.getInt("age"));
                e.setEmail(rs.getString("email"));
                list.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneFXMLController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void affiche() {
        ObservableList<Personne> list = getEvent();

        ecin.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("cin"));
        enom.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));
        eprenom.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));
        eage.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("age"));
        eemail.setCellValueFactory(new PropertyValueFactory<Personne, String>("email"));
        eidp.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("idp"));


        table.setItems(list);

    }

    // INSERTION 
    private void insert() {

        // Control de saisie sur les champs vides 
        if (cin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuiller entrer cin");

        }
        if (nom.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuiller entrer le nom");

        }
        if (prenom.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuiller entrer l'addresse de prenom");

        }

        if (age.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuiller entrer age");

        }
        
          if (email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuiller entrer email");

        }
          
        con = MyDB.getInstance().getCon();
        String insert = "INSERT INTO personne (`cin`,`nom`,`prenom`,`age`,`email`) VALUES (?,?,?,?,?) ;";
        try {

            st = con.prepareStatement(insert);
            st.setString(1, Integer.parseInt(cin.getText()));
            st.setString(2, nom.getText());
            st.setString(3, prenom.getText());
            st.setString(4, age.getText());
          st.setString(5, email.getText());
    

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Personne Added");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("'Personne ajouté avec succée");

            alert.showAndWait();
            //st.setString(3, sexe.getSelectionModel().getSelectedItem());
            st.executeUpdate();
          //  send_notify();
            affiche();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneFXMLController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /* Delete*/
    public void delete() {
        con = MyDB.getInstance().getCon();
        String delete = "DELETE FROM personne  where idp = ?";
        try {
            st = con.prepareStatement(delete);
            st.setInt(1, Integer.parseInt(idp.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Deleting personne");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText(" personne est supprimé avec succés");

            alert.showAndWait();

            st.executeUpdate();
            affiche();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneFXMLController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /* UPDATE */
    private void update() {
        con = MyDB.getInstance().getCon();
        String update = "UPDATE `personne` SET "
                + "`cin`=?,`nom`=?,`prenom`=?,`age`=?,`email`=?"
                + "WHERE idp =?";
        try {
            st = con.prepareStatement(update);
            st.setString(1, Integer.parseInt(cin.getText()));
            st.setString(2, nom.getText());
            st.setString(3, prenom.getText());
            st.setString(4, age.getText());
            st.setString(5, file_path.getText());
            st.setInt(6, Integer.parseInt(idp.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Updating personne");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("'personne est modifié avec succés");

            alert.showAndWait();

            st.executeUpdate();
            affiche();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneFXMLController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

