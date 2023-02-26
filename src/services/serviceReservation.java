/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.*;
import interfaces.IserviceReservation;
import utils.MyDB;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class serviceReservation implements IserviceReservation<UserReservation> {
    Connection connection;
    Statement ste;

    public serviceReservation() {
        
        connection = MyDB.getInstance().getCon();
    }
    
    
    

   @Override
    public void ajouter(UserReservation userReservation ) {
        try {

            // Connect to the MySQL database


// Create a new transaction
            connection.setAutoCommit(false);

            try {
                // Insert data into the voiture table
                String insertVoitureSql = "INSERT INTO voiture (marque, modele, annee,Prix_jour) VALUES (?, ?, ?,?)";
                PreparedStatement voitureStatement = connection.prepareStatement(insertVoitureSql, Statement.RETURN_GENERATED_KEYS);
                voitureStatement.setString(1, "Toyota");
                voitureStatement.setString(2, "Corolla");
                voitureStatement.setInt(3, 2021);
                voitureStatement.setInt(4, 170);
                voitureStatement.executeUpdate();

                // Get the ID of the inserted voiture record
                ResultSet voitureResultSet = voitureStatement.getGeneratedKeys();
                int voitureId = -1;
                if (voitureResultSet.next()) {
                    voitureId = voitureResultSet.getInt(1);
                }

                // Insert data into the client table
                String insertClientSql = "INSERT INTO client (nom, prenom, adresse,telephone,email) VALUES (? ,? ,? ,? ,?)";
                PreparedStatement clientStatement = connection.prepareStatement(insertClientSql, Statement.RETURN_GENERATED_KEYS);
                clientStatement.setString(1, userReservation.getUser().getNom());
                clientStatement.setString(2,userReservation.getUser().getPrenom());
                clientStatement.setString(3,userReservation.getUser().getAddress());
                clientStatement.setInt(4,userReservation.getUser().getPhone());
                clientStatement.setString(5,userReservation.getUser().getEmail());

                clientStatement.executeUpdate();

                // Get the ID of the inserted client record
                ResultSet clientResultSet = clientStatement.getGeneratedKeys();
                int clientId = -1;
                if (clientResultSet.next()) {
                    clientId = clientResultSet.getInt(1);
                }

                // Insert data into the reservation table
                String insertReservationSql = "INSERT INTO reservation (id_voiture_FK, id_client_FK, date_debut, date_fin) VALUES (?, ?, ?, ?)";
                PreparedStatement reservationStatement = connection.prepareStatement(insertReservationSql);
                reservationStatement.setInt(1, voitureId);
                reservationStatement.setInt(2, clientId);
                reservationStatement.setDate(3, Date.valueOf(userReservation.getReservation().getDatedebut()));
                reservationStatement.setDate(4, Date.valueOf(userReservation.getReservation().getDatefin()));
                reservationStatement.executeUpdate();

                // Commit the transaction
                connection.commit();

                System.out.println("Data inserted successfully");
            } catch (SQLException ex) {
                // Rollback the transaction if any errors occur
                connection.rollback();
                System.err.println("Error inserting data: " + ex.getMessage());
            }
            
            
            

        
        
       
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }




    @Override
   /* public void supprimer(Reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
 public void supprimer(UserReservation t) {
          try {
            String requete = "DELETE FROM reclamation WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(requete);

            pst.executeUpdate();
            System.out.println("Reclamation supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }      
    }
 
   
    



    @Override
    public ArrayList<UserReservation> afficher() {
        ArrayList<UserReservation> listrec = new ArrayList<>();
        Reservation reservation=null;
        User user =null;
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM reservation";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){

            int id=res.getInt("id");
            int id_client=res.getInt("id_client_FK");

           Date date_debut=res.getDate("date_debut");
           Date date_fin=res.getDate("date_fin");
           int id_chauffeur_FK=res.getInt("id_chauffeur_FK");
           int ifDriver=res.getInt("ifDriver");
           int id_voiture_FK=res.getInt("id_voiture_FK");
            String sql= "select * from client where id=? " ;
            PreparedStatement selectuser = connection.prepareStatement(sql);
            selectuser.setInt(1, id_client);
         ResultSet resultat=   selectuser.executeQuery();
            if(resultat.next()){
                String nom=resultat.getString("nom");
                String prenom=resultat.getString("prenom");
                String adress=resultat.getString("adresse");
                String email=resultat.getString("email");
                int telephone=resultat.getInt("telephone");
                System.out.println(nom+" "+prenom );
                user =new User( nom, prenom,  adress,  telephone, email);

            }

   reservation =new Reservation(date_debut.toLocalDate(), date_fin.toLocalDate());
   UserReservation user1=new UserReservation(user,reservation);
   listrec.add(user1);


        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }

        return listrec;
    }

 

    @Override
    public void modifier(UserReservation t) {

}
}

 