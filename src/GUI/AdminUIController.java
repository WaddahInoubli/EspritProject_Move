/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Reclamation;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.serviceReclamation;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AdminUIController implements Initializable {

    @FXML
    private TableView<Reclamation> tab;
    @FXML
    private TableColumn<Reclamation, Integer> id_r;
    @FXML
    private TableColumn<Reclamation, String> obj_r;
    @FXML
    private TableColumn<Reclamation, String> txt_r;
    @FXML
    private TableColumn<Reclamation, Integer> user_r;
    @FXML
    private TableColumn<Reclamation, Integer> etat_r;
    serviceReclamation sr = new serviceReclamation();

    /**
     * Initializes the controller class.
     */
    
    public void table(){
    id_r.setCellValueFactory(new PropertyValueFactory<>("id"));
    obj_r.setCellValueFactory(new PropertyValueFactory<>("objectif"));
    txt_r.setCellValueFactory(new PropertyValueFactory<>("text"));
    user_r.setCellValueFactory(new PropertyValueFactory<>("iduser"));
    etat_r.setCellValueFactory(new PropertyValueFactory<>("etat"));
    
    tab.setItems(RecupBase());
    
    
    
    }
    public static ObservableList<Reclamation> RecupBase(){
    ObservableList<Reclamation> list = FXCollections.observableArrayList();
    
       java.sql.Connection cnx;
     cnx = MyDB.getInstance().getCon();
          String sql = "select *from reclamation WHERE etat=0";
    try {
       
        PreparedStatement st = (PreparedStatement) cnx.prepareStatement(sql);

    ResultSet R = st.executeQuery();
    while (R.next()){
        
        
        
      Reclamation r =new Reclamation();
      r.setId(R.getInt(1));
     r.setobjectif((R.getString("objectif")));
     r.settext(R.getString("text"));
     r.setEtat((R.getInt(5)));
     r.setiduser(R.getInt(4));
     
      
    
     
      list.add(r);
    }}
    catch(SQLException ex){
    ex.getMessage();
    }
    return list;}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table();
    }    
    
}
