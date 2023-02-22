/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.voiture;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.serviceVoiture;

/**
 * FXML Controller class
 *
 * @author tekay
 */
public class AffichageController implements Initializable {

    @FXML
    private TableView<voiture> table;

    @FXML
    private TableColumn<voiture, Integer> matricule;

    @FXML
    private TableColumn<voiture, String> etat;

    @FXML
    private TableColumn<voiture, Integer> annees;

    @FXML
    private TableColumn<voiture, Integer> prix_h;

    @FXML
    private TableColumn<voiture, Integer> id_m;

    @FXML
    private TableColumn<voiture, String> marque;

    @FXML
    private TableColumn<voiture, String> modele;

    @FXML
    private TableColumn<voiture, String> couleur;

    @FXML
    private TextField matriculeTextField;

    @FXML
    private TextField etatTextField;

    @FXML
    private TextField anneesTextField;

    @FXML
    private TextField prix_hTextField;

    @FXML
    private TextField id_mTextField;

    @FXML
    private TextField marqueTextField;

    @FXML
    private TextField modeleTextField;

    @FXML
    private TextField couleurTextField;

    private final serviceVoiture serviceVoiture = new serviceVoiture();

    @FXML
    private void ajouterVoiture(ActionEvent event) throws SQLException {
        int matricule = Integer.parseInt(matriculeTextField.getText());
        String etat = etatTextField.getText();
        int annees = Integer.parseInt(anneesTextField.getText());
        int prix_h = Integer.parseInt(prix_hTextField.getText());
        int id_m = Integer.parseInt(id_mTextField.getText());
        String marque = marqueTextField.getText();
        String modele = modeleTextField.getText();
        String couleur = couleurTextField.getText();

        voiture v = new voiture(matricule, etat, annees, prix_h, id_m, marque, modele, couleur);

        serviceVoiture.ajouter(v);

        // Reload the table view
        afficherVoiture();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherVoiture();
    }

    private void afficherVoiture() {
        ObservableList<voiture> list = (ObservableList<voiture>) serviceVoiture.afficher();
        matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        annees.setCellValueFactory(new PropertyValueFactory<>("annes"));
        prix_h.setCellValueFactory(new PropertyValueFactory<>("prix_h"));
        id_m.setCellValueFactory(new PropertyValueFactory<>("id_m"));
        marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        modele.setCellValueFactory(new PropertyValueFactory<>("modele"));
        couleur.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        table.setItems(list);
    }
    @FXML
    void modifierVoiture(ActionEvent event)throws SQLException {
        voiture v = table.getSelectionModel().getSelectedItem();
        if (v != null) {
            v.setMatricule(Integer.parseInt(matriculeTextField.getText()));
            v.setEtat(etatTextField.getText());
            v.setAnnees(Integer.parseInt(anneesTextField.getText()));
            v.setPrix_h(Integer.parseInt(prix_hTextField.getText()));
            v.setId_m(Integer.parseInt(id_mTextField.getText()));
            v.setMarque(marqueTextField.getText());
            v.setModele(modeleTextField.getText());
            v.setCouleur(couleurTextField.getText());

            serviceVoiture.modifier(v);

            // Reload the table view
            afficherVoiture();
        }
}
    @FXML
    void supprimerVoiture(ActionEvent event) throws SQLException {
    voiture v = table.getSelectionModel().getSelectedItem();
    if (v != null) {
        serviceVoiture.supprimer(v);

        // Reload the table view
        afficherVoiture();
    }}
}

    

