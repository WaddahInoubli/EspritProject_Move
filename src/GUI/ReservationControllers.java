package GUI;

import entities.Reservation;
import entities.User;
import entities.UserReservation;
import entities.Voiture;
import interfaces.IserviceReservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.Servicevoiture;
import services.serviceReservation;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationControllers implements Initializable {

    @FXML
    private Label adressrequire;

    @FXML
    private Label datedebut;

    @FXML
    private Label datefinrequire;

    @FXML
    private Label emailrequire;

    @FXML
    private ChoiceBox<String> fxidlist;

    @FXML
    private TextField idadress;

    @FXML
    private Button idconfirme;

    @FXML
    private DatePicker iddatedebut;

    @FXML
    private TextField idemail;

    @FXML
    private DatePicker idfatefin;

    @FXML
    private TextField idnom;

    @FXML
    private TextField idphone;

    @FXML
    private TextField idprenom;

    @FXML
    private TextField idprix;

    @FXML
    private Button idreset;

    @FXML
    private Label listerequire;

    @FXML
    private Label nomrequire;
    @FXML
    private Button idconsulte;
    @FXML
    private Label phonerequire;

    @FXML
    private Label prenomrequire;

    @FXML
    private Label prixrequire;
    @FXML
    private Pane background;
    @FXML
    void Reset(ActionEvent event) {
      idadress.setText("");
      idemail.setText("");
      idphone.setText("");
      idnom.setText("");
      idprenom.setText("");
      idprix.setText("");

    }
UserReservation userReservation;
    @FXML
    public UserReservation addreseRvation(ActionEvent event) {
        User user=null;
        Reservation reservation=null;
        if (idprix.getText().isEmpty()){
            prixrequire.setText("champ prix obligatoir svp");
        } else if (idprenom.getText().isEmpty()){
            prenomrequire.setText("champ prenom obligatoir svp");
        } else if (idnom.getText().isEmpty()){
            nomrequire.setText("champ nom obligatoir svp");
        }
        else if (idadress.getText().isEmpty()){
            adressrequire.setText("champ address obligatoir svp");
        }
       else  if (idemail.getText().isEmpty()){
            emailrequire.setText("champ email obligatoir svp");
        }
        else if (idphone.getText().isEmpty()){
            phonerequire.setText("champ phone obligatoir svp");
        }
        else {
          String nom=  idnom.getText();

          String prenom = idprenom.getText();
          String address=idadress.getText();
            LocalDate datedebut=iddatedebut.getValue();
            LocalDate datefin=idfatefin.getValue();
            String email=idemail.getText();
            String phone=idphone.getText();
            int phone1= Integer.parseInt(phone);
             user = new User(nom, prenom, address,phone1, email );
             reservation = new Reservation(datedebut, datefin);


        }

        serviceReservation service =new serviceReservation();


UserReservation user1= new UserReservation(user,reservation);
        service.ajouter(user1);
        return user1;







    }
    @FXML
    void conssulterliste(ActionEvent event) throws IOException {
        Parent Home = FXMLLoader.load(getClass().getResource("confirm.fxml"));
        Scene home = new Scene(Home);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home);
        app_stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceBox<String> dropdown= new ChoiceBox<>();

        Servicevoiture servicevoiture =new Servicevoiture();

        for (int i = 0; i <servicevoiture.afficher().size() ; i++) {
            fxidlist.getItems().add(servicevoiture.afficher().get(i).getMarque()+" "+servicevoiture.afficher().get(i).getModele());

        }
    }
}