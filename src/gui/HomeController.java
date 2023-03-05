/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Message;
import java.io.BufferedWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import services.ServiceMessages;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import utils.MyDB;
import javafx.beans.value.ChangeListener;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author Z4RGA
 */
public class HomeController implements Initializable {

    @FXML
    private TableColumn<Message, Integer> fxid_mesg;
    @FXML
    private TableColumn<Message, Integer> fxid_disc;
    @FXML
    private TableColumn<Message, Integer> fxid_sender;
    @FXML
    private TableColumn<Message, String> fxmessage;
    @FXML
    private TableView<Message> table;
    @FXML
    private TextField filterField;

        	private ObservableList<Message> masterData  = FXCollections.observableArrayList();

                
                
    	private ObservableList<Message> filteredData = FXCollections.observableArrayList();

    
    Message message;
                	
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement st=null;
    @FXML
    private Button fxsave;
    @FXML
    private Button fxstat;
                
                
          
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affiche();
     

        
  

    
    
                ObservableList<Message> dataList = getMessage();

        
           /* Search Bar */
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Message> filteredData = new FilteredList<>(dataList, b -> true);
// 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(message -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(message.getId_mesg()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (String.valueOf(message.getId_disc()).contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(message.getId_sender()).contains(lowerCaseFilter)) {
                    return true;
                       } else if (message.getMessage().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else {
                    return false; // Does not match.
                }
            });
        });

// 3. Wrap the FilteredList in a SortedList. 
        SortedList<Message> sortedData = new SortedList<>(filteredData);
        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        table.setItems(sortedData);
        
        
        
    
    }    
  
    public ObservableList<Message> getMessage(){
         ObservableList<Message> list = FXCollections.observableArrayList();
		
				con = MyDB.getInstance().getCon()  ;
                                        
                                     
	String select="select m.id_mesg,m.id_disc,m.id_sender,m.message from message m ;";
			
				 try {
            st = con.prepareStatement(select);
            rs = st.executeQuery();
            while (rs.next()) {
                Message m = new Message();
                m.setId_mesg(rs.getInt("id_mesg"));
                m.setId_disc(rs.getInt("id_disc"));
                m.setId_sender(rs.getInt("id_sender"));
               m.setMessage(rs.getString("message"));
    
                list.add(m);
            }}
         catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                                 return list;}

       public void affiche() {
        ObservableList<Message> list = getMessage();
        fxid_mesg.setCellValueFactory(new PropertyValueFactory<Message, Integer>("id_mesg"));
           fxid_disc.setCellValueFactory(new PropertyValueFactory<Message, Integer>("id_disc"));
        fxid_sender.setCellValueFactory(new PropertyValueFactory<Message, Integer>("id_sender"));
        fxmessage.setCellValueFactory(new PropertyValueFactory<Message, String>("message"));

        
        table.setItems(list);
 
    }
             
  
       
    @FXML
    private void savetoexcel(ActionEvent event) {
        
        
        try {
            writeExcel();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
       // SAVE TO EXCEL 
       
           public void writeExcel() throws IOException {
        Writer writer = null;

        ObservableList<Message> data = getMessage();

        fxid_mesg.setCellValueFactory(new PropertyValueFactory<Message, Integer>("id_mesg"));
           fxid_disc.setCellValueFactory(new PropertyValueFactory<Message, Integer>("id_disc"));
        fxid_sender.setCellValueFactory(new PropertyValueFactory<Message, Integer>("id_sender"));
        fxmessage.setCellValueFactory(new PropertyValueFactory<Message, String>("message"));

        try {
            File file = new File("C:\\Users\\Z4RGA\\Desktop\\gestion_messagerieHA(updatedV2)\\gestion_messagerieHA(updated)\\gestion_messagerieHA\\Excelfiles\\MessageList.csv.");
            writer = new BufferedWriter(new FileWriter(file));

            for ( Message message: data) {

                String text = message.getId_mesg()+ "," + message.getId_disc()+ "," + message.getId_sender()+ "," + message.getMessage()+ "\n";

                writer.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            writer.flush();
            writer.close();
        }
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Excel");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("'Excel File Created ..");

            alert.showAndWait();
    }

    @FXML
    private void chart_switch(ActionEvent event) {
        
        
        try {
//         
            Parent parent = FXMLLoader.load(getClass().getResource("Chart.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //stage.getIcons().add(new Image("wood.jpg"));
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

}

    
       
       

      
      