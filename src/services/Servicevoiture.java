package services;

import entities.Reservation;
import entities.Voiture;
import interfaces.IserviceVoiture;
import utils.MyDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Servicevoiture  implements IserviceVoiture<Voiture> {
    Connection connection =null;
    Statement ste=null;
    public Servicevoiture(){
  connection= MyDB.getInstance().getCon();
    }
    @Override
    public ArrayList<Voiture> afficher() {
        ArrayList<Voiture> listeVoiture = new ArrayList<>();
        try{
            ste= connection.createStatement();
            String req_select="SELECT * FROM `esprit3a11`.`voiture`";
            ResultSet res = ste.executeQuery(req_select);
            while(res.next()){
                int id=res.getInt("id");
                String modele = res.getString("modele");
                String marque = res.getString("marque");
                Double prix= res.getDouble("Prix_jour");

Voiture voiture=new Voiture(id,modele,marque,prix);
listeVoiture.add(voiture);
            }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }

        return listeVoiture;
    }
}
