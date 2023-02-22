package gui;
import entities.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import services.ServicePersonne;
import utils.MyDB;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AffichageFXMLController implements Initializable {
    @FXML
    private CheckBox tfDriver;

    @FXML
    private Button tfcancel;

    @FXML
    private Button tfconfirm;

    @FXML
    private TextField tfaddress;

    @FXML
    private DatePicker tfdate1;

    @FXML
    private DatePicker tfdate2;

    @FXML
    private TextField tfmail;

    @FXML
    private TextField tfnom;

    @FXML
    private TextField tfphone;

    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tlresultat;
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    public AffichageFXMLController() {
        connection = MyDB.getInstance().getCon();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ServicePersonne p = new ServicePersonne();
        tfaddress.setText(p.afficher().get(0).getAddresse());
        tfmail.setText(p.afficher().get(0).getmail());
        tfphone.setText(p.afficher().get(0).getPhone());
        tfnom.setText(p.afficher().get(0).getNom());
        tfprenom.setText(p.afficher().get(0).getPrenom());

    }

   @FXML
    public void addPersonne(ActionEvent event) throws IOException {
     /*   Parent Home = FXMLLoader.load(getClass().getResource("ListCar.fxml"));
        Scene home = new Scene(Home);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home);
        app_stage.show();



*/



       LocalDate dateDebut=tfdate1.getValue();
       LocalDate dateFin=tfdate2.getValue();
       if (dateDebut == null || dateFin == null) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Invalid Input");
           alert.setHeaderText(null);
           alert.setContentText("Please select a valid date for both fields.");
           alert.showAndWait();
           return;
       }

       try {

           PreparedStatement preparedStatement = connection.prepareStatement(
                   "INSERT INTO reservation (id_client_FK , id_voiture_FK, DateDebutReservation, DateFinReservation,id_driver_FK,ifDriver,prix) VALUES (?, ?, ?, ?,?,?,?)");
           preparedStatement.setInt(1, 2);
           preparedStatement.setInt(2, 2);
preparedStatement.setDate(3, Date.valueOf(dateDebut));
preparedStatement.setDate(4, Date.valueOf(dateFin));
preparedStatement.setInt(5,3);
preparedStatement.setInt(6,0);
preparedStatement.setInt(7,250);
           preparedStatement.executeUpdate();
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Success");
           alert.setHeaderText(null);
           alert.setContentText("Your operation was successful!");
           alert.showAndWait();
       } catch (SQLException ex) {
           System.out.println("Exception: " + ex.getMessage());
       }












}}

