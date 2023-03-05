/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.serviceReclamation;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifierRecController implements Initializable {

    @FXML
    private Text reclamation;
    @FXML
    private Text reclamation1;
    @FXML
    private Text reclamation11;
    @FXML
    private TextField modifobj;
    @FXML
    private TextArea modiftext;
    Reclamation w;
    serviceReclamation sr = new serviceReclamation();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    void getRec(Reclamation r)
    {
        modifobj.setText(r.getObjectif());
        modiftext.setText(r.getText());
        
        w = (r);
    }
    @FXML
    private void ajjout(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("reclamationfxml.fxml"));
            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(anchorPane));
            stage.show();
            serviceReclamation s = new serviceReclamation();
        } catch (IOException ex) {
            Logger.getLogger(ReclamationfxmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afff(MouseEvent event) {
          try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AfficheRec.fxml"));
            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(anchorPane));
            stage.show();
            serviceReclamation s = new serviceReclamation();
        } catch (IOException ex) {
            Logger.getLogger(ReclamationfxmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modif(ActionEvent event) {
        
        if (modifobj.getText().isEmpty() || modiftext.getText().isEmpty() )
               {
                Alert a = new Alert(Alert.AlertType.ERROR, "données invalide(s)", ButtonType.OK);
            a.showAndWait();   
               }
        else {
            try {
                w.settext(modiftext.getText());
                w.setobjectif(modifobj.getText());
                sr.modifier(w);
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Modification effectué", ButtonType.OK);
                a.showAndWait();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheRec.fxml"));
                Parent view_2=loader.load();
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(view_2);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ModifierRecController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }}
    
}
