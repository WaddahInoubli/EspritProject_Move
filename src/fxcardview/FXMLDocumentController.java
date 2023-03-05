package fxcardview;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities.UserReservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import services.serviceReservation;

/**
 *
 * @author SUWIMA
 */


public class FXMLDocumentController implements Initializable {
    @FXML
    private GridPane cardHolder;

    @FXML
    private  TextField searchField;

    ObservableList<fxcardview.CustomerCard> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        serviceReservation reservations1=new serviceReservation();

        ObservableList<UserReservation> reservations = FXCollections.observableArrayList();

        for (int k = 0; k <reservations1.afficher().size() ; k++) {

            LocalDate date1 = reservations1.afficher().get(k).getReservation().getDatedebut();
            LocalDate date2 = reservations1.afficher().get(k).getReservation().getDatefin();
            System.out.println(date1);
            long daysBetween = ChronoUnit.DAYS.between(date1, date2);
            Double prix = reservations1.afficher().get(0).getVoiture().getPrix();
            Double prixtotale = daysBetween * prix;

            if(reservations1.afficher().get(k).getReservation().isArchive()==false) {
                list.add(new fxcardview.CustomerCard(reservations1.afficher().get(k).getIdreservation(),
                        reservations1.afficher().get(k).getUser().getNom(),
                        reservations1.afficher().get(k).getUser().getPrenom(),
                        reservations1.afficher().get(k).getReservation().getDatedebut().toString(),
                        reservations1.afficher().get(k).getReservation().getDatefin().toString(),
                        reservations1.afficher().get(k).getUser().getEmail(),
                       String.valueOf( reservations1.afficher().get(k).getUser().getPhone()),
                        reservations1.afficher().get(k).getVoiture().getMarque(),
                        reservations1.afficher().get(k).getVoiture().getModele(),
                        prixtotale.toString()));

            }}
        cardHolder.setAlignment(Pos.CENTER);
        cardHolder.setVgap(40.00);
        cardHolder.setHgap(20.00);

        cardHolder.setPadding(new Insets(10, 20, 50, 40));

        cardHolder.setStyle("-fx-padding:10px;-fx-border-color:transparent;-fx-end-margin: 10px");

        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (count >= list.size()) {
                    break;
                }
                cardHolder.add(list.get(count), j, i);

                count++;
                //System.out.println(i + " " + j);
            }
        }

        updateCardHolder(list);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<fxcardview.CustomerCard> filteredList = list.filtered(card -> {
                String fullName = card.name + " " + card.mobile;
                return fullName.toLowerCase().contains(newValue.toLowerCase());
            });

            updateCardHolder(filteredList);
        });


    }




    private void updateCardHolder(List<CustomerCard> cards) {
        cardHolder.getChildren().clear();

        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (count >= cards.size()) {
                    break;
                }
                cardHolder.add(cards.get(count), j, i);

                count++;
            }
        }

        cardHolder.setAlignment(Pos.CENTER);
        cardHolder.setVgap(20.00);


    }
    }