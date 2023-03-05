/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utils.MyDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Z4RGA
 */
public class ChartController implements Initializable {

    @FXML
    private PieChart piechart;

    //********* Connexion au BD  ******************//
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement st = null;
    Statement stmt = null;

    //****** ***  ******************//
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = MyDB.getInstance().getCon();
        stat();
    }

    private void stat() {

        try {

            String query = "SELECT COUNT(*) ,message.message\n"
                    + "             	from discussion join message\n"
                    + "                on discussion.id_disc=message.id_disc\n"
                    + "                GROUP BY message.message;";

            PreparedStatement PreparedStatement = con.prepareStatement(query);
            rs = PreparedStatement.executeQuery();

            while (rs.next()) {
                data.add(new PieChart.Data(rs.getString("message.message"), rs.getInt("COUNT(*)")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        }

      //  piechart.setTitle("**Statistiques nombres des catégories**");
        piechart.setLegendSide(Side.LEFT);
        piechart.setData(data);

    }

}
