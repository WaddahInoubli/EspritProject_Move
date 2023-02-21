/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.offre;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import services.ServiceOffre;
import utils.MoveDB;

/**
 *
 * @author chedli
 */
public class FXMLDocumentController implements Initializable {
    
    
  @FXML
    private Button btn_upd;

    @FXML
    private Button btnadd;

    @FXML
    private Button btndelcom;
    
    @FXML
     private Button btn_delete;

     @FXML
    private Button btn_afficher;
     
      @FXML
    private Button getAddView;
      @FXML
    private ScrollPane scroll;
 
    @FXML
    private TableColumn<offre, String> colcomment;

    @FXML
    private TableColumn<offre, String> colnom;

    @FXML
    private TableColumn<offre, String> colposte;
    
     @FXML
    private TableColumn<offre, String> colid;
     
      @FXML
    private TableColumn<offre, String> editCol;

        @FXML
    private Label commentt;
        
        @FXML
    private VBox vbox;
            @FXML
    private VBox vbox1;

    @FXML
    private Label id;

    @FXML
    private Label label;

    @FXML
    private Label nom;

    @FXML
    private Label postee;
    
     @FXML
    private Label namee;
    
      @FXML
    private Label contenentt;
      
       @FXML
    private Label datee;

    @FXML
    private TableView<offre> TableView;

 

   @FXML
    private TextArea txtposte;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtcomment;
    
    ResultSet resultSet = null ;
    PreparedStatement preparedStatement = null ;
    String query = null;
    offre ofre=null;
    Connection connection;
    Statement ste;
   
    ObservableList<offre>  OffreList = FXCollections.observableArrayList();
   
   
     @FXML
    void Delete(ActionEvent event) {
        int Id_Offre =Integer.parseInt(txtName.getText());
       ServiceOffre s= new ServiceOffre();
       s.supprimer(Id_Offre);
    }
    @FXML
   void getAddView(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/javafxapplication3/AddOffre.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void refreshTable() {
        try {
            OffreList.clear();
            
            query = "SELECT * FROM `move`.`offre`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                OffreList.add(new  offre(
                        resultSet.getInt("Id_Offre"),
                        resultSet.getString("Name_User"),
                        resultSet.getString("Poste"),
                        resultSet.getString("comment")));
                TableView.setItems(OffreList);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }


     @FXML
  private  void afficher() {
 
        connection = MoveDB.getInstance().getCon();
         refreshTable();
         colid.setCellValueFactory(new PropertyValueFactory<>("Id_Offre"));
         colposte.setCellValueFactory(new PropertyValueFactory<>("Poste"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("Name_User"));
        colcomment.setCellValueFactory(new PropertyValueFactory<>("Comment"));
       
Callback<TableColumn<offre, String>, TableCell<offre, String>> cellFoctory = (TableColumn<offre, String> param) -> {
            // make cell containing buttons
            final TableCell<offre, String> cell = new TableCell<offre, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                   {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
                        FontAwesomeIconView viewIcon = new FontAwesomeIconView(FontAwesomeIcon.ALIGN_CENTER);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                         viewIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff5744;"
                        );
                        deleteIcon.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
                            
                            try {
                                ofre = TableView.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM `move`.`offre` WHERE Id_Offre  ="+ofre.getId_Offre();
                                connection = MoveDB.getInstance().getCon();
                                preparedStatement = connection.prepareStatement(query);
                                preparedStatement.execute();
                                refreshTable();
//                              
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                           

                          

                        });
                        editIcon.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
                            
                            ofre = TableView.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/javafxapplication3/AddOffre.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            AddOffreController addOffreController = loader.getController();
                            addOffreController.setUpdate(true);
                            addOffreController.setTextField(ofre.getId_Offre(), ofre.getName_User(), 
                                    ofre.getPoste(),ofre.getComment());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            

                           

                        });

                        viewIcon.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
                            
                            ofre = TableView.getSelectionModel().getSelectedItem();
                           

                                  
                         try {
                             
                             vbox.getChildren().clear();
                             Statement statement = connection.createStatement();
                             ResultSet rs = statement.executeQuery("SELECT * FROM `move`.`offre`WHERE Id_Offre  ="+ofre.getId_Offre());
     
                            while (rs.next()) {
          
    
    
//        String Id = rs.getString(1);
         String name = rs.getString(2);
        String poste = rs.getString(3);
        String comment = rs.getString(4);
//    Label idValueLabel = new Label("ID: \n" + Id);
    Label nomValueLabel = new Label("nom: \n" + name);
    Label posteeValueLabel = new Label("poste: \n"+ poste);
     Label commenttValueLabel = new Label("commentaire: \n "+"                "+ comment);
    vbox.getChildren().add(nomValueLabel);
    vbox.getChildren().add(posteeValueLabel);
    vbox.getChildren().add(commenttValueLabel);
    
    
//        id.setText(Id);
//        nom.setText(name);
//        commentt.setText(comment);
//        postee.setText(poste);
//         vbox.getChildren().add(id);
//         vbox.getChildren().add(nom);
//         vbox.getChildren().add(commentt);
//         vbox.getChildren().add(postee);
         affichercom();
        
    }
} catch (SQLException e) {
    e.printStackTrace();
}
                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon,viewIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
                         HBox.setMargin(viewIcon, new Insets(2, 4, 0, 1));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
         editCol.setCellFactory(cellFoctory);
         TableView.setItems(OffreList);
         
        
        
    }
  
  
    @FXML
    void addcom(ActionEvent event) {
 try {
            Parent parent = FXMLLoader.load(getClass().getResource("/javafxapplication3/Addcomentaire.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void deletecom(ActionEvent event) {

    }
  
    
     @FXML
    void updatecom(ActionEvent event) {

    }
  void affichercom(){
                              FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);

   try {
                             
                             vbox1.getChildren().clear();
                             Statement statement = connection.createStatement();
                             ResultSet rs = statement.executeQuery("SELECT * FROM `move`.`comments`WHERE Id_publication  ="+ofre.getId_Offre());
     
                            while (rs.next()) {
          
    
    
//        String Id = rs.getString(1);
        String nameee = rs.getString(4);
        String contenent = rs.getString(3);
        String date = rs.getString(5);
//    Label idValueLabel = new Label("ID: \n" + Id);
    Label nameValueLabel = new Label("nom: \n" + nameee);
    Label contenentValueLabel = new Label("contenent: \n"+ contenent);
     Label dateValueLabel = new Label("date: \n "+"                "+ date);
     Button button = new Button("Modifier");
      Button btton = new Button("supprimer");
      HBox hbox = new HBox(button, btton);
      hbox.setSpacing(10);
    vbox1.getChildren().addAll(nameValueLabel);
    vbox1.getChildren().addAll(contenentValueLabel);
    vbox1.getChildren().addAll(dateValueLabel);
    vbox1.getChildren().addAll(hbox);
                
//        id.setText(Id);
//        namee.setText(nameee);
//        contenentt.setText(contenent);
//        datee.setText(date);
//         vbox.getChildren().add(id);
//         vbox.getChildren().add(nom);
//         vbox.getChildren().add(commentt);
//         vbox.getChildren().add(postee);
         
        
    }
                            ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(vbox1);
               

                // Create a new Stage and display the ScrollPane in a Scene
                Stage stage = new Stage();
                stage.setScene(new Scene(scrollPane, 400, 400));
                stage.show();
                          
} catch (SQLException e) {
    e.printStackTrace();
}
                        
  
  }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      afficher();
    }    
    
}
