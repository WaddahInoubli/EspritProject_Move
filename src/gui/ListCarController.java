package  gui;

import entities.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class ListCarController implements Initializable {


    @FXML
    private TableView<Car> carview;
    @FXML
    private TableColumn<Car, String> couleur;

    @FXML
    private TableColumn<Car, String> modele;

    @FXML
    private TableColumn<Car, String> matricule;

    @FXML
    private TableColumn<Car, String> marque;
    @FXML
    private TableColumn<Car, Double> prix;
ObservableList<Car> car = FXCollections.observableArrayList(
        new Car("red","sport",20.5,"188"),
        new Car("bleu","F1",30,"885")
);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
 couleur.setCellValueFactory(new PropertyValueFactory<Car, String>("couleur"));
        modele.setCellValueFactory(new PropertyValueFactory<Car, String>("modele"));
        matricule.setCellValueFactory(new PropertyValueFactory<Car, String>("matricule"));
        prix.setCellValueFactory(new PropertyValueFactory<Car, Double>("prix"));


        carview.setItems(car);

    }
}