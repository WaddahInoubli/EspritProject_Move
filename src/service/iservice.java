/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tekay
 * @param <T>
 */
public interface iservice<T> {
    public void ajouter(T  t) throws SQLException;
    public void supprimer(T t) throws SQLException;
    public void modifier(T t) throws SQLException;
    public ArrayList<T> afficher();
}
