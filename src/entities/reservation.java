package entities;

import java.util.Date;

public class reservation {

private int id_Reservation ;
private int id_client_FK;
private int id_voiture_FK;
private int id_driver_FK;
private Date DateDebutReservation;
private Date DateFinReservation;
private boolean ifDriver;
private int prix;

    public int getId_Reservation() {
        return id_Reservation;
    }

    public void setId_Reservation(int id_Reservation) {
        this.id_Reservation = id_Reservation;
    }

    public int getId_client_FK() {
        return id_client_FK;
    }

    public void setId_client_FK(int id_client_FK) {
        this.id_client_FK = id_client_FK;
    }

    public int getId_voiture_FK() {
        return id_voiture_FK;
    }

    public void setId_voiture_FK(int id_voiture_FK) {
        this.id_voiture_FK = id_voiture_FK;
    }

    public int getId_driver_FK() {
        return id_driver_FK;
    }

    public void setId_driver_FK(int id_driver_FK) {
        this.id_driver_FK = id_driver_FK;
    }

    public Date getDateDebutReservation() {
        return DateDebutReservation;
    }

    public void setDateDebutReservation(Date dateDebutReservation) {
        DateDebutReservation = dateDebutReservation;
    }

    public Date getDateFinReservation() {
        return DateFinReservation;
    }

    public void setDateFinReservation(Date dateFinReservation) {
        DateFinReservation = dateFinReservation;
    }

    public boolean isIfDriver() {
        return ifDriver;
    }

    public void setIfDriver(boolean ifDriver) {
        this.ifDriver = ifDriver;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public reservation(int id_Reservation, int id_client_FK, int id_voiture_FK, int id_driver_FK, Date dateDebutReservation, Date dateFinReservation, boolean ifDriver, int prix) {
        this.id_Reservation = id_Reservation;
        this.id_client_FK = id_client_FK;
        this.id_voiture_FK = id_voiture_FK;
        this.id_driver_FK = id_driver_FK;
        this.DateDebutReservation = dateDebutReservation;
        this.DateFinReservation = dateFinReservation;
        this.ifDriver = ifDriver;
        this.prix = prix;
    }
}
