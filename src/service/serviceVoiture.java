/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.voiture;
import entities.modele;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import utils.MyDB;

/**
 *
 * @author tekay
 */
public class serviceVoiture implements iservice<voiture> {
    Connection connection;
    Statement ste;

    public serviceVoiture() {
        
        connection = MyDB.getInstance().getCon();
    
}

    /**
     *
     * @param v
     * @throws SQLException
     */
    @Override
    public void ajouter(voiture v) throws SQLException {
    try {
        // Vérifier si le numéro de matricule est unique
        String req_select = "SELECT COUNT(*) FROM `move`.`voiture` WHERE matricule = ?";
        PreparedStatement pst_select = connection.prepareStatement(req_select);
        pst_select.setInt(1, v.getMatricule());
        ResultSet res = pst_select.executeQuery();
        res.next();
        int count = res.getInt(1);
        if (count > 0) {
            System.out.println("Erreur : Une voiture avec le même numéro de matricule existe déjà.");
            return;
        }
        
        // Insérer la nouvelle voiture
        String req_insert = "INSERT INTO `move`.`voiture` (matricule, etat, annes, prix_h, id_m, marque, modele, couleur) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst_insert = connection.prepareStatement(req_insert);
        pst_insert.setInt(1, v.getMatricule());
        pst_insert.setString(2, v.getEtat());
        pst_insert.setInt(3, v.getAnnes());
        pst_insert.setInt(4, v.getPrix_h());
        pst_insert.setInt(5, v.getId_m());
        pst_insert.setString(6, v.getMarque());
        pst_insert.setString(7, v.getModele());
        pst_insert.setString(8, v.getCouleur());
        pst_insert.executeUpdate();
        System.out.println("Voiture ajoutée avec succès !");
    } catch(SQLException ex) {
        System.out.println("SQLException " + ex.getMessage());
    }
}

    /**
     *
     * @param matricule
     * @throws SQLException
     */
    public void supprimer(int matricule)throws SQLException {
    try {
        // Vérifier si la voiture existe avant de la supprimer
        String req_select = "SELECT COUNT(*) FROM `move`.`voiture` WHERE matricule = ?";
        PreparedStatement pst_select = connection.prepareStatement(req_select);
        pst_select.setInt(1, matricule);
        ResultSet res = pst_select.executeQuery();
        res.next();
        int count = res.getInt(1);
        if (count == 0) {
            System.out.println("Erreur : Aucune voiture avec ce numéro de matricule n'a été trouvée.");
            return;
        }
        
        // Supprimer la voiture
        String req_delete = "DELETE FROM `move`.`voiture` WHERE matricule = ?";
        PreparedStatement pst_delete = connection.prepareStatement(req_delete);
        pst_delete.setInt(1, matricule);
        pst_delete.executeUpdate();
        System.out.println("Voiture supprimée avec succès !");
    } catch(SQLException ex) {
        System.out.println("SQLException " + ex.getMessage());
    }
}


    @Override
    public void modifier(voiture v)throws SQLException {
    try {
        // Vérifier si la voiture existe avant de la modifier
        String req_select = "SELECT COUNT(*) FROM `move`.`voiture` WHERE matricule = ?";
        PreparedStatement pst_select = connection.prepareStatement(req_select);
        pst_select.setInt(1, v.getMatricule());
        ResultSet res = pst_select.executeQuery();
        res.next();
        int count = res.getInt(1);
        if (count == 0) {
            System.out.println("Erreur : Aucune voiture avec ce numéro de matricule n'a été trouvée.");
            return;
        }
        
        // Modifier la voiture
        String req_update = "UPDATE `move`.`voiture` SET etat = ?, annees = ?, prix_h = ?, id_m = ? WHERE matricule = ?";
        PreparedStatement pst_update = connection.prepareStatement(req_update);
        pst_update.setString(1, v.getEtat());
        pst_update.setInt(2, v.getAnnes());
        pst_update.setInt(3, v.getPrix_h());
        pst_update.setInt(4, v.getId_m());
        pst_update.setInt(5, v.getMatricule());
        pst_update.executeUpdate();
        System.out.println("Voiture modifiée avec succès !");
    } catch(SQLException ex) {
        System.out.println("SQLException " + ex.getMessage());
    }
}


    /**
     *
     * @return
     */
    @Override
 public ArrayList<voiture> afficher() {
    ArrayList<voiture> listpers = new ArrayList<>();
    try {
        ste = connection.createStatement();
        String req_select = "SELECT v.matricule, v.etat, v.annes, v.prix_h, v.id_m, m.marque, m.modele, m.couleur " +
                            "FROM `move`.`voiture` v INNER JOIN `modele` m ON v.id_m = m.id_m";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()) {
            int matricule = res.getInt("matricule");
            String etat = res.getString("etat");
            int annes = res.getInt("annes");
            int prix_h = res.getInt("prix_h");
            int id_m = res.getInt("id_m");
            String marque = res.getString("marque");
            String modele = res.getString("modele");
            String couleur = res.getString("couleur");
            voiture pr = new voiture(matricule, etat, annes, prix_h, id_m, marque, modele, couleur);
            listpers.add(pr);
        }
    } catch(SQLException ex) {
        System.out.println("SQLException " + ex.getMessage());
    }
    return listpers;
}

    @Override
    public void supprimer(voiture t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ObservableList<voiture> getall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

     
 }