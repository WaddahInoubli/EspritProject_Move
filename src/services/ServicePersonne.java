package services;

import entities.Personne;
import entities.reservation;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;

public class ServicePersonne implements IService<Personne> {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public ServicePersonne() {
        connection = MyDB.getInstance().getCon();
    }

    @Override
    public void ajouter(Personne personne) {

    }

    @Override
    public void supprimer(Personne personne) {

    }

    @Override
    public void modifier(Personne personne) {

    }

@Override
    public ArrayList<Personne> afficher() {
        ArrayList<Personne> personnes = new ArrayList<>();
        try {
            String sql="SELECT * FROM user ";
            preparedStatement = connection.prepareStatement(sql);


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String addresse = resultSet.getString("addresse");
                String e_mail = resultSet.getString("e_mail");
                String phone =resultSet.getString("num_tel");
                Personne personne = new Personne(id, nom, prenom, phone,addresse,e_mail);
                personnes.add(personne);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personnes;
    }}



