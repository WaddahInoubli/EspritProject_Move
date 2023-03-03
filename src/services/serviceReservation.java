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

            connection.setAutoCommit(false);

            try {

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
                String insertReservationSql = "INSERT INTO reservation (id_voiture_FK, id_client_FK, date_debut, date_fin,ifdriver) VALUES (?, ?, ?, ?,?)";
                PreparedStatement reservationStatement = connection.prepareStatement(insertReservationSql);
                reservationStatement.setInt(1, userReservation.getVoiture().getId());
                reservationStatement.setInt(2, clientId);
                reservationStatement.setDate(3, Date.valueOf(userReservation.getReservation().getDatedebut()));
                reservationStatement.setDate(4, Date.valueOf(userReservation.getReservation().getDatefin()));
                reservationStatement.setBoolean(5, userReservation.getReservation().getIfdriver());
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
    public void modifier(UserReservation userReservation) {
        try {
            connection.setAutoCommit(false);
            try {
                String updatevoiture="Update voiture SET marque=?, modele=?,Prix_jour=? where  id=?";
                PreparedStatement voiture = connection.prepareStatement(updatevoiture);
                voiture.setString(1, userReservation.getVoiture().getMarque());

                voiture.setString(2, userReservation.getVoiture().getModele());
                voiture.setDouble(3, userReservation.getVoiture().getPrix());
                voiture.setInt(4, userReservation.getVoiture().getId());
                voiture.executeUpdate();

                // Update the client record
                String updateClientSql = "UPDATE client SET nom=?, prenom=?, adresse=?, telephone=?, email=? WHERE id=?";
                PreparedStatement clientStatement = connection.prepareStatement(updateClientSql);
                clientStatement.setString(1, userReservation.getUser().getNom());
                System.out.println( userReservation.getUser().getNom());
                clientStatement.setString(2, userReservation.getUser().getPrenom());
                clientStatement.setString(3, userReservation.getUser().getAddress());
                clientStatement.setInt(4, userReservation.getUser().getPhone());
                clientStatement.setString(5, userReservation.getUser().getEmail());
                clientStatement.setInt(6, userReservation.getUser().getId());
                clientStatement.executeUpdate();

                // Update the reservation record
                String updateReservationSql = "UPDATE reservation SET date_debut=?, date_fin=?, id_voiture_FK=?, id_client_FK=?  ,ifdriver=? WHERE id=? ";
                PreparedStatement reservationStatement = connection.prepareStatement(updateReservationSql);
                reservationStatement.setDate(1, Date.valueOf( userReservation.getReservation().getDatedebut()));
                reservationStatement.setDate(2, Date.valueOf(userReservation.getReservation().getDatefin()));
                reservationStatement.setInt(3, userReservation.getVoiture().getId());
                reservationStatement.setInt(4, userReservation.getUser().getId());
                System.out.println(userReservation.getReservation().getIfdriver());
                reservationStatement.setBoolean(5, userReservation.getReservation().getIfdriver());
                reservationStatement.setInt(6, userReservation.getReservation().getId());
                reservationStatement.executeUpdate();

                // Commit the transaction


                System.out.println("Data updated successfully");

            } catch (SQLException ex) {

                connection.rollback();
                System.err.println("Error updating data: " + ex.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
   /* public void supprimer(Reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
 public void supprimer(int id) {
          try {
              System.out.println(id);
            String requete = "DELETE FROM reservation WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1,id);

            pst.executeUpdate();
            System.out.println("reservation supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }






    @Override
    public ArrayList<UserReservation> afficher() {
        ArrayList<UserReservation> listrec = new ArrayList<>();
        Reservation reservation=null;
        User user =null;
        Voiture voiture=null;
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM reservation";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){

            int id=res.getInt("id");
            int id_client=res.getInt("id_client_FK");

           LocalDate date_debut= res.getDate("date_debut").toLocalDate();
           LocalDate date_fin= res.getDate("date_fin").toLocalDate();
           int id_chauffeur_FK=res.getInt("id_chauffeur_FK");
           Boolean ifDriver=res.getBoolean("ifdriver");
            System.out.println(ifDriver);
           int id_voiture_FK=res.getInt("id_voiture_FK");
            String sql1= "select * from voiture where id=? " ;
            PreparedStatement selectuser1 = connection.prepareStatement(sql1);
            selectuser1.setInt(1, id_voiture_FK);
            ResultSet resultat1=   selectuser1.executeQuery();
            if(resultat1.next()){
                Double prix=resultat1.getDouble("Prix_jour");
                voiture =new Voiture(prix);
            }
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

   reservation =new Reservation(id,date_debut,date_fin,ifDriver);
   UserReservation user1=new UserReservation(user,reservation,voiture);
   listrec.add(user1);


        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }

        return listrec;
    }

    @Override
    public ArrayList<UserReservation> afficheronereservation( int id1) {
        ArrayList<UserReservation> listrec = new ArrayList<>();
       Voiture voiture=null;
        Reservation reservation=null;
        User user =null;
        try{
            System.out.println( "mon id"+id1);
            ste= connection.createStatement();
            String sqlrequete= "select * from reservation where id=? " ;
            PreparedStatement selectoneuser = connection.prepareStatement(sqlrequete);
            selectoneuser.setInt(1, id1);
            ResultSet res=   selectoneuser.executeQuery();
            while(res.next()){

                int id=res.getInt("id");
                int id_client=res.getInt("id_client_FK");


                LocalDate date_debut= res.getDate("date_debut").toLocalDate();
                System.out.println( "date_debut"+ date_debut);
                LocalDate date_fin= res.getDate("date_fin").toLocalDate();
                int id_chauffeur_FK=res.getInt("id_chauffeur_FK");
                Boolean ifDriver=res.getBoolean("ifDriver");
                int id_voiture_FK=res.getInt("id_voiture_FK");

                String sqlVoiture="select * from voiture where id=?";
                PreparedStatement selecteur=connection.prepareStatement(sqlVoiture);
                selecteur.setInt(1,id_voiture_FK);
                ResultSet resultatVoiture=   selecteur.executeQuery();
                if(resultatVoiture.next()){
                     int idvoiture=resultatVoiture.getInt("id");
                    String modele=resultatVoiture.getString("modele");
                    String marque=resultatVoiture.getString("marque");
                    Double prix_jour=resultatVoiture.getDouble("prix_jour");
                    voiture =new Voiture(id,modele,marque,prix_jour);


                }






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

                reservation =new Reservation(id, date_debut, date_fin,ifDriver);
                UserReservation user1=new UserReservation(user,reservation,voiture);
                listrec.add(user1);


            }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }

        return listrec;
    }



}

 