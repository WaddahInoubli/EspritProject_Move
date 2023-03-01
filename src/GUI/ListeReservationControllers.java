package GUI;


import entities.Reservation;
import entities.User;
import entities.UserReservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.serviceReservation;

import java.io.IOException;
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
    private TableColumn<UserReservation, Double> prix;

    @FXML
    private TableColumn<UserReservation, String> telephone;



int iduser= 0;

    @FXML
    private void handleDeleteButtonAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Delete Confirmation");
        alert.setHeaderText("Confirm Deletion");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            Delete();
        }
    }
    UserReservation Delete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Item deleted successfully.", ButtonType.OK);
        alert.setTitle("Deletion Status");
        alert.setHeaderText("Deletion Successful");
        alert.showAndWait();
        serviceReservation delete=new serviceReservation();
        UserReservation row = ReservationManager.getSelectionModel().getSelectedItem();
        Reservation reservation =null;
        System.out.println(row.getReservation().getId());
        int id=row.getReservation().getId();
        iduser=id;
        reservation=new Reservation(id);
        UserReservation user1= new UserReservation(reservation);
        delete.supprimer(user1);
        ReservationManager.getItems().remove(row);
        return user1;
    }
    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        serviceReservation reservations1=new serviceReservation();

        ObservableList<UserReservation> reservations = FXCollections.observableArrayList();

        for (int i = 0; i <reservations1.afficher().size() ; i++) {
            reservations.add(new UserReservation(new User(reservations1.afficher().get(i).getUser().getNom(),reservations1.afficher().get(i).getUser().getPrenom(),reservations1.afficher().get(i).getUser().getAddress(),reservations1.afficher().get(i).getUser().getPhone(),reservations1.afficher().get(i).getUser().getEmail()), new Reservation(reservations1.afficher().get(i).getReservation().getId(),reservations1.afficher().get(i).getReservation().getDatedebut(),reservations1.afficher().get(i).getReservation().getDatefin(),reservations1.afficher().get(i).getReservation().getIfdriver())));

        }
        System.out.println(reservations.get(0).getReservation().getDatefin());

           datedebut.setCellValueFactory(new PropertyValueFactory<UserReservation, Date>("datedebut"));
           datefin.setCellValueFactory(new PropertyValueFactory<UserReservation, Date>("datefin"));
           nom.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("nom"));
           prenom.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("prenom"));
           addresse.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("address"));
           email.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("email"));
           telephone.setCellValueFactory(new PropertyValueFactory<UserReservation, String>("phone"));



       ReservationManager.setItems(reservations);

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
