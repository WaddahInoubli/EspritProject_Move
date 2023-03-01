package GUI;

import entities.Reservation;
import entities.User;
import entities.UserReservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import services.serviceReservation;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ModifierReservationControllers  implements Initializable {

    @FXML
    private Label adressrequire;

    @FXML
    private Pane background;

    @FXML
    private Label datedebut;

    @FXML
    private Label datefinrequire;

    @FXML
    private Label emailrequire;

    @FXML
    private ChoiceBox<?> fxidlist;

    @FXML
    private TextField idadress;

    @FXML
    private Button idconfirme;

    @FXML
    private Button idconsulte;

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
    private ImageView imageback;

    @FXML
    private Label listerequire;

    @FXML
    private Label nomrequire;

    @FXML
    private Label phonerequire;

    @FXML
    private Label prenomrequire;

    @FXML
    private Label prixrequire;

    @FXML
    void Reset(ActionEvent event) {

    }

    @FXML
    void addreseRvation(ActionEvent event) {

    }

    @FXML
    void conssulterliste(ActionEvent event) {

    }
    public String data;
    public void setData(String data) {
        this.data = data;
    }
    Reservation reservation=Reservation.getInstance();

    public void affichedata(){
        System.out.println( reservation.getId());
        serviceReservation reservations1=new serviceReservation();

        ArrayList<UserReservation> reservations = new ArrayList<>();

        for (int i = 0; i <reservations1.afficheronereservation(reservation.getId()).size() ; i++) {
            reservations.add(new UserReservation(new User(reservations1.afficheronereservation(reservation.getId()).get(i).getUser().getNom(),reservations1.afficheronereservation(reservation.getId()).get(i).getUser().getPrenom(),reservations1.afficheronereservation(reservation.getId()).get(i).getUser().getAddress(),reservations1.afficheronereservation(reservation.getId()).get(i).getUser().getPhone(),reservations1.afficheronereservation(reservation.getId()).get(i).getUser().getEmail()), new Reservation(reservations1.afficheronereservation(reservation.getId()).get(i).getReservation().getId(),reservations1.afficheronereservation(reservation.getId()).get(i).getReservation().getDatedebut(),reservations1.afficheronereservation(reservation.getId()).get(i).getReservation().getDatefin(),reservations1.afficheronereservation(reservation.getId()).get(i).getReservation().getIfdriver())));
            System.out.println(reservations.get(i).getReservation().getDatefin());
        }
        idnom.setText(reservations.get(0).getUser().getNom());

        idprenom.setText(reservations.get(0).getUser().getPrenom());
        idadress.setText(reservations.get(0).getAddress());
        idemail.setText(reservations.get(0).getEmail());
        idphone.setText(String.valueOf(reservations.get(0).getPhone()));
        iddatedebut.setValue(reservations.get(0).getReservation().getDatedebut());
        idfatefin.setValue(reservations.get(0).getReservation().getDatefin());


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

 affichedata();







    }
}
