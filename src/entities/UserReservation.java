package entities;

import java.time.LocalDate;

public class UserReservation {
    private User user;
    private Reservation reservation;
private LocalDate datedebut;
    private LocalDate datefin;
    private String nom;
    private String prenom;
    private String address;
    private int phone;
    private String email ;
    public UserReservation(User user, Reservation reservation) {
        this.user = user;
        this.reservation = reservation;
        this.datedebut=reservation.getDatedebut();
        this.datefin=reservation.getDatefin();
        this.nom=user.getNom();
        this.prenom=user.getPrenom();
        this.email=user.getEmail();
        this.address=user.getAddress();
        this.phone=user.getPhone();

    }
    public UserReservation( Reservation reservation) {

        this.reservation = reservation;
        this.datedebut=reservation.getDatedebut();
        this.datefin=reservation.getDatefin();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDatefin() {
        return datefin;
    }

    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }

    public LocalDate getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(LocalDate datedebut) {
        this.datedebut = datedebut;
    }

    public User getUser() {
        return user;
    }

    public Reservation getReservation() {
        return reservation;
    }
}