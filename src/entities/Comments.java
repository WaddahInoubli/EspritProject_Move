/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
    private Date date_com;

    public Comments(int Id_publication, String contenent, String Name_User, Date date_com) {
        this.Id_publication = Id_publication;
        this.contenent = contenent;
        this.Name_User = Name_User;
        this.date_com = date_com;
    }

    public Comments(int Id_Comment, int Id_publication, String contenent, String Name_User, Date date_com) {
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

    public String getContenent() {
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

    public Date getDate_com() {
        return date_com;
    }

    public void setDate_com(Date date_com) {
        this.date_com = date_com;
    }
}
