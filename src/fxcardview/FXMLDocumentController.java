package fxcardview;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import entities.Reservation;
import entities.User;
import entities.UserReservation;
import entities.Voiture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import services.serviceReservation;

/**
 *
 * @author SUWIMA
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private GridPane cardHolder;
    ObservableList<fxcardview.CustomerCard> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        serviceReservation reservations1=new serviceReservation();

        ObservableList<UserReservation> reservations = FXCollections.observableArrayList();



            LocalDate date1=reservations1.afficher().get(0).getReservation().getDatedebut();
            LocalDate date2=reservations1.afficher().get(0).getReservation().getDatefin();
        System.out.println(date1);
            long daysBetween = ChronoUnit.DAYS.between(date1, date2);
            Double prix=reservations1.afficher().get(0).getVoiture().getPrix();
            Double prixtotale=daysBetween*prix;


        list.add(new fxcardview.CustomerCard(1,reservations1.afficher().get(0).getUser().getNom(), "96******30", "10/02/2019", "3"));

        cardHolder.setAlignment(Pos.CENTER);
        cardHolder.setVgap(20.00);
        cardHolder.setHgap(20.00);
        cardHolder.setStyle("-fx-padding:10px;-fx-border-color:transparent");

        onSearch();


    }

    @FXML
    public void onSearch() {
        int count = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                cardHolder.add(list.get(count), j, i);
                count++;
                //System.out.println(i + " " + j);
            }
        }

    }
}