package GUI;

import entities.Reservation;
import entities.User;
import entities.UserReservation;
import entities.Voiture;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import services.Servicevoiture;
import services.serviceReservation;

import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
public class ReservationControllers implements Initializable {

    @FXML
    private TextField Periode;
    @FXML
    private TextField finalPrice;
    @FXML
    private CheckBox ifDriver;

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
    private  boolean cheked=false;
    @FXML
    private ImageView imageback;
    @FXML
    void Reset(ActionEvent event) {
      idadress.setText("");
      idemail.setText("");
      idphone.setText("");
      idnom.setText("");
      idprenom.setText("");
      idprix.setText("");

    }
    int id=0;
    ArrayList<Voiture> voitures=new ArrayList<>();
UserReservation userReservation;
    @FXML
    public UserReservation addreseRvation(ActionEvent event) {
        User user = null;
        Reservation reservation = null;
        serviceReservation service = new serviceReservation();
        try {

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
              alert.setContentText("error : choisir une date finale superieur a celle de debut ! ");
                alert.showAndWait();

            } else {


                boolean isSelected = ifDriver.isSelected();
                if(isSelected) {
                    System.out.println("Checkbox selected status: " + isSelected);
                }

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
      Voiture voiture =new Voiture(id);
        UserReservation user1 = new UserReservation(user, reservation,voiture);
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

    public String data;
    public void setData(String data) {
        this.data = data;
    }
    private void calculateDaysBetween() {
        LocalDate date1 = iddatedebut.getValue();
        LocalDate date2 = idfatefin.getValue();

        if (date1 != null && date2 != null) {
            long daysBetween = ChronoUnit.DAYS.between(date1, date2);
           Periode.setText(String.valueOf(daysBetween));
        } else {
            System.out.println("nnnnnn"); // vide le résultat s'il manque une des dates
        }
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



        iddatedebut.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);

                if (date.isBefore(LocalDate.now().plusDays(1))) {
                    setDisable(true);
                }
            }
        });
        idfatefin.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);

                if (date.isBefore(LocalDate.now().plusDays(1))) {
                    setDisable(true);
                }
            }
        });
        ChoiceBox<String> dropdown= new ChoiceBox<>();

        Servicevoiture servicevoiture =new Servicevoiture();

        for (int i = 0; i <servicevoiture.afficher().size() ; i++) {
            voitures.add( new Voiture(servicevoiture.afficher().get(i).getId(),servicevoiture.afficher().get(i).getMarque(),servicevoiture.afficher().get(i).getModele(),servicevoiture.afficher().get(i).getPrix()));

            System.out.println(servicevoiture.afficher().get(i).getModele()+" "+servicevoiture.afficher().get(i).getMarque());

        }
        for ( Voiture voiture:voitures) {
         fxidlist.getItems().add( voiture.getModele()+" "+voiture.getMarque());


        }
        fxidlist.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue.equals("BMW Serie 5")){
                Image image = new Image("C:/Users/user/Desktop/3a11_Jdbc_javafx/src/img/bm.jpg");


                BackgroundImage backgroundImage = new BackgroundImage(
                        image,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT
                );

                // Set the background of the root layout
                background.setBackground(new Background(backgroundImage));
            }if(newValue.equals("Mercedes CLA")){
                Image image = new Image("C:/Users/user/Desktop/3a11_Jdbc_javafx/src/img/marcedes.jpg");


                BackgroundImage backgroundImage = new BackgroundImage(
                        image,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT
                );

                // Set the background of the root layout
                background.setBackground(new Background(backgroundImage));
            }  if(newValue.equals("Golf 6 TSI")){
                Image image = new Image("C:/Users/user/Desktop/3a11_Jdbc_javafx/src/img/images.jpg");


                BackgroundImage backgroundImage = new BackgroundImage(
                        image,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT
                );

                // Set the background of the root layout
                background.setBackground(new Background(backgroundImage));
            }
            if(newValue.equals("Toyota Corolla")){
                Image image = new Image("C:/Users/user/Desktop/3a11_Jdbc_javafx/src/img/toyota.jpg");


                BackgroundImage backgroundImage = new BackgroundImage(
                        image,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT
                );

                // Set the background of the root layout
                background.setBackground(new Background(backgroundImage));
            }

        });

        fxidlist.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            for (Voiture voiture:voitures) {


            if(newValue.equals(voiture.getModele()+" " +voiture.getMarque())){
                 id=voiture.getId();
                idprix.setText( String.valueOf(voiture.getPrix()));
                System.out.println(id);


                SimpleDateFormat dateFormat = new
                        SimpleDateFormat ("yyyy-MM-dd");

                iddatedebut.valueProperty().addListener((observable1, oldValue1, newValue1) -> calculateDaysBetween());
                idfatefin.valueProperty().addListener((observable2, oldValue2, newValue2) -> calculateDaysBetween());
                LocalDate date1 = iddatedebut.getValue();
                LocalDate date2 = idfatefin.getValue();
                System.out.println(date2);
                System.out.println(date1);
                if(date1 !=null && date2 !=null) {

                    long datetotale=ChronoUnit.DAYS.between(date1, date2);

                    Double prixtototale=datetotale * voiture.getPrix();
                    finalPrice.setText(String.valueOf(prixtototale));

                    System.out.println(datetotale);

                }
            }
            }


        });




    }
    }
