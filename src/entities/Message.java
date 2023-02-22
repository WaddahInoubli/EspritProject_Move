/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Z4RGA
 */
public class Message {
     private int id;
      private String message;
      private int idp;

    public Message() {
    }

    public Message(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message(int id, String message, int idp) {
        this.id = id;
        this.message = message;
        this.idp = idp;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getIdp() {
        return idp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", message=" + message + ", idp=" + idp + '}';
    }
      
      
    
}
