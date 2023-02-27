/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.sql.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.MyDB;

/**
 *
 * @author user
 */
public class IServiceUserImpl implements IServiceUser {

    Connection connection;
    Statement ste;
    public static User connectedUser;

    public IServiceUserImpl() {
        connection = MyDB.getInstance().getCon();
    }

    @Override
    public String login(String email, String password) {
        User user = this.findByEmail(email);
        if (user == null) {
            return "compte introuvable";
        }
        if (!user.getActive()) {
            return "compte désactive";
        }
        if (!this.cryptWithMD5(password).equals(user.getMotDePasse())) {
            return "Verifier votre email et mot de passe";
        }
        connectedUser = user;
        return "connected";
    }

    @Override
    public void forgetPassword(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findByUserId(int identifiant) {
        try {
            ste = connection.createStatement();
            String req_select = "SELECT * FROM `esprit3a11`.`user` where id =" + identifiant;
            ResultSet res = ste.executeQuery(req_select);
            while (res.next()) {
                int id = res.getInt(1);
                String nom = res.getString(2);
                String prenom = res.getString(3);
                int age = res.getInt(4);
                String adresse = res.getString(5);
                String numTel = res.getString(6);
                String mail = res.getString(7);
                String role = res.getString(8);
                String motDePasse = res.getString(9);
                Boolean active = res.getBoolean(10);
                User user = new User(id, nom, prenom, age, adresse, numTel, mail, role, motDePasse, active);
                return user;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

        return null;
    }

    @Override
    public void ajouter(User t) throws SQLException {
        try {
            if (this.findByEmail(t.getEmail()) != null) {
                System.out.println("this mail already exist");
                return;
            }
            if (t.getNumTel().length() != 8) {
                System.out.println("Phone number must be 8 caracters");
                return;
            }
            if (!this.isValidEmail(t.getEmail())) {
                System.out.println("The email is not valid");
                return;

            }
            t.setMotDePasse(this.cryptWithMD5(t.getMotDePasse()));
            ste = connection.createStatement();
            String req = "INSERT INTO `esprit3a11`.`User` (`nom`,`prenom`,`age`,`adresse`,`num_tel`,`mail`,`role`,`mot_passe`,`active`) VALUES ('" + t.getNom() + "','" + t.getPrenom() + "'," + t.getAge()
                    + ",'" + t.getAdresse() + "'" + ",'" + t.getNumTel() + "'," + "'" + t.getEmail() + "'," + "'" + t.getRole() + "'," + "'" + t.getMotDePasse() + "'," + t.getActive() + ");";
            ste.executeUpdate(req);

        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    @Override
    public void supprimer(User t) {
        try {
            String requete = "DELETE FROM user WHERE id=" + t.getId();
            Statement st = connection.createStatement();
            st.executeUpdate(requete);
            System.out.println("Utilisateur supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(User t) {

        if (this.findByEmail(t.getEmail()) != null && this.findByEmail(t.getEmail()).getId() != t.getId()) {
            System.out.println("this mail already exist");
            return;
        }
        if (t.getNumTel().length() != 8) {
            System.out.println("Phone number must be 8 caracters");
            return;
        }
        if (!this.isValidEmail(t.getEmail())) {
            System.out.println("The email is not valid");
            return;

        }
        t.setMotDePasse(this.cryptWithMD5(t.getMotDePasse()));
        try {
            String requete = "UPDATE user SET nom=?,prenom=?,age=?,adresse=?,num_tel=?,mail=?,role=?,mot_passe=?,active=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setInt(3, t.getAge());
            pst.setString(4, t.getAdresse());
            pst.setString(5, t.getNumTel());
            pst.setString(6, t.getEmail());
            pst.setString(7, t.getRole());
            pst.setString(8, t.getMotDePasse());
            pst.setBoolean(9, t.getActive());
            pst.setInt(10, t.getId());

            pst.executeUpdate();

            System.out.println("Utilisateur modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<User> afficher() {
        ArrayList<User> listUser = new ArrayList<>();
        try {
            ste = connection.createStatement();
            String req_select = "SELECT * FROM `esprit3a11`.`user`";
            ResultSet res = ste.executeQuery(req_select);
            while (res.next()) {
                int id = res.getInt(1);
                String nom = res.getString(2);
                String prenom = res.getString(3);
                int age = res.getInt(4);
                String adresse = res.getString(5);
                String numTel = res.getString(6);
                String email = res.getString(7);
                String role = res.getString(8);
                String motDePasse = res.getString(9);
                Boolean active = res.getBoolean(10);
                User user = new User(id, nom, prenom, age, adresse, numTel, email, role, motDePasse, active);
                listUser.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

        return listUser;
    }

    @Override
    public User findByEmail(String email) {
        try {
            ste = connection.createStatement();
            String req_select = "SELECT * FROM `esprit3a11`.`user` where mail LIKE '" + email + "'";
            ResultSet res = ste.executeQuery(req_select);
            while (res.next()) {
                int id = res.getInt(1);
                String nom = res.getString(2);
                String prenom = res.getString(3);
                int age = res.getInt(4);
                String adresse = res.getString(5);
                String numTel = res.getString(6);
                String mail = res.getString(7);
                String role = res.getString(8);
                String motDePasse = res.getString(9);
                Boolean active = res.getBoolean(10);
                User user = new User(id, nom, prenom, age, adresse, numTel, mail, role, motDePasse, active);
                return user;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

        return null;
    }

    public Boolean isValidEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public Boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();

    }

    public String cryptWithMD5(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Cryptage error");
        }
        return null;

    }

    @Override
    public List<User> find(String nomR, String prenomR, String numTelR, String roleR, String emailR, Boolean activeR) {
        ArrayList<User> listUser = new ArrayList<>();
        try {
            ste = connection.createStatement();
            String req_select = "SELECT * FROM `esprit3a11`.`user` where nom LIKE '%" + nomR + "%'";
            req_select += " AND prenom LIKE '%" + prenomR + "%'";
            req_select += " AND num_tel LIKE '%" + numTelR + "%'";
            req_select += " AND role LIKE '%" + roleR + "%'";
            req_select += " AND mail LIKE '%" + emailR + "%'";
            if (activeR != null) {
                req_select += " AND active = " + activeR + "";
            }

            ResultSet res = ste.executeQuery(req_select);
            while (res.next()) {
                int id = res.getInt(1);
                String nom = res.getString(2);
                String prenom = res.getString(3);
                int age = res.getInt(4);
                String adresse = res.getString(5);
                String numTel = res.getString(6);
                String email = res.getString(7);
                String role = res.getString(8);
                String motDePasse = res.getString(9);
                Boolean active = res.getBoolean(10);
                User user = new User(id, nom, prenom, age, adresse, numTel, email, role, motDePasse, active);
                listUser.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

        return listUser;
    }

    @Override
    public void acrivateDesactivateUSer(int userId, Boolean activate) {
        try {
            String requete = "UPDATE user SET active=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setBoolean(1, activate);
            pst.setInt(2, userId);
            pst.executeUpdate();

            System.out.println("Utilisateur modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static User getConnectedUser() {
        return connectedUser;
    }

    public static void setConnectedUser(User connectedUser) {
        IServiceUserImpl.connectedUser = connectedUser;
    }

    @Override
    public void modifiersansMotdePasse(User t) {

        if (this.findByEmail(t.getEmail()) != null && this.findByEmail(t.getEmail()).getId() != t.getId()) {
            System.out.println("this mail already exist");
            return;
        }
        if (t.getNumTel().length() != 8) {
            System.out.println("Phone number must be 8 caracters");
            return;
        }
        if (!this.isValidEmail(t.getEmail())) {
            System.out.println("The email is not valid");
            return;

        }
        try {
            String requete = "UPDATE user SET nom=?,prenom=?,age=?,adresse=?,num_tel=?,mail=?,role=?,active=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setInt(3, t.getAge());
            pst.setString(4, t.getAdresse());
            pst.setString(5, t.getNumTel());
            pst.setString(6, t.getEmail());
            pst.setString(7, t.getRole());
            pst.setBoolean(8, t.getActive());
            pst.setInt(9, t.getId());

            pst.executeUpdate();

            System.out.println("Utilisateur modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void extractUsers() {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet
                    = workbook.createSheet("users");
            Row headerRow = sheet.createRow(0);

            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("nom");

            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("prenom");

            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("age");

            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("mail");

            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("numéro de télephone");
            int rowCount = 1;
            for (User user : this.afficher()) {

                Row row = sheet.createRow(rowCount++);

                int columnCount = 0;
                Cell cell = row.createCell(columnCount++);
                cell.setCellValue(user.getNom());

                cell = row.createCell(columnCount++);
                cell.setCellValue(user.getPrenom());

                cell = row.createCell(columnCount++);
                cell.setCellValue(user.getAge());

                cell = row.createCell(columnCount++);
                cell.setCellValue(user.getEmail());

                cell = row.createCell(columnCount++);
                cell.setCellValue(user.getNumTel());
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
            LocalDateTime now = LocalDateTime.now();  
            File f = new File("export/"+dtf.format(now)+"-users.xlsx");
            System.out.println(f.getAbsolutePath());
            FileOutputStream out = new FileOutputStream(f);
            workbook.write(out);

            // Closing file output connections
            out.close();

            // Console message for successful execution of
            // program
            System.out.println(
                    "gfgcontribute.xlsx written successfully on disk.");
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }

    }

}
