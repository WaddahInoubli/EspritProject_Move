package fxcardview;

import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;

import java.time.LocalDate;

public class CustomerCard extends Pane {

    protected final ImageView photo;
    protected final Label name;
    protected final Label mobile;
    protected final Label label;
    protected final Label date;
    protected final Label visits;
    protected final Label label0;
    protected final HBox iconContainer;
    protected final Button deleteButton;
    protected final Button modifyButton;
    private int ID;

    public CustomerCard(int Id, String Name, String Mobile, String Date, String Visits) {

        photo = new ImageView();
        name = new Label();
        mobile = new Label();
        label = new Label();
        date = new Label();
        visits = new Label();
        label0 = new Label();
        iconContainer = new HBox();
        deleteButton = new Button();
        modifyButton = new Button();

        setId(Id + "");
        setPrefHeight(233.0);
        setPrefWidth(245.0);
        setStyle("-fx-background-color:#FFF; -fx-border-radius: 10px; -fx-background-radius: 10px;");

        DropShadow dropShadow = new DropShadow();
        dropShadow.setHeight(3);
        dropShadow.setWidth(3);
        dropShadow.setBlurType(BlurType.TWO_PASS_BOX);
        setEffect(dropShadow);

        photo.setImage(new Image("https://www.irreverentgent.com/wp-content/uploads/2018/03/Awesome-Profile-Pictures-for-Guys-look-away2.jpg"));
        photo.setLayoutX(123.0);
        photo.setLayoutY(56.0);
        photo.setFitHeight(100);
        photo.setFitWidth(100);

        name.setAlignment(Pos.CENTER);
        name.setContentDisplay(ContentDisplay.CENTER);
        name.setLayoutX(14.0);
        name.setLayoutY(109.0);
        name.setPrefHeight(26.0);
        name.setPrefWidth(215.0);
        name.setText(Name);
        name.setFont(Font.font("System", FontWeight.BOLD, 17.0));

        mobile.setAlignment(Pos.CENTER);
        mobile.setContentDisplay(ContentDisplay.CENTER);
        mobile.setLayoutX(16.0);
        mobile.setLayoutY(143.0);
        mobile.setPrefHeight(19.0);
        mobile.setPrefWidth(215.0);
        mobile.setText(Mobile);
        mobile.setFont(new Font(13.0));

        label.setAlignment(Pos.TOP_RIGHT);
        label.setContentDisplay(ContentDisplay.CENTER);
        label.setLayoutX(39.0);
        label.setLayoutY(169.0);
        label.setPrefHeight(19.0);
        label.setPrefWidth(62.0);
        label.setText("Date:");
        label.setFont(new Font(13.0));

        date.setContentDisplay(ContentDisplay.CENTER);
        date.setLayoutX(107.0);
        date.setLayoutY(169.0);
        date.setPrefHeight(19.0);
        date.setPrefWidth(115.0);
        date.setText(Date);
        date.setFont(new Font(13.0));

        visits.setContentDisplay(ContentDisplay.CENTER);
        visits.setLayoutX(107.0);
        visits.setLayoutY(194.0);
        visits.setPrefHeight(19.0);
        visits.setPrefWidth(115.0);
        visits.setText(Visits);
        visits.setFont(new Font(13.0));
        label0.setAlignment(Pos.TOP_RIGHT);
        label0.setContentDisplay(ContentDisplay.CENTER);
        label0.setLayoutX(39.0);
        label0.setLayoutY(194.0);
        label0.setPrefHeight(19.0);
        label0.setPrefWidth(62.0);
        label0.setText("Visits:");
        label0.setFont(new Font(13.0));

        iconContainer.setAlignment(Pos.CENTER_RIGHT);
        iconContainer.setPrefHeight(40.0);
        iconContainer.setPrefWidth(200.0);
        iconContainer.setLayoutX(24);
        iconContainer.setLayoutY(206);
        deleteButton.setPrefHeight(32.0);
        deleteButton.setPrefWidth(32.0);
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
        modifyButton.setPrefWidth(32.0);
        modifyButton.getStyleClass().add("modify-button");
        modifyButton.setOnAction(e -> {
            // Perform modify operation here
        });

        iconContainer.getChildren().addAll(deleteButton, modifyButton);

        getChildren().addAll(photo, name, mobile, label, date, visits, label0, iconContainer);

    }
}
