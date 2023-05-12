/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.services.EventService;

import java.util.ArrayList;

/**
 *
 * @author Hayfa
 */
public class TreeparNom extends Form{
    
        Form current;
    public TreeparNom(Resources res) {

     
       
        setTitle("Liste trier par nom");
        current= this;

        TextField search = new TextField("","Search");
        search.setUIID("TextFieldBlack");
          add(search);
       
          
        Button Search = new Button("Search");
        add(Search);

        add(new Label("______________________________________________________________________________________________________________________"));

         Search.addActionListener(b->{
        SearchEvent a=new SearchEvent(res,search.getText());
        a.show();
        });

        getContentPane().setScrollVisible(false);
        ArrayList<Event> l= new ArrayList<Event>();
        l=EventService.getInstance().treeparnom();
        Button ajout = new Button("Ajouter un nouveau evenement");
        
        
        ajout.addActionListener(b->{
        ajouterEventForm a=new ajouterEventForm(res);
        a.show();
        });
        
        add(new Label("______________________________________________________________________________________________________________________"));

        add(ajout);
        add(new Label("______________________________________________________________________________________________________________________"));
        
        
      
        add(new Label("______________________________________________________________________________________________________________________"));

        
       
        
        for (Event p : l)
        {
            Label id = new Label("id :"+p.getIdEvent());
           Label nom= new Label("Nom :"+p.getNom());
           Label desc=new Label("Description :"+p.getDescription());
           Label datedeb=new Label("Date debut :"+p.getDatedeb());
           Label datefin=new Label("Date fin :"+p.getDatefin());


           add(id);
           add(nom);
           add(desc);
           add(datedeb);
           add(datefin);

           
           
         
           
           
           Button remove = new Button("remove");
           remove.addActionListener(e->{
           EventService.getInstance().supprimerEvent(""+p.getIdEvent());
           ListeEventForm a = new ListeEventForm(res);
           a.show();
           });
           add(remove);
           Button modifier = new Button("modifier");
           modifier.addActionListener(k->{
           modifierEventForm h = new modifierEventForm(res,current,p);
           h.show();
           });
           add(modifier);
           Label separator=new Label("__________________________________________________________________________________________________________");
           add(separator);
           
        
        }
        
    }
}
