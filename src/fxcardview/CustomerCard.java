package fxcardview;

import entities.Reservation;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerCard extends Pane {

    protected final ImageView photo;
    protected final Label name;
    protected final Label mobile;
    protected final Label label;

    protected final Label dateDebut;
    protected final Label dateFin;
    protected final Label email;
    protected final Label marque;
    protected final Label matricule;
    protected final Label prixTotale;
    protected final HBox iconContainer;
    protected final Button deleteButton;
    protected final Button modifyButton;
    private int ID;

    public CustomerCard(int Id, String Name , String prenom, String Datedebut , String Datefin, String Email, String Telephone, String Marque, String Matricule, String PrixTotale) {


        photo = new ImageView();
        name = new Label();
        mobile = new Label();
        label = new Label();
        dateDebut = new Label();
        dateFin = new Label();
        email = new Label();
        marque = new Label();
        matricule = new Label();
        prixTotale = new Label();
        iconContainer = new HBox();
        deleteButton = new Button();
        modifyButton = new Button();

        setId(Id + "");
        setPrefHeight(300.0);
        setPrefWidth(245.0);


        setStyle("-fx-background-color:#FFF; -fx-border-radius: 10px; -fx-background-radius: 10px;-fx-end-margin: 20px");

        DropShadow dropShadow = new DropShadow();
        dropShadow.setHeight(3);
        dropShadow.setWidth(3);
        dropShadow.setBlurType(BlurType.TWO_PASS_BOX);
        setEffect(dropShadow);

        name.setAlignment(Pos.CENTER);
        name.setContentDisplay(ContentDisplay.CENTER);
        name.setLayoutX(14.0);
        name.setLayoutY(20.0);
        name.setPrefHeight(26.0);
        name.setPrefWidth(215.0);

        name.setText(Name);
        name.setFont(Font.font("System", FontWeight.BOLD, 17.0));

        mobile.setAlignment(Pos.CENTER);
        mobile.setContentDisplay(ContentDisplay.CENTER);
        mobile.setLayoutX(16.0);
        mobile.setLayoutY(54.0);
        mobile.setPrefHeight(19.0);
        mobile.setPrefWidth(215.0);
        mobile.setText(Telephone);
        mobile.setFont(new Font(13.0));

        label.setAlignment(Pos.TOP_RIGHT);
        label.setContentDisplay(ContentDisplay.CENTER);
        label.setLayoutX(39.0);
        label.setLayoutY(80.0);
        label.setPrefHeight(19.0);
        label.setPrefWidth(62.0);
        label.setText("Date Debut:");
        label.setFont(new Font(13.0));

        dateDebut.setContentDisplay(ContentDisplay.CENTER);
        dateDebut.setLayoutX(107.0);
        dateDebut.setLayoutY(80.0);
        dateDebut.setPrefHeight(19.0);
        dateDebut.setPrefWidth(115.0);
        dateDebut.setText(Datedebut);
        dateDebut.setFont(new Font(13.0));
        dateFin.setContentDisplay(ContentDisplay.CENTER);
        dateFin.setLayoutX(107.0);
        dateFin.setLayoutY(105.0);
        dateFin.setPrefHeight(19.0);
        dateFin.setPrefWidth(115.0);
        dateFin.setText(Datefin);
        dateFin.setFont(new Font(13.0));

        email.setAlignment(Pos.CENTER);
        email.setContentDisplay(ContentDisplay.CENTER);
        email.setLayoutX(16.0);
        email.setLayoutY(130.0);
        email.setPrefHeight(19.0);
        email.setPrefWidth(215.0);
        email.setText(String.valueOf(email));
        email.setFont(new Font(13.0));

        marque.setAlignment(Pos.CENTER);
        marque.setContentDisplay(ContentDisplay.CENTER);
        marque.setLayoutX(16.0);
        marque.setLayoutY(155.0);
        marque.setPrefHeight(19.0);
        marque.setPrefWidth(215.0);
        marque.setText(Marque);
        marque.setFont(new Font(13.0));

        matricule.setAlignment(Pos.CENTER);
        matricule.setContentDisplay(ContentDisplay.CENTER);
        matricule.setLayoutX(16.0);
        matricule.setLayoutY(180.0);
        matricule.setPrefHeight(19.0);
        matricule.setPrefWidth(215.0);
        matricule.setText(Matricule);
        matricule.setFont(new Font(13.0));

        prixTotale.setAlignment(Pos.CENTER);
        prixTotale.setContentDisplay(ContentDisplay.CENTER);
        prixTotale.setLayoutX(107.0);
        prixTotale.setLayoutY(205.0);
        prixTotale.setPrefHeight(19.0);
        prixTotale.setPrefWidth(115.0);
        prixTotale.setText(PrixTotale);
        prixTotale.setFont(new Font(13.0));

        iconContainer.setAlignment(Pos.CENTER_RIGHT);
        iconContainer.setPrefHeight(40.0);
        iconContainer.setPrefWidth(200.0);
        iconContainer.setLayoutX(24);
        iconContainer.setLayoutY(230);
        deleteButton.setPrefHeight(32.0);
        deleteButton.setPrefWidth(100.0);
        deleteButton.setText("delete");
        deleteButton.getStyleClass().add("delete-button");
        deleteButton.setOnAction(e -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setContentText("Are you sure you want to delete this customer?");
            alert.showAndWait()
                    .filter(response -> response == ButtonType.OK)
                    .ifPresent(response -> {
                        // Perform delete operation here
                    });
        });
        modifyButton.setText("update");
        modifyButton.setPrefHeight(32.0);
        modifyButton.setPrefWidth(100.0);
        modifyButton.getStyleClass().add("modify-button");
        Reservation reservation=Reservation.getInstance();
        modifyButton.setOnAction(e -> {
            Parent Home = null;
            try {
                Home = FXMLLoader.load(getClass().getResource("../GUI/modifierReservation.fxml"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Scene home = new Scene(Home);
            Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            app_stage.setScene(home);
            app_stage.show();
        });

        iconContainer.getChildren().addAll(deleteButton, modifyButton);

        getChildren().addAll(photo, name, mobile, dateDebut, dateFin, email, marque, matricule, prixTotale, iconContainer);
    }}

