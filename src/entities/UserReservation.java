package entities;

import java.time.LocalDate;

public class UserReservation {
    private User user;
    private Voiture voiture;
private String modele;
private String marque;
private int idvoiture;
private  boolean archive;

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public int getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }

    private boolean ifdriver;

    public boolean isIfdriver() {
        return ifdriver;
    }

    public void setIfdriver(boolean ifdriver) {
        this.ifdriver = ifdriver;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    private Reservation reservation;
private LocalDate datedebut;
    private LocalDate datefin;
    private String nom;
    private String prenom;
    private String address;
    private int phone;
    private  Double prix;

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    private int idreservation;
    private String email ;

    public int getIdvoiture() {
        return idvoiture;
    }

    public void setIdvoiture(int idvoiture) {
        this.idvoiture = idvoiture;
    }

    public UserReservation(User user, Reservation reservation , Voiture voiture) {

this.voiture=voiture;
        this.user = user;
        this.reservation = reservation;
        this.datedebut=reservation.getDatedebut();
        this.datefin=reservation.getDatefin();
        this.nom=user.getNom();
        this.prenom=user.getPrenom();
        this.email=user.getEmail();
        this.address=user.getAddress();
        this.phone=user.getPhone();
            this.idreservation=reservation.getId();
         this.marque=voiture.getMarque();
            this.modele=voiture.getModele();
            this.idvoiture=voiture.getId();
            this.ifdriver=reservation.getIfdriver();
            this.prix=voiture.getPrix();
        this.archive=reservation.isArchive();
    }
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
        this.idreservation=reservation.getId();
this.archive=reservation.isArchive();


    }
    public UserReservation( Reservation reservation) {

        this.reservation = reservation;
        this.datedebut=reservation.getDatedebut();
        this.datefin=reservation.getDatefin();
        this.idreservation=reservation.getId();
        this.archive=reservation.isArchive();
    }
    public UserReservation( ) {


        this.idreservation=reservation.getId();
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