package GUI;

import entities.Reservation;
import entities.User;
import entities.UserReservation;
import entities.Voiture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.serviceReservation;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ModifierReservationControllers  implements Initializable {


    @FXML
    private TextField Periode;
    @FXML
    private TextField finalPrice;
    @FXML
    private CheckBox ifDriver;

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
    private ChoiceBox<String> fxidlist;

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
    private  boolean cheked=false;
    Reservation reservation=Reservation.getInstance();
    String modele="";
    String marque="";
    Double prix;
    int id;

    private void update(){

        User user = null;
        Reservation reservation = null;
        serviceReservation service = new serviceReservation();
        try {

            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "reservation modifier", ButtonType.OK);
            alert1.setTitle("modification Status");
            alert1.setHeaderText("modification Successful");
            alert1.showAndWait();
            SimpleDateFormat dateFormat = new
                    SimpleDateFormat ("yyyy-MM-dd");
            Date date1 = dateFormat.parse(String.valueOf(iddatedebut.getValue()));
            Date date2 = dateFormat.parse(String.valueOf(idfatefin.getValue()));



            if (idprix.getText().isEmpty()) {
                prixrequire.setText("champ prix obligatoir svp");
            } else if (idprenom.getText().isEmpty()) {
                prenomrequire.setText("champ prenom obligatoir svp");
            } else if (idnom.getText().isEmpty()) {
                nomrequire.setText("champ nom obligatoir svp");
            } else if (idadress.getText().isEmpty()) {
                adressrequire.setText("champ address obligatoir svp");
            } else if (idemail.getText().isEmpty()) {
                emailrequire.setText("champ email obligatoir svp");
            } else if (idphone.getText().isEmpty()) {
                phonerequire.setText("champ phone obligatoir svp");
            } else if (iddatedebut.equals(null)) {
                datedebut.setText("champ date debut obligatoir svp");

            } else if (idfatefin.equals(null)) {
                datefinrequire.setText("champ datefin obligatoir svp");
            } else   if(date2.before(date1)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid date");
                alert.setHeaderText(null);
                alert.setContentText(" invalid date ");
                alert.showAndWait();

            } else {




                String nom = idnom.getText();

                String prenom = idprenom.getText();
                String address = idadress.getText();
                LocalDate datedebut = iddatedebut.getValue();
                LocalDate datefin = idfatefin.getValue();
                String email = idemail.getText();
                String phone = idphone.getText();

                int phone1 = Integer.parseInt(phone);
                user = new User(nom, prenom, address, phone1, email);
                reservation = new Reservation(datedebut, datefin,cheked);


            }


        } catch (Exception e) {
            System.out.println( "erroror:"+e.getMessage());
        }
        Voiture voiture =new Voiture(id,modele,marque,prix);
        UserReservation user1 = new UserReservation(user, reservation,voiture);
        service.modifier(user1);
    }
    @FXML
    void UpdateReservatioon(ActionEvent event) {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "voulez vraiment modifier?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("update Confirmation");
        alert.setHeaderText("Confirm update");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            update();
        }




    }

    @FXML
    void conssulterliste(ActionEvent event) throws IOException {
        Parent Home = FXMLLoader.load(getClass().getResource("confirm.fxml"));
        Scene home = new Scene(Home);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home);
        app_stage.show();
    }
    public String data;
    public void setData(String data) {
        this.data = data;
    }


    public void affichedata(){
        System.out.println( reservation.getId());
        serviceReservation reservations1=new serviceReservation();

        ArrayList<UserReservation> reservations = new ArrayList<>();

        for (int i = 0; i <reservations1.afficheronereservation(reservation.getId()).size() ; i++) {
            reservations.add(new UserReservation(new User(reservations1.afficheronereservation(reservation.getId()).get(i).getUser().getNom(),reservations1.afficheronereservation(reservation.getId()).get(i).getUser().getPrenom(),reservations1.afficheronereservation(reservation.getId()).get(i).getUser().getAddress(),reservations1.afficheronereservation(reservation.getId()).get(i).getUser().getPhone(),reservations1.afficheronereservation(reservation.getId()).get(i).getUser().getEmail()), new Reservation(reservations1.afficheronereservation(reservation.getId()).get(i).getReservation().getId(),reservations1.afficheronereservation(reservation.getId()).get(i).getReservation().getDatedebut(),reservations1.afficheronereservation(reservation.getId()).get(i).getReservation().getDatefin(),reservations1.afficheronereservation(reservation.getId()).get(i).getReservation().getIfdriver(),reservations1.afficheronereservation(reservation.getId()).get(i).getReservation().isArchive()),new Voiture(reservations1.afficheronereservation(reservation.getId()).get(i).getIdvoiture(),reservations1.afficheronereservation(reservation.getId()).get(i).getVoiture().getModele(),reservations1.afficheronereservation(reservation.getId()).get(i).getVoiture().getMarque(),reservations1.afficheronereservation(reservation.getId()).get(i).getVoiture().getPrix() )));
            System.out.println( "datefin"+reservations.get(i).getReservation().getDatefin());
        }
        idnom.setText(reservations.get(0).getUser().getNom());
        idprenom.setText(reservations.get(0).getUser().getPrenom());
        idadress.setText(reservations.get(0).getAddress());
        idemail.setText(reservations.get(0).getEmail());
        idphone.setText(String.valueOf(reservations.get(0).getPhone()));
        iddatedebut.setValue(reservations.get(0).getReservation().getDatedebut());
        idfatefin.setValue(reservations.get(0).getReservation().getDatefin());
        idprix.setText(String.valueOf(reservations.get(0).getVoiture().getPrix()));

        if(reservations.get(0).getReservation().getIfdriver()){
            ifDriver.setSelected(true);
        }
            marque=reservations.get(0).getVoiture().getModele();
        modele=reservations.get(0).getVoiture().getMarque();
        prix=reservations.get(0).getVoiture().getPrix();
        id=reservations.get(0).getVoiture().getId();
         fxidlist.getItems().add(String.valueOf(reservations.get(0).getVoiture().getModele() + " " + reservations.get(0).getVoiture().getMarque()));

        fxidlist.getSelectionModel().select(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ifDriver.setOnAction(event -> {
            boolean isSelected = ifDriver.isSelected();
            if(isSelected){
                cheked= true;
            }else  {
                cheked=false;
            }
            System.out.println(cheked);
        });

        affichedata();







    }
}
