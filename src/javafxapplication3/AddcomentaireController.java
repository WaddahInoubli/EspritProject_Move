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
    private DatePicker dateFid;

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
    String date = String.valueOf(dateFid.getValue());
    String content = txtcom.getText();
     if (name.isEmpty() || date.isEmpty() || content.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } 
     else {
         getQuery();
            insert();
            clean();


    }
   }
    private void getQuery() {

        if (update == false) {
            
            query = "INSERT INTO `move`.`comments`(Id_publication,contenent, Nam_User, date_com) VALUES (?,?,?,?)";

        }else{
            query = "UPDATE `move`.`comments` SET "
                    + "`contenent`=?,"
                    + "`Nam_User`=?,"
                    + "`date_com`= ? WHERE Id_Comment = '"+IdComment+"'";
        }

    }

      private void clean() {
         txtname.clear();
         dateFid.setValue(null);
         txtcom.clear();
    }
      private void insert() {

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "13");
            preparedStatement.setString(2, txtcom.getText());
            preparedStatement.setString(4, String.valueOf(dateFid.getValue()));
            preparedStatement.setString(3, txtname.getText());
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AddOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    void setUpdate(boolean b) {
        this.update = b;

    }
  

    void setTextField(int Id_Comment, int Id_publication, String contenent, String Name_User, LocalDate date_com) {
        IdComment = Id_Comment;
        
        txtcom.setText(contenent);
        txtname.setText(Name_User);
        dateFid.setValue(date_com);
        

    
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
