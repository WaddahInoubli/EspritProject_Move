/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reclamation;

import com.reclamation.services.ServiceUtilisateur;

/**
 *
 * @author user
 */
public class test {
    public static void main(String[] args) {
    System.out.println(ServiceUtilisateur.getInstance().Connect("f7228@esprit.tn", "12345678"));
  }
}
