/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author user
 */
public class MailService {
    
     public final String username = "firas.jallali@esprit.tn";
    public final String password = "";

    public void envoyer(User user, String contenumailFrom) {
// Etape 1 : Création de la session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.protocol.ssl.trust", "*");
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
// Etape 2 : Création de l'objet Message

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("firas.jallali@esprit.tn"));
            System.out.println("1");
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            System.out.println("2");
            message.setSubject("Mot de passe oublié");

            message.setText(contenumailFrom + "\n");
// Etape 3 : Envoyer le message
            System.out.println("3");
            //Transport transport =session.getTransport();
            Transport.send(message);
            System.out.println("4");
            System.out.println("Message_envoye");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
            //System.err.println(e);
            //System.out.println("salut");

        }

    }
}
