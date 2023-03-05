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
     private int id_mesg ;
     private int id_disc	 ;
     private int id_sender ;
     private String message;

    public Message() {
    }

    public Message(int id_mesg, int id_disc, int id_sender, String message) {
        this.id_mesg = id_mesg;
        this.id_disc = id_disc;
        this.id_sender = id_sender;
        this.message = message;
    }

    public Message(int id_disc, int id_sender, String message) {
        this.id_disc = id_disc;
        this.id_sender = id_sender;
        this.message = message;
    }

    public Message(int id_sender, String message) {
        this.id_sender = id_sender;
        this.message = message;
    }

    public int getId_mesg() {
        return id_mesg;
    }

    public int getId_disc() {
        return id_disc;
    }

    public int getId_sender() {
        return id_sender;
    }

    public String getMessage() {
        return message;
    }

    public void setId_mesg(int id_mesg) {
        this.id_mesg = id_mesg;
    }

    public void setId_disc(int id_disc) {
        this.id_disc = id_disc;
    }

    public void setId_sender(int id_sender) {
        this.id_sender = id_sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" + "id_mesg=" + id_mesg + ", id_disc=" + id_disc + ", id_sender=" + id_sender + ", message=" + message + '}';
    }
      
     
    
}
