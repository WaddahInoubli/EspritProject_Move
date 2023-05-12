/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
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


public class ListeEventForm extends Form{
    
    
        Form current;
    public ListeEventForm(Resources res) {
        setTitle("Liste des Evenements");
        current= this;
     
        getContentPane().setScrollVisible(false);
        ArrayList<Event> l= new ArrayList<Event>();
        l=EventService.getInstance().ListeEvent();
        Button ajout = new Button("Ajouter un nouveau evenement");
        
        
        ajout.addActionListener(b->{
        ajouterEventForm a=new ajouterEventForm(res);
        a.show();
        });

        add(new Label("______________________________________________________________________________________________________________________"));

        add(ajout);
        add(new Label("______________________________________________________________________________________________________________________"));
        
        
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
        Button chercher=new Button("Search");

        
        Button treeparnom = new Button("Trier par Nom");
        add(treeparnom);
        add(new Label("______________________________________________________________________________________________________________________"));
        treeparnom.addActionListener(b->{
        TreeparNom a=new TreeparNom(res);
        a.show();
        });   
        
        add(new Label("______________________________________________________________________________________________________________________"));
        Button tree = new Button("Trier par date");
        add(tree);
        add(new Label("______________________________________________________________________________________________________________________"));
        tree.addActionListener(b->{
        Treepardate a=new Treepardate(res);
        a.show();
        });   
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
