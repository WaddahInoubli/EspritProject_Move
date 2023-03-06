/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utils.MoveDB;

/**
 * FXML Controller class
 *
 * @author chedli
 */
public class AddOffreController implements Initializable {

    @FXML
    private Button btn_add;

    @FXML
    private Label label;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtcomment;

    @FXML
    private TextArea txtposte;

    PreparedStatement preparedStatement;
    Connection connection;
    Statement ste;
    private boolean update;
    int offreId;
    String query = null;

    /**
     * Initializes the controller class.
     */
    @FXML
    void Add(ActionEvent event) {

        connection = MoveDB.getInstance().getCon();

        String name = txtName.getText();
        String comment = txtcomment.getText();
        String poste = txtposte.getText();

        if (name.isEmpty() || poste.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
            getQuery();
            insert();
            clean();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Succéss", ButtonType.OK);
            a.showAndWait();
        }
    }

    private void getQuery() {

        if (update == false) {

            query = "INSERT INTO `esprit3a11`.`offre`(Name_User,content,Comment,date) VALUES (?,?,0,NOW())";

        } else {
            query = "UPDATE `esprit3a11`.`offre` SET "
                    + "`Name_User`=?,"
                    + "`content`=?,"
                    + "`date`=NOW() WHERE Id_Offre = '" + offreId + "'";
        }

    }

    private void clean() {
        txtName.clear();
        txtcomment.clear();
        txtposte.clear();
    }

    private void insert() {

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, txtName.getText());
            preparedStatement.setString(2, txtposte.getText());
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AddOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void setUpdate(boolean b) {
        this.update = b;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    void setTextField(int Id_Offre, String Name_User, String content, String Comment) {
        offreId = Id_Offre;
        txtName.setText(Name_User);
        txtposte.setText(content);
        txtcomment.setText(Comment);

    }

}