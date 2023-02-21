/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import entities.offre;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import utils.MoveDB;

/**
 * FXML Controller class
 *
 * @author chedli
 */
public class PublicationController implements Initializable {
     @FXML
    private Label commentt;
        
        @FXML
    private VBox vbox;

    @FXML
    private Label id;

    @FXML
    private Label label;

    @FXML
    private Label nom;

    @FXML
    private Label postee;
    /**
     * Initializes the controller class.
     */
Connection connection;
 ResultSet resultSet = null ;
    PreparedStatement preparedStatement = null ;
    String query = null;
    offre ofre=null;
    Statement ste;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
    
}
