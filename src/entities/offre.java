/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author chedli
 */
public class offre {
    private int Id_Offre;
    private String Name_User;
    private String content;
    private String Comment;
    private LocalDate date;

    public offre(int Id_Offre, String content, String Name_User, String Comment, LocalDate date) {
        this.Id_Offre = Id_Offre;
        this.content = content;
        this.Name_User = Name_User;
        this.Comment = Comment;
        this.date = date;
    }

    public int getId_Offre() {
        return Id_Offre;
    }

    public void setId_Offre(int Id_Offre) {
        this.Id_Offre = Id_Offre;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "offre{" + "Id_Offre=" + Id_Offre + ", content=" + content + ", Name_User=" + Name_User + ", Comment=" + Comment + ", date=" + date + '}';
    }
    
    
}

    
