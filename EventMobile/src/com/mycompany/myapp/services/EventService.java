/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.db.Database;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hayfa
 */
public class EventService {
     Database db;
    public ArrayList<Event> produit;
    public static EventService instance;
    public boolean resultOK;
    private ConnectionRequest req;
    ConnectionRequest request = new ConnectionRequest();

    
    
    public EventService() {
        req = new ConnectionRequest();
    }
    
    public static EventService getInstance() {
    if (instance == null){
        instance = new EventService();
    }
    return instance;
    }
    
    
     public boolean AjoutEvent (Event p){
        String url = Statics.BASE_URL + "/addeventJSON?nom="+p.getNom()+"&datedeb="+p.getDatedeb()+"&datefin="+p.getDatefin()+"&description="+p.getDescription()+"&place_id="+p.getIdPlace()+"&user_id="+p.getIdUser();
        
        System.out.print(url);
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK=req.getResponseCode()==200; //kif yebda url succ yraja3 200
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;        
    }
    
      public boolean ModifierEvent (Event p){
        String url = Statics.BASE_URL + "/editeventJSON?id="+p.getIdEvent()+"&nom="+p.getNom()+"&datedeb="+p.getDatedeb()+"&datefin="+p.getDatefin()+"&description="+p.getDescription()+"&place_id=2&user_id=1";
        //127.0.0.1:8000/web/service/produits/ajout?titre=ka&description=test&promo=1&stock=10&flash=0&ref=10&longdescription=test&prix=1000.0&categories=3
                System.out.print(url);
    
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK=req.getResponseCode()==200; 
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;        
    }
    
    
      public void supprimerEvent(String p){
        String url = Statics.BASE_URL + "/removeeventJSON?id="+ p;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                req.removeResponseListener(this);
            }
        });
          NetworkManager.getInstance().addToQueueAndWait(req);
    }
      
    
      public ArrayList<Event> SearchEvent(String chaine) {
         
   
              String url ="http://127.0.0.1:8000/searchEvent?search="+chaine;
              req.setUrl(url);
              req.addResponseListener(new ActionListener<NetworkEvent>() {
                  @Override
                  public void actionPerformed(NetworkEvent evt) {
                      try {
                          produit = (ArrayList<Event>) parseEvent(new String(req.getResponseData()));
                          req.removeResponseListener(this);
                          
                      } catch (IOException ex) {

                      }
                  }
              });
              NetworkManager.getInstance().addToQueueAndWait(req);
              return produit;
              
           
          }
      
      
     public ArrayList<Event> ListeEvent() {
         
   
              String url =Statics.BASE_URL +"/eventJSON";
              req.setUrl(url);
              req.addResponseListener(new ActionListener<NetworkEvent>() {
                  @Override
                  public void actionPerformed(NetworkEvent evt) {
                      try {
                          produit = (ArrayList<Event>) parseEvent(new String(req.getResponseData()));
                          req.removeResponseListener(this);
                          
                      } catch (IOException ex) {

                      }
                  }
              });
              NetworkManager.getInstance().addToQueueAndWait(req);
              return produit;
              
           
          }
     
      public ArrayList<Event> treepardate() {
         
   
              String url ="http://127.0.0.1:8000/treepardate";
              req.setUrl(url);
              req.addResponseListener(new ActionListener<NetworkEvent>() {
                  @Override
                  public void actionPerformed(NetworkEvent evt) {
                      try {
                          produit = (ArrayList<Event>) parseEvent(new String(req.getResponseData()));
                          req.removeResponseListener(this);
                          
                      } catch (IOException ex) {

                      }
                  }
              });
              NetworkManager.getInstance().addToQueueAndWait(req);
              return produit;
              
           
          }
     
      public ArrayList<Event> treeparnom() {
              String url ="http://127.0.0.1:8000/treenom";
              req.setUrl(url);
              req.addResponseListener(new ActionListener<NetworkEvent>() {
                  @Override
                  public void actionPerformed(NetworkEvent evt) {
                      try {
                          produit = (ArrayList<Event>) parseEvent(new String(req.getResponseData()));
                          req.removeResponseListener(this);
                          
                      } catch (IOException ex) {

                      }
                  }
              });
              NetworkManager.getInstance().addToQueueAndWait(req);
              return produit;
          }
     
     public ArrayList<Event> parseEvent(String jsonText) throws IOException {//Conversion de JSON to MAP
        try {
            
            produit = new ArrayList<>();
            JSONParser j = new JSONParser();//class :na9raw bih JSON 
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            
            for (Map<String, Object> obj : list) {
                
                Event p = new Event();
                

                String s;
                int test=(int) Float.parseFloat(obj.get("id").toString());
                int nb =Math.round(test);
                s = String.valueOf(nb);
                
                p.setIdEvent((int) Float.parseFloat(obj.get("id").toString()));//type int =parsefloat
                p.setNom((obj.get("nom").toString()));
                p.setDatedeb((obj.get("datedeb").toString()));
                p.setDatefin((obj.get("datefin").toString()));
                p.setDescription((obj.get("description").toString()));

                
                
                produit.add(p);
                System.out.println(s.toString());
            }
        } catch (IOException ex) {
        }
        return produit;
    }
}
