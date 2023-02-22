/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.MyDB;

/**
 *
 * @author Andrew
 */
public class ServicePersonne  implements IService<Personne>{
        Connection connection;
        private PreparedStatement pste;
    Statement ste;

    public ServicePersonne() {
        
        connection = MyDB.getInstance().getCon();
    }
    
    
    

    @Override
    public void ajouter(Personne t) {
        try {
            
            ste = connection.createStatement();
            String req ="INSERT INTO `move`.`personne` (`cin`,`nom`,`prenom`,`age`,`email`) VALUES ('"+t.getCin()+"','"+t.getNom()+"','"+t.getPrenom()+"',"+t.getAge()+",'"+t.getEmail()+"');";
            ste.executeUpdate(req);
            
            
            
        } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        
        
       
    }

    @Override
    public void supprimer(int id) {

            String delete = "DELETE FROM `move`.`personne` where idp=?";
        try {
            pste = connection.prepareStatement(delete);
            pste.setInt(1,id);
            pste.executeUpdate();
       
        } catch (SQLException ex) {
                  
                     System.out.println("Exception: "+ex.getMessage());
        
       
        }
    }

    @Override
    public void modifier(Personne t) {
         try {
            String req= "UPDATE `move`.`personne` SET cin='" +t.getCin() + "'  ,nom='" + t.getNom()+"', prenom='" +t.getPrenom()+ "' ,age='" +t.getAge() + "' ,email='" +t.getEmail() + "' WHERE idp="+t.getId()+";";
           Statement  st = connection.createStatement();
            st.executeUpdate(req);
           System.out.println("personne modifié avec succes");
        }  catch (SQLException ex) {
                     System.out.println("Exception: "+ex.getMessage());
        }
        
         
         
        
    }

    

    @Override
    public void ajouter2(Personne t) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO `move`.`Personne` (`cin`,`nom`,`prenom`,`age`,`email`) VALUES (?,?,?,?,?)");
        pre.setInt(1, t.getCin());
        pre.setString(2, t.getNom());
        pre.setString(3, t.getPrenom());
        pre.setInt(4, t.getAge());
        pre.setString(5,t.getEmail());

        
        pre.executeUpdate();
        
    }

    @Override
    public ArrayList<Personne> afficher() {
        ArrayList<Personne> listpers = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM `move`.`Personne`";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id = res.getInt(1);
            int cin = res.getInt(2);
            String nom = res.getString("nom");
            String prenom = res.getString(4);
            int age = res.getInt(5);
            String email = res.getString("email");

            Personne pr = new Personne(id,cin,nom,prenom,age,email);
            listpers.add(pr);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listpers;
    }
    
}
