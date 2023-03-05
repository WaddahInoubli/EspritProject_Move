/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import entities.reponse;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.serviceReponse;
import utils.MyDB;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class ReponsefXMLController implements Initializable {

   
    @FXML
    private Button btn_add;

    @FXML
    private Label label;

    @FXML
    private TextField txtobjectif;

    @FXML
    private TextField txttexte;

    @FXML
    private TextField txtetat;
      @FXML
    private TextField idrep;
        @FXML
         private Button supprimer;
             @FXML
         private Button modif;
                  @FXML
         private Button afficher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void  addr(ActionEvent event) throws SQLException {
               if (txtobjectif.getText().isEmpty() && txttexte.getText().isEmpty() && txtetat.getText().isEmpty())
               {
                Alert a = new Alert(Alert.AlertType.ERROR, "données invalide(s)", ButtonType.OK);
            a.showAndWait();   
               }
               else { 
                   try{
        reponse r1 = new reponse(txtobjectif.getText(),txttexte.getText(), txtetat.getText()); 
        

        serviceReponse s= new serviceReponse();
        s.ajouter2(r1);    
         Alert a = new Alert(Alert.AlertType.INFORMATION, "Ajout effectué", ButtonType.OK);
            a.showAndWait();   
    }
              catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
              }
               }
    }
    @FXML
    private void delrec(ActionEvent event) throws SQLException {
       
           serviceReponse s = new serviceReponse();
       
        s.supprimer(Integer.parseInt(idrep.getText()));
        
       
       
               }

    
    
    @FXML
    private void afficher(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("afficher_reclamation_fxml.fxml"));
          AnchorPane anchorPane;
          anchorPane = fxmlLoader.load();
          Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
        serviceReponse s = new serviceReponse();
        
        
        
    }

    @FXML
    private void modif(ActionEvent event) throws SQLException {
        Connection connection;
    Statement ste;
    connection = MyDB.getInstance().getCon();
        serviceReponse s = new serviceReponse();
      reponse r = new reponse();  
      r=s.OneCat(Integer.parseInt(idrep.getText()));
      String requete = "UPDATE reponse SET objectif=?, texte=? ,etat= ? where id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
        
            pst.setString(1,txtobjectif.getText());
            
            pst.setString(2, txttexte.getText());
            pst.setString(3, txtetat.getText());
            pst.setInt(4, r.getid());
            pst.executeUpdate();
            System.out.println(" reponse Modifiée! ");
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Modif effectué", ButtonType.OK);
            a.showAndWait();  
    }
    
}
