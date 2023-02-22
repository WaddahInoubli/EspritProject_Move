/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */

public interface IService<T>{
    public void ajouter(T  t) throws SQLException;
    public void ajouter2(T  t) throws SQLException;
    void supprimer(int id);
    public void modifier(T t);
    public ArrayList<T> afficher();
}
