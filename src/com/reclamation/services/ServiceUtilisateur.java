/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reclamation.services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.*;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.reclamation.entities.*;
import com.reclamation.utils.*;
import com.reclamation.entities.User;
import com.reclamation.gui.UserList;
import static com.reclamation.services.ReclamationService.instance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hassene
 */
public class ServiceUtilisateur {

    public static final String BASE_URL = "http://127.0.0.1:8081/api/users";

    public static User user;
    public static ServiceUtilisateur instance = null;
    public int resultCode;
    private ConnectionRequest req;
    private boolean resultOK;
    private ArrayList<User> listUser;

    public ServiceUtilisateur() {
        req = new ConnectionRequest();

    }

    public static ServiceUtilisateur getInstance() {
        if (instance == null) {
            instance = new ServiceUtilisateur();
        }
        return instance;
    }

    public int Connect(String email, String password) {
        req = new ConnectionRequest();

        req.setHttpMethod("POST");
        req.setUrl(this.BASE_URL + "/login");
        System.out.println(req.getUrl());

        req.addArgument("email", String.valueOf(email));
        req.addArgument("password", password);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("aaaa");
                if (resultOK = req.getResponseCode() == 200) {
                    new UserList(null).show();
                } else {
                    Dialog.show("Login", "Verifier vos parametres", "ok", "cancel");

                }
                resultCode = req.getResponseCode();
                req.removeResponseListener(this);
            }
        });
         try {
            req.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(req);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return resultCode;

    }

    public boolean submitUser(User t) {
        req = new ConnectionRequest();

        req.setHttpMethod("POST");
        req.setUrl(this.BASE_URL+"/");// Insertion de l'URL de notre demande de connexion
                req.addArgument("id", t.getId()+"");

        req.addArgument("email", t.getEmail());
        req.addArgument("nom", t.getNom());
        req.addArgument("prenom", t.getPrenom());
        req.addArgument("age", String.valueOf(t.getAge()));
        req.addArgument("address", t.getAdress());
        req.addArgument("num_tel", t.getNum_tel());
        req.addArgument("role", t.getRole());
        req.addArgument("password", t.getPassword());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                if (resultOK = req.getResponseCode() == 200) {
                    Dialog.show("Inscription", "Succes", "ok", "cancel");
                } else {
                    Dialog.show("Inscription", "Verifier vos parametres", "ok", "cancel");

                }
                //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
            }
        });
         try {
            req.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(req);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultOK;
    }
    
    

    public boolean editUtilisateur(User t) {
        req = new ConnectionRequest();

        req.setHttpMethod("PUT");
        String url = this.BASE_URL + "/edit" ;//création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
                req.addArgument("id", t.getId()+"");

        req.addArgument("email", t.getEmail());
        req.addArgument("nom", t.getNom());
        req.addArgument("prenom", t.getPrenom());
        req.addArgument("age", String.valueOf(t.getAge()));
        req.addArgument("address", t.getAdress());
        req.addArgument("num_tel", t.getNum_tel());
        req.addArgument("role", t.getRole());
        req.addArgument("password", t.getPassword());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                if (resultOK = req.getResponseCode() == 200) {
                    Dialog.show("Utilisateur modifié avec succées", "Succes", "ok", "cancel");
                } else {
                    Dialog.show("Inscription", "Verifier vos parametres", "ok", "cancel");

                }
                //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public User parseClient(String jsonText) {
        User t = null;
        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> obj = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            System.out.println(jsonText);

            //t = new User();
            int id = Integer.parseInt(obj.get("id").toString());
            int age = Integer.parseInt(obj.get("age").toString());

            t.setId((int) id);
            t.setNom(obj.get("nom").toString());
            t.setPrenom(obj.get("prenom").toString());
            t.setEmail(obj.get("email").toString());
            t.setPassword(obj.get("password").toString());
            t.setAdress(obj.get("address").toString());
            t.setAge(age);
            t.setNum_tel(obj.get("num_tel").toString());
            //Ajouter la tâche extraite de la réponse Json à la liste
            System.out.println(t);

        } catch (IOException ex) {

        } finally {
            /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
             */
            return t;
        }
    }

    public ArrayList<User> getAll() {
        listUser = new ArrayList<>();

        req = new ConnectionRequest();
        req.setUrl(this.BASE_URL);
        req.setHttpMethod("GET");

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                if (req.getResponseCode() == 200) {
                    listUser = getList();
                }

                req.removeResponseListener(this);
            }
        });

        try {
            req.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(req);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listUser;
    }

    private ArrayList<User> getList() {
        try {
            Map<String, Object> parsedJson = new JSONParser().parseJSON(new CharArrayReader(
                    new String(req.getResponseData()).toCharArray()
            ));
            List<Map<String, Object>> list = (List<Map<String, Object>>) parsedJson.get("root");

            for (Map<String, Object> obj : list) {
                User user = new User(
                        (int) Float.parseFloat(obj.get("id").toString()),
                        obj.get("nom").toString(),
                        obj.get("prenom").toString(),
                        (int) Float.parseFloat(obj.get("age").toString()),
                        obj.get("adresse").toString(),
                        (String) obj.get("numTel"),
                        (String) obj.get("email"),
                        (String) obj.get("role"),
                        (String) obj.get("password")
                );

                listUser.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listUser;
    }
 public boolean delete(int id) {
        req = new ConnectionRequest();

        req.setHttpMethod("DELETE");
        req.setUrl(this.BASE_URL+"/"+id);// Insertion de l'URL de notre demande de connexion
      

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                if (resultOK = req.getResponseCode() == 200) {

                    Dialog.show("Utilisateur supprimé avec succées", "Succes", "ok", "cancel");
                } else {
                    Dialog.show("Internal error", "Internal error", "ok", "cancel");

                }
                //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
            }
        });
         try {
            req.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(req);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultOK;
    }
    
    
    public static User getUser() {
        return user;
    }

}
