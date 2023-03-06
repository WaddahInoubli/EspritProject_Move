/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utils.MoveDB;

/**
 * FXML Controller class
 *
 * @author chedli
 */
public class AddcomentaireController implements Initializable {
 @FXML
    private Button btn_add;


    @FXML
    private TextArea txtcom;

    @FXML
    private TextField txtname;
    
    PreparedStatement preparedStatement;
    Connection connection;
    Statement ste;
    private boolean update;
    int IdComment;
    int Idpublication;
    String query = null;

    @FXML
    void addcome(ActionEvent event) {
        
    connection = MoveDB.getInstance().getCon();
    
    String name = txtname.getText();
    String content = txtcom.getText();
    
    
     if (name.isEmpty()  || content.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } 
     else {
            getQuery();
            insert();
            clean();
             Alert a = new Alert(Alert.AlertType.INFORMATION, "Succéss", ButtonType.OK);
             a.showAndWait();  


          }
   }
    
    
    private void getQuery() {

        if (update == false) {
            
            query = "INSERT INTO `esprit3a11`.`comments`(Id_publication,contenent, Nam_User, date_com) VALUES (?,?,?,NOW())";

        }else{
            query = "UPDATE `esprit3a11`.`comments` SET "
                    + "`Id_publication`=?,"
                    + "`contenent`=?,"
                    + "`Nam_User`=?,"
                    + "`date_com`= NOW() WHERE Id_Comment = '"+IdComment+"'";
        }

    }

      private void clean() {
         txtname.clear();
         
         txtcom.clear();
    }
      private void insert() {

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Idpublication);
            preparedStatement.setString(2, txtcom.getText());
//            preparedStatement.setString(4, String.valueOf(dateFid.getValue()));
            preparedStatement.setString(3, txtname.getText());
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AddOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    void setUpdate(boolean b) {
        this.update = b;

    }
  

    void setTextField(int Id_Comment, int Id_publication, String contenent, String Name_User) {
        IdComment = Id_Comment;
        Idpublication = Id_publication;
        txtcom.setText(contenent);
        txtname.setText(Name_User);
        
        

    
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void settTextField(int Idpub) {
        Idpublication = Idpub;
    }
    
}
