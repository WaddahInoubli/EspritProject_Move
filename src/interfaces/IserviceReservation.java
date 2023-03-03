/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.UserReservation;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public interface IserviceReservation<T> {
    
    public void ajouter(T  t);

    public void supprimer(int t);
    public void modifier(T t);
    public ArrayList<T> afficher();

    public ArrayList<T> afficheronereservation(int t);


}
