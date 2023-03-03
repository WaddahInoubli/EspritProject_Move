package GUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import entities.Reservation;
import entities.User;
import entities.UserReservation;
import entities.Voiture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.serviceReservation;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ListeReservationControllers implements Initializable {

    @FXML
    private TableView<UserReservation> ReservationManager;

    @FXML
    private TableColumn<UserReservation, String> addresse;

    @FXML
    private TableColumn<UserReservation,String > chauffeur;

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
    private TableColumn<UserReservation, Double> prix;

    @FXML
    private TableColumn<UserReservation, String> telephone;

    @FXML
    private  TextField searchField;


int iduser= 0;


    @FXML
    private void handleDeleteButtonAction(ActionEvent event) {
        UserReservation row = ReservationManager.getSelectionModel().getSelectedItem();
    }
    UserReservation  Delete() {
        UserReservation user1=null;
        try {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Item deleted successfully.", ButtonType.OK);
            alert.setTitle("Deletion Status");
            alert.setHeaderText("Deletion Successful");
            alert.showAndWait();
            serviceReservation delete = new serviceReservation();
            UserReservation row = ReservationManager.getSelectionModel().getSelectedItem();
            Reservation reservation = null;
            System.out.println(row.getReservation().getId());
            int id = row.getReservation().getId();
            iduser = id;
            reservation = new Reservation(id);
             user1 = new UserReservation(reservation);
            delete.supprimer(id);
            ReservationManager.getItems().remove(row);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return user1;
    }
    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {







        serviceReservation reservations1=new serviceReservation();

        ObservableList<UserReservation> reservations = FXCollections.observableArrayList();

        for (int i = 0; i <reservations1.afficher().size() ; i++) {

            LocalDate date1=reservations1.afficher().get(i).getReservation().getDatedebut();
            LocalDate date2=reservations1.afficher().get(i).getReservation().getDatefin();

            long daysBetween = ChronoUnit.DAYS.between(date1, date2);
            Double prix=reservations1.afficher().get(i).getVoiture().getPrix();
            Double prixtotale=daysBetween*prix;

            reservations.add(new UserReservation(new User(reservations1.afficher().get(i).getUser().getNom(),reservations1.afficher().get(i).getUser().getPrenom(),reservations1.afficher().get(i).getUser().getAddress(),reservations1.afficher().get(i).getUser().getPhone(),reservations1.afficher().get(i).getUser().getEmail()), new Reservation(reservations1.afficher().get(i).getReservation().getId(),reservations1.afficher().get(i).getReservation().getDatedebut(),reservations1.afficher().get(i).getReservation().getDatefin(),reservations1.afficher().get(i).getReservation().getIfdriver()),new Voiture(prixtotale)));

        }
        System.out.println(reservations.get(0).getReservation().getDatefin());

           datedebut.setCellValueFactory(new PropertyValueFactory<UserReservation, Date>("datedebut"));
           datefin.setCellValueFactory(new PropertyValueFactory<UserReservation, Date>("datefin"));
           nom.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("nom"));
           prenom.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("prenom"));
           addresse.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("address"));
           email.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("email"));
           telephone.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("phone"));
           chauffeur.setCellValueFactory(new PropertyValueFactory<UserReservation,String>("ifdriver"));
           prix.setCellValueFactory(new PropertyValueFactory<UserReservation,Double>("prix"));




       ReservationManager.setItems(reservations);
        FilteredList<UserReservation> filteredList = new FilteredList<>(reservations, p -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(personne -> {
                if (newValue == null || newValue.isEmpty()) {

                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (Boolean.getBoolean(personne.getNom().toLowerCase().contains(lowerCaseFilter)+" "+personne.getPrenom().toLowerCase().contains(lowerCaseFilter))) {
                    return true;
                } else if (personne.getPrenom().toLowerCase().contains(lowerCaseFilter) ) {
                    return true;
                }
                else if (String.valueOf(personne.getPhone()).contains(newValue)) {
                    return true;
                }
                return false;
            });
        });


        ReservationManager.setItems(filteredList);

    }

    Reservation reservation=Reservation.getInstance();
    public void Modiferreservation(ActionEvent event) throws IOException {


        UserReservation row = ReservationManager.getSelectionModel().getSelectedItem();

        System.out.println(row.getReservation().getId());
        int id=row.getReservation().getId();
reservation.setId(id);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierReservation.fxml"));
        Parent root = loader.load();

        Scene secondScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(secondScene);
        window.show();








    }
}
