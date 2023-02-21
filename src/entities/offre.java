/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author chedli
 */
public class offre {
    private int Id_Offre;
    private String Poste;
    private String Name_User;
    private String Comment;
    
    
     public offre(String Poste, String Name_User, String Comment) {
       
        this.Poste = Poste;
        this.Name_User = Name_User;
        this.Comment = Comment;
       
    }

    public offre(int Id_Offre, String Poste, String Name_User, String Comment) {
        this.Id_Offre = Id_Offre;
        this.Poste = Poste;
        this.Name_User = Name_User;
        this.Comment = Comment;
        
    }

    public int getId_Offre() {
        return Id_Offre;
    }

    public void setId_Offre(int Id_Offre) {
        this.Id_Offre = Id_Offre;
    }

    public String getPoste() {
        return Poste;
    }

    public void setPoste(String Poste) {
        this.Poste = Poste;
    }

    public String getName_User() {
        return Name_User;
    }

    public void setName_User(String Name_User) {
        this.Name_User = Name_User;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

  

    @Override
    public String toString() {
        return "offre{" + "Id_Offre=" + Id_Offre + ", Poste=" + Poste + ", Name_User=" + Name_User + ", Comment=" + Comment +  '}';
    }
    
}
