/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.voiture;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.VoitureService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class GestionVoitureController implements Initializable {

    @FXML
    private Button supp;
    @FXML
    private Button modif;
    @FXML
    private Button Ajouter;
    @FXML
    private Label imgpathttt;
    @FXML
    private Label labelid;
    @FXML
    private TextField inputRech;
    @FXML
    private Hyperlink Retour;
    @FXML
    private Button pdf2;
    @FXML
    private Button afficherparprix;
    @FXML
    private TableView<voiture> tableview;
    @FXML
    private TableColumn<?, ?> etat;
    @FXML
    private TableColumn<?, ?> annes;
    @FXML
    private TableColumn<?, ?> prix_h;
    @FXML
    private TableColumn<?, ?> id_m;
 public ObservableList<voiture> list;
 private Label label;
 public static voiture connectedvoiture;
    
    VoitureService voitureService = new VoitureService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     ArrayList<voiture> c = new ArrayList<>();
  
        try {
            c = (ArrayList<voiture>) voitureService.listervoitures();
        } catch (SQLException ex) {
        }
   
        
        ObservableList<voiture> obs2 = FXCollections.observableArrayList(c);
        tableview.setItems(obs2);
        
        
           
        
        
 etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        annes.setCellValueFactory(new PropertyValueFactory<>("annes"));
        prix_h.setCellValueFactory(new PropertyValueFactory<>("prix_h"));
   id_m.setCellValueFactory(new PropertyValueFactory<>("id_m"));
            try {
            list = FXCollections.observableArrayList(
                    voitureService.listervoitures()
            );        
        
        
   FilteredList<voiture> filteredData = new FilteredList<>(list, e -> true);
            inputRech.setOnKeyReleased(e -> {
                inputRech.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super voiture>) voitures -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        if (Integer.toString(voitures.getMatricule()).toLowerCase().contains(lower)) {
                            return true;
                        }
                        return false;
                    });
                });
                SortedList<voiture> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
   public void resetTableData() throws SQLDataException, SQLException {
        List<voiture> listrec = new ArrayList<>();
        listrec = voitureService.listervoitures();
        ObservableList<voiture> data = FXCollections.observableArrayList(listrec);
        tableview.setItems(data);
    }
    @FXML
    private void supp(ActionEvent event) throws SQLException {
         if (event.getSource() == supp) {
            voiture rec = new voiture();

            rec.setMatricule(tableview.getSelectionModel().getSelectedItem().getMatricule());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Delete ");
      alert.setHeaderText("Are you sure want to delete this product");
      alert.setContentText(" ");

      // option != null.
      Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
           voitureService.supprimervoiture2(rec);
    
       
      } else if (option.get() == ButtonType.CANCEL) {
      
      } else {
         this.label.setText("-");
      }
          
           
                              TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Supprimé avec succés");
            tray.setMessage("Supprimé avec succés");
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        
            
            
            resetTableData();

        }
        
        
        
    }

    @FXML
    private void Modif(ActionEvent event) throws IOException {
        voiture c = new voiture(tableview.getSelectionModel().getSelectedItem().getMatricule(),
                tableview.getSelectionModel().getSelectedItem().getEtat(),
                 tableview.getSelectionModel().getSelectedItem().getAnnes(),
                tableview.getSelectionModel().getSelectedItem().getPrix_h(),
               tableview.getSelectionModel().getSelectedItem().getId_m()
   
        );
               
               
        GestionVoitureController.connectedvoiture = c;
        
             Parent page1 = FXMLLoader.load(getClass().getResource("ModifierVoiture.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
        
        
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
               Parent page1 = FXMLLoader.load(getClass().getResource("AjouterVoiture.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void Retour(ActionEvent event) {
    }



  private void printPDF() throws FileNotFoundException, DocumentException, IOException {

Document d = new Document();
        PdfWriter.getInstance(d, new FileOutputStream("..\\ListVoiture.pdf"));
        d.open();
        
        PdfPTable pTable = new PdfPTable(3);
       

     
        
        tableview.getItems().forEach((t) -> {
       pTable.addCell(String.valueOf(t.getEtat()));
         pTable.addCell(String.valueOf(t.getAnnes()));
        pTable.addCell(String.valueOf(t.getPrix_h()));


       
        });
        
                        d.add(pTable);

        d.close();
        Desktop.getDesktop().open(new File("..\\ListVoiture.pdf"));


  } 
    
    
    
    
    @FXML
    private void pdf2(ActionEvent event) throws FileNotFoundException, DocumentException, IOException {
         if (event.getSource() == pdf2) {
            
             printPDF();
            
   
       }
    
}

    @FXML
    private void afficherparprix(ActionEvent event) throws SQLException {
        List<voiture> listrec = new ArrayList<>();
        listrec = voitureService.listervoitureParPrix();
        ObservableList<voiture> data = FXCollections.observableArrayList(listrec);
        tableview.setItems(data);
        
        
    }
    
    
    
    
}
