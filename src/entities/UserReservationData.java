package entities;

import java.time.LocalDate;

public class UserReservationData {
    private String nom;
    private String prenom;
    private String address;
    private int phone;
    private String email;
    private String addresse;
    private String chauffeur;
    private LocalDate datedebut;
    private LocalDate datefin;
    private double prix;

    public UserReservationData(Reservation reservation) {



        this.datedebut = reservation.getDatedebut();
        this.datefin = reservation.getDatefin();

    }

    // getters and setters
}
