package com.reclamation.services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;
import com.reclamation.entities.*;
import com.reclamation.utils.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReponseService {

    public static ReponseService instance = null;
    public int resultCode;
    private ConnectionRequest cr;
    private ArrayList<Reponse> listReponses;

    

    private ReponseService() {
        cr = new ConnectionRequest();
    }

    public static ReponseService getInstance() {
        if (instance == null) {
            instance = new ReponseService();
        }
        return instance;
    }
    
    public ArrayList<Reponse> getAll() {
        listReponses = new ArrayList<>();

        cr = new ConnectionRequest();
        cr.setUrl(Statics.BASE_URL + "/reponse");
        cr.setHttpMethod("GET");

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                if (cr.getResponseCode() == 200) {
                    listReponses = getList();
                }

                cr.removeResponseListener(this);
            }
        });

        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listReponses;
    }

    private ArrayList<Reponse> getList() {
        try {
            Map<String, Object> parsedJson = new JSONParser().parseJSON(new CharArrayReader(
                    new String(cr.getResponseData()).toCharArray()
            ));
            List<Map<String, Object>> list = (List<Map<String, Object>>) parsedJson.get("root");

            for (Map<String, Object> obj : list) {
                Reponse reponse = new Reponse(
                        (int) Float.parseFloat(obj.get("id").toString()),
                        
                        (int) Float.parseFloat(obj.get("reclamation").toString()),
                        (String) obj.get("objectif"),
                        (String) obj.get("texte"),
                        (int) Float.parseFloat(obj.get("user").toString())
                        
                );

                listReponses.add(reponse);
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }
        return listReponses;
    }
    
    public int add(Reponse reponse) {
        
        cr = new ConnectionRequest();

        cr.setHttpMethod("POST");
        cr.setUrl(Statics.BASE_URL + "/reponse/add");
        
        cr.addArgument("reclamation", String.valueOf(reponse.getReclamation()));
        cr.addArgument("objectif", reponse.getObjectif());
        cr.addArgument("texte", reponse.getTexte());
        cr.addArgument("user", String.valueOf(reponse.getUser()));
        
        
        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultCode = cr.getResponseCode();
                cr.removeResponseListener(this);
            }
        });
        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception ignored) {

        }
        return resultCode;
    }

    public int edit(Reponse reponse) {
        
        cr = new ConnectionRequest();
        cr.setHttpMethod("POST");
        cr.setUrl(Statics.BASE_URL + "/reponse/edit");
        cr.addArgument("id", String.valueOf(reponse.getId()));
      
        cr.addArgument("reclamation", String.valueOf(reponse.getReclamation()));
        cr.addArgument("objectif", reponse.getObjectif());
        cr.addArgument("texte", reponse.getTexte());
        cr.addArgument("user", String.valueOf(reponse.getUser()));
        
        
        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultCode = cr.getResponseCode();
                cr.removeResponseListener(this);
            }
        });
        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception ignored) {

        }
        return resultCode;
    }

    public int delete(int reponseId) {
        cr = new ConnectionRequest();
        cr.setUrl(Statics.BASE_URL + "/reponse/delete");
        cr.setHttpMethod("POST");
        cr.addArgument("id", String.valueOf(reponseId));

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cr.removeResponseListener(this);
            }
        });

        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cr.getResponseCode();
    }
}
