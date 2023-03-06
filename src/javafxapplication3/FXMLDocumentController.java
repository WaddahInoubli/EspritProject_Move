/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import java.io.*;
import java.net.*;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Comments;
import entities.offre;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import utils.MoveDB;

/**
 *
 * @author chedli
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button getAddView;

    @FXML
    private TableColumn<offre, String> colcomment;

    @FXML
    private TableColumn<offre, String> colnom;

    @FXML
    private TableColumn<offre, String> colposte;

    @FXML
    private TableColumn<offre, String> colid;

    @FXML
    private TableColumn<offre, String> editCol;

    @FXML
    private Label commentt;

    @FXML
    private VBox vbox;
    @FXML
    private VBox vbox1;

    @FXML
    private Label id;

    @FXML
    private Label nom;

    @FXML
    private Label postee;

    @FXML
    private TableView<offre> TableView;

    private TextField txtName;

    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    String query = null;
    offre ofre = null;
    Comments comments = null;
    Connection connection;
    Statement ste;

    ObservableList<offre> OffreList = FXCollections.observableArrayList();
    @FXML
    private Button btn_act;
    @FXML
    private TextField txtsearch;
    @FXML
    private Button btn_search;
    @FXML
    private ScrollPane scroll;
    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    void getAddView(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Gui/AddOffre.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            scene.getStylesheets().add("/javafxapplication3/move.css");
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshTable();
    }

    void insertnumcom() {
        String sql = "SELECT COUNT(*) FROM `esprit3a11`.`comments` WHERE Id_publication  =" + ofre.getId_Offre();
        String count = null;
        try {
            preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                count = rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            query = "UPDATE `esprit3a11`.`offre` SET `Comment`=? WHERE Id_Offre =" + ofre.getId_Offre();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, count);
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AddOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshTable();
    }

    private void refreshTable() {

        try {
            OffreList.clear();

            query = "SELECT * FROM `esprit3a11`.`offre`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OffreList.add(new offre(
                        resultSet.getInt("Id_Offre"),
                        resultSet.getString("content"),
                        resultSet.getString("Name_User"),
                        resultSet.getString("Comment"),
                        resultSet.getDate("date").toLocalDate()));
                TableView.setItems(OffreList);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void afficher() {

        connection = MoveDB.getInstance().getCon();

        refreshTable();
        colid.setCellValueFactory(new PropertyValueFactory<>("Id_Offre"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("Name_User"));
        colposte.setCellValueFactory(new PropertyValueFactory<>("content"));
        colcomment.setCellValueFactory(new PropertyValueFactory<>("Comment"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colid.setSortType(TableColumn.SortType.ASCENDING);
        TableView.getSortOrder().add(colid);
        TableView.sort();

        Callback<TableColumn<offre, String>, TableCell<offre, String>> cellFoctory = (TableColumn<offre, String> param) -> {
            // make cell containing buttons
            final TableCell<offre, String> cell = new TableCell<offre, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
                        FontAwesomeIconView viewIcon = new FontAwesomeIconView(FontAwesomeIcon.ALIGN_CENTER);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        viewIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff5744;"
                        );

                        deleteIcon.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {

                            try {

                                ofre = TableView.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM `esprit3a11`.`offre` WHERE Id_Offre  =" + ofre.getId_Offre();
                                connection = MoveDB.getInstance().getCon();
                                preparedStatement = connection.prepareStatement(query);
                                preparedStatement.execute();
                                refreshTable();
//                              

                            } catch (SQLException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        editIcon.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {

                            ofre = TableView.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/Gui/AddOffre.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            AddOffreController addOffreController = loader.getController();
                            addOffreController.setUpdate(true);
                            addOffreController.setTextField(ofre.getId_Offre(), ofre.getName_User(),
                                    ofre.getContent(), ofre.getComment());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            refreshTable();

                        });

                        viewIcon.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {

                            ofre = TableView.getSelectionModel().getSelectedItem();

                            try {

                                vbox.getChildren().clear();
                                Statement statement = connection.createStatement();
                                ResultSet rs = statement.executeQuery("SELECT * FROM `esprit3a11`.`offre`WHERE Id_Offre  =" + ofre.getId_Offre());
                                insertnumcom();
                                while (rs.next()) {

//        String Id = rs.getString(1);
                                    String name = rs.getString(2);
                                    String poste = rs.getString(3);
                                    String comment = rs.getString(4);
//    Label idValueLabel = new Label("ID: \n" + Id);
                                    Label nomValueLabel = new Label(name);
                                    Label posteeValueLabel = new Label(poste);
                                    Label commenttValueLabel = new Label("                " + comment);
                                    nomValueLabel.setStyle("-fx-font-size: 12pt; -fx-font-weight: bold; -fx-text-fill: red;");
                                    nomValueLabel.setPadding(new Insets(5, 10, -10, 1));
                                    posteeValueLabel.setStyle("-fx-font-size: 12pt; -fx-font-weight: Arial; -fx-text-fill: black;");
                                    commenttValueLabel.setStyle("-fx-font-size: 12pt; -fx-font-weight: Arial; -fx-text-fill: black;");
                                    Button btn = new Button("Ajouter commentaire");
                                    Button share = new Button("publier sur facebook");
                                    HBox hbox = new HBox(btn, share);

                                    btn.setStyle(" -fx-background-color:\n"
                                            + "        linear-gradient(#f0ff35, #a9ff00),\n"
                                            + "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);-fx-background-radius: 30;-fx-background-insets: 0;-fx-text-fill: white;");

                                    vbox.getChildren().add(nomValueLabel);
                                    vbox.getChildren().add(posteeValueLabel);
                                    vbox.getChildren().add(commenttValueLabel);
                                    vbox.getChildren().add(hbox);

                                    refreshTable();

                                    affichercom();
                                    share.setOnAction(e -> {
                                        String accessToken = "EAAIenFpPxHABAPre76UzC5LEJcPmrrTrB8EODT65CljGDl9DRrHipxcAWdvcRKGWgG6GKwL5Sv3qcEt7ENKJLQNSQs1GHBI6bhXEeZCiURhtVnGR0JZAws86MYAxER6kiwdtyCWzZB2Se3ZB4qZAEZA3t1mxYzTGNixFNvAsWgqame2UwAfy4x";
                                        FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_12_0);

                                        FacebookType response = fbClient.publish("me/feed", FacebookType.class,
                                                Parameter.with("message", poste));

                                    });
                                    btn.setOnAction(e -> {

                                        FXMLLoader loader = new FXMLLoader();
                                        loader.setLocation(getClass().getResource("/Gui/Addcomentaire.fxml"));
                                        try {
                                            loader.load();
                                        } catch (IOException ex) {
                                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        int Idpub = ofre.getId_Offre();
                                        AddcomentaireController addcomentaireController = loader.getController();
                                        addcomentaireController.settTextField(Idpub);

                                        Parent parent = loader.getRoot();
                                        Stage stage = new Stage();
                                        stage.setScene(new Scene(parent));
                                        stage.initStyle(StageStyle.UTILITY);
                                        stage.show();
                                        refreshTable();
                                    });

                                }

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon, viewIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
                        HBox.setMargin(viewIcon, new Insets(2, 4, 0, 1));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        editCol.setCellFactory(cellFoctory);
        TableView.setItems(OffreList);

    }

    void affichercom() {

        try {

            vbox1.getChildren().clear();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `esprit3a11`.`comments`WHERE Id_publication  =" + ofre.getId_Offre());

            while (rs.next()) {

                int Id = rs.getInt(1);
                int Idpub = rs.getInt(2);
                String nameee = rs.getString(4);
                String contenente = rs.getString(3);
                String date = rs.getString(5);
                Label idValueLabel = new Label("ID: \n" + Idpub);
                Label nameValueLabel = new Label(nameee);
                Label contenentValueLabel = new Label(contenente);
                Label dateValueLabel = new Label("                                                " + date);
                Button button = new Button("Modifier");
                Button btton = new Button("supprimer");
                HBox hbox = new HBox(button, btton);
                hbox.setSpacing(10);
                nameValueLabel.setStyle("-fx-font-size: 12pt; -fx-font-weight: bold; -fx-text-fill: red;");
                nameValueLabel.setPadding(new Insets(5, 10, -10, 1));
                contenentValueLabel.setStyle("-fx-font-size: 12pt; -fx-font-weight: Arial; -fx-text-fill: black;");
                dateValueLabel.setStyle("-fx-font-size: 7pt; -fx-font-weight: bold;");
                btton.setStyle(" -fx-background-color: linear-gradient(#ff5400, #be1d00);-fx-background-radius: 30;-fx-background-insets: 0;-fx-text-fill: white;");
                button.setStyle(" -fx-background-color: linear-gradient(#ffd65b, #e68400),linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22),linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));-fx-background-radius: 30;-fx-background-insets: 0;-fx-text-fill: white;");

                vbox1.getChildren().addAll(nameValueLabel);
                vbox1.getChildren().addAll(contenentValueLabel);
                vbox1.getChildren().addAll(dateValueLabel);
                vbox1.getChildren().addAll(hbox);

                scroll.setContent(vbox1);
                refreshTable();

                button.setOnAction(e -> {

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/Gui/Addcomentaire.fxml"));
                    try {
                        loader.load();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    AddcomentaireController addcomentaireController = loader.getController();
                    addcomentaireController.setUpdate(true);
                    addcomentaireController.setTextField(Id, Idpub,
                            contenente, nameee);

                    Parent parent = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(parent));
                    stage.initStyle(StageStyle.UTILITY);
                    stage.show();
                    refreshTable();

                });
                refreshTable();
                btton.setOnAction(e -> {
                    try {

                        query = "DELETE FROM `esprit3a11`.`comments` WHERE Id_Comment = ?";
                        PreparedStatement preparedstatement = connection.prepareStatement(query);
                        preparedstatement.setInt(1, Id);
                        int rowsAffected = preparedstatement.executeUpdate();
                        vbox1.getChildren().clear();
                        vbox1.getChildren().addAll(nameValueLabel);

                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    affichercom();
                    refreshTable();
                });
                refreshTable();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        afficher();
    }

    @FXML
    private void actualiser(ActionEvent event) {
        refreshTable();
        publier();
    }

    @FXML
    private void search(ActionEvent event) {

        try {
            OffreList.clear();
            String searchTerm = txtsearch.getText();

            query = "SELECT * FROM `esprit3a11`.`offre`WHERE Name_User LIKE '%" + searchTerm + "%'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OffreList.add(new offre(
                        resultSet.getInt("Id_Offre"),
                        resultSet.getString("content"),
                        resultSet.getString("Name_User"),
                        resultSet.getString("Comment"),
                        resultSet.getDate("date").toLocalDate()));
                TableView.setItems(OffreList);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void publier() {
    }
}
