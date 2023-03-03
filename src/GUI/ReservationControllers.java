package GUI;
import java.awt.*;
import java.io.*;
import java.net.*;

import entities.Reservation;
import entities.User;
import entities.UserReservation;
import entities.Voiture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.Servicevoiture;
import services.serviceReservation;


import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

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
    private void Reset(ActionEvent event) {
        // Create a new stage
        Stage newStage = new Stage();

        // Set the owner of the new stage to the main window's stage
        newStage.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());

        // Create a new VBox to hold the contents of the new window
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        // Create a label to display a message in the new window
        Label messageLabel = new Label("Are you sure you want to reset all fields?");
        messageLabel.setFont(Font.font("System", FontWeight.BOLD, 16));


        // Create a HBox to hold the "Yes" and "No" buttons
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);

        // Create the "Yes" button and set its action
        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> {
            // Reset all fields
            idadress.setText("");
            idemail.setText("");
            idphone.setText("");
            idnom.setText("");
            idprenom.setText("");
            idprix.setText("");

            // Close the new window
            newStage.close();
        });

        // Create the "No" button and set its action
        Button noButton = new Button("No");
        noButton.setOnAction(e -> {
            // Close the new window
            newStage.close();
        });

        // Add the buttons to the button box
        buttonBox.getChildren().addAll(yesButton, noButton);

        // Add the label and button box to the VBox
        vBox.getChildren().addAll(messageLabel, buttonBox);

        // Create a new scene for the VBox and set it on the new stage
        Scene scene = new Scene(vBox);
        newStage.setScene(scene);

        // Set the modality of the new stage to WINDOW_MODAL, so it blocks input to the main window until it is closed
        newStage.initModality(Modality.WINDOW_MODAL);

        // Show the new stage
        newStage.show();
    }

    int id=0;
    ArrayList<Voiture> voitures=new ArrayList<>();
UserReservation userReservation;

    public String sendSms() {
        try {
            // Construct data
            String apiKey = "apikey=" + "NDQ2ZjM4MzU2NzUwN2E3MDZjNDk0NjM4NmUzMjU0NWE=";
            String message = "&message=" + "This is your message";
            String sender = "&sender=" + "Waddah ";
            String numbers = "&numbers=" + "+21650362889";

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }

            System.out.println("hello");
            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
        }
    }

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
        sendSms();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ajout user");
        alert.setHeaderText(null);
        alert.setContentText("Client ajouter avec succes  ! ");
        alert.showAndWait();
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

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // This code will be executed every minute
                System.out.println("Hello, World!");
            }
        };
        // Schedule the task to run every minute
        long delay = 0;
        long period = 60 * 1000; // 1 minute
        timer.scheduleAtFixedRate(task, delay, period);
        Date date1 = new Date();
        Date date2 = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24); // tomorrow
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String prim=formatter.format(date1);
        String prim1=formatter.format(date2);
        System.out.println(prim);
        // Compare the two dates
        int result = prim.compareTo(prim1);

        // Print the result
        if (result < 0) {
            System.out.println( prim+"Date 1 is before Date 2");
        } else if (result > 0) {
            System.out.println("Date 1 is after Date 2");
        } else {
            System.out.println("Date 1 is equal to Date 2");
        }
    }
    }
