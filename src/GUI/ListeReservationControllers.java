package GUI;

import entities.Reservation;
import entities.User;
import entities.UserReservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.serviceReservation;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ListeReservationControllers implements Initializable {

    @FXML
    private TableView<UserReservation> ReservationManager;

    @FXML
    private TableColumn<UserReservation, String> addresse;

    @FXML
    private TableColumn<User,String > chauffeur;

    @FXML
    private TableColumn<UserReservation, Date> datedebut;

    @FXML
    private TableColumn<UserReservation, Date> datefin;

    @FXML
    private TableColumn<UserReservation, String> email;

    @FXML
    private TableColumn<UserReservation, String> nom;

    @FXML
    private TableColumn<UserReservation, String> prenom;

    @FXML
    private TableColumn<Reservation, Double> prix;

    @FXML
    private TableColumn<UserReservation, String> telephone;


    @FXML
    void Delete(ActionEvent event) {
        UserReservation row = ReservationManager.getSelectionModel().getSelectedItem();
        ReservationManager.getItems().remove(row);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        serviceReservation reservations1=new serviceReservation();

        ObservableList<UserReservation> reservations = FXCollections.observableArrayList();

        for (int i = 0; i <reservations1.afficher().size() ; i++) {
            reservations.add(new UserReservation(new User(reservations1.afficher().get(i).getUser().getNom(),reservations1.afficher().get(i).getUser().getPrenom(),reservations1.afficher().get(i).getUser().getAddress(),reservations1.afficher().get(i).getUser().getPhone(),reservations1.afficher().get(i).getUser().getEmail()), new Reservation(reservations1.afficher().get(i).getReservation().getDatedebut(),reservations1.afficher().get(i).getReservation().getDatefin())));

        }


           datedebut.setCellValueFactory(new PropertyValueFactory<UserReservation, Date>("datedebut"));
           datefin.setCellValueFactory(new PropertyValueFactory<UserReservation, Date>("datefin"));
           nom.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("nom"));
           prenom.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("prenom"));
           addresse.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("address"));
           email.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("email"));
           telephone.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("phone"));



       ReservationManager.setItems(reservations);

    }
}
