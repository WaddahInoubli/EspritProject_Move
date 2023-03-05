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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.serviceReclamation;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AfficheRecController implements Initializable {

    @FXML
    private Text reclamation;
    @FXML
    private Text reclamation1;
    @FXML
    private Text reclamation11;
    @FXML
    private ScrollPane scrollpane;
    serviceReclamation sr = new serviceReclamation();
    @FXML
    private TextField tfrech;

    /**
     * Initializes the controller class.
     */
    
     public void table(){
        List<Reclamation> offres = sr.getMyRtrans(333);
        VBox vBox = new VBox();
        
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(30);
        

        HBox hBox = new HBox();
         
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);//
        

        int count = 0;
        for (Reclamation offre : offres) {
            VBox box = createOffreBox(offre);
            
            hBox.getChildren().add(box);
            count++;

            if (count == 1) {
                vBox.getChildren().add(hBox);
                hBox = new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(100);
                count = 0;
            }
        }

        if (count > 0) {
            vBox.getChildren().add(hBox);
        }

        scrollpane.setContent(vBox);
        scrollpane.setFitToWidth(true);
        scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
        // TODO
    } 
    
     private VBox createOffreBox(Reclamation offre)  {
        VBox box = new VBox();
        
        box.setAlignment(Pos.CENTER);
        box.setSpacing(30);
         box.setUserData(offre.getId()); // set the ID as the user data for the VBox


        Label titre = new Label("Objectif :  "+offre.getObjectif());
        
        
         Button bb = new Button();
         bb.setText("Supprimer");
         
          Button mod = new Button();
         mod.setText("Modifier");
        
     
       
        Label voir = new Label("Description      :"+offre.getText());
        Label sep = new Label("____________________________________________________________________________________________________________________");

     
        
      titre.setStyle("-fx-text-fill : Blue;");
      voir.setStyle("-fx-text-fill : Black;");
      sep.setStyle("-fx-text-fill : Red;");
        
         voir.setFont(Font.font("Serif", FontWeight.LIGHT, 23));
        titre.setFont(Font.font("Arial", FontWeight.BOLD, 29));
        
       
        box.getChildren().addAll( titre,voir,bb,mod,sep);
        
        bb.setOnMouseClicked(event -> {
            
            try {
                sr.supprimer(offre.getId());
                table();
            } catch (SQLException ex) {
                Logger.getLogger(AfficheRecController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        mod.setOnMouseClicked(event -> {
            
            try {
                Reclamation selectedR= offre;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierRec.fxml"));
                Parent view_2=loader.load();
                ModifierRecController mf = loader.getController();
                mf.getRec(selectedR);
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(view_2);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficheRecController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        /*bb.setOnMouseClicked(event -> {
            
            sp.supprimer(offre.getId());
            table();
            
        });
        
          box.setOnMouseClicked(event -> {
                
                idd = (offre.getId());
                Poste selected=sp.getOneById(offre.getId());
                tftitre.setText(selected.getTitre());
                tfdesc.setText(selected.getDesc());
                combodomaine.setItems(sd.getalls());
                File imagef = new File(selected.getImg());
                ImagePath=imagef.toURI().toString();
                Image image = new Image(imagef.toURI().toString());
                img.setImage(image);
         
                
                
              
        });
*/
        return box;
    }

    @FXML
    private void ajjout(MouseEvent event) {
    }

    @FXML
    private void afff(MouseEvent event) {
    }

    @FXML
    private void rech(ActionEvent event) {
        
        List<Reclamation> offres = sr.getMyRtrans(333,tfrech.getText());
        VBox vBox = new VBox();
        
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(30);
        

        HBox hBox = new HBox();
         
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);//
        

        int count = 0;
        for (Reclamation offre : offres) {
            VBox box = createOffreBox(offre);
            
            hBox.getChildren().add(box);
            count++;

            if (count == 1) {
                vBox.getChildren().add(hBox);
                hBox = new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(100);
                count = 0;
            }
        }

        if (count > 0) {
            vBox.getChildren().add(hBox);
        }

        scrollpane.setContent(vBox);
        scrollpane.setFitToWidth(true);
        scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }
    
}
