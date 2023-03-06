/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author chedli
 */
public class Comments {
    private int Id_Comment ;
    private int Id_publication ;  
    private String contenent;
    private String Name_User;
    private LocalDate date_com;
     private LocalDate dater_com;

    public Comments(int Id_publication, String contenent, String Name_User, LocalDate date_com) {
        this.Id_publication = Id_publication;
        this.contenent = contenent;
        this.Name_User = Name_User;
        this.date_com = date_com;
    }

    public Comments(int Id_Comment, int Id_publication, String contenent, String Name_User, LocalDate date_com) {
        this.Id_Comment = Id_Comment;
        this.Id_publication = Id_publication;
        this.contenent = contenent;
        this.Name_User = Name_User;
        this.date_com = date_com;
    }

    public int getId_Comment() {
        return Id_Comment;
    }

    public void setId_Comment(int Id_Comment) {
        this.Id_Comment = Id_Comment;
    }

    public int getId_publication() {
        return Id_publication;
    }

    public void setId_publication(int Id_publication) {
        this.Id_publication = Id_publication;
    }

    public String getcontenent() {
        return contenent;
    }

    public void setContenent(String contenent) {
        this.contenent = contenent;
    }

    public String getName_User() {
        return Name_User;
    }

    public void setName_User(String Name_User) {
        this.Name_User = Name_User;
    }

    public LocalDate getDate_com() {
        return date_com;
    }

    public void setDate_com(LocalDate date_com) {
        this.date_com = date_com;
    }
}
