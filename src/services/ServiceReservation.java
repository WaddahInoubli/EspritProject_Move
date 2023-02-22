package services;

import entities.Personne;
import entities.reservation;
import gui.AffichageFXMLController;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;

public class ServiceReservation implements IService<reservation> {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public ServiceReservation() {
        connection = MyDB.getInstance().getCon();
    }

    @Override
    public void ajouter(reservation personne) {


        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO reservation (id_client_FK , id_voiture_FK, DateDebutReservation, DateFinReservation,id_driver_FK,ifDriver,prix) VALUES (?, ?, ?, ?,?,?,?)");
            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, 2);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    @Override
    public void supprimer(reservation personne) {

    }

    @Override
    public void modifier(reservation personne) {

    }

    @Override
    public ArrayList<Personne> afficher() {
        return null;
    }


}
    // This method is not used, so it can be removed

