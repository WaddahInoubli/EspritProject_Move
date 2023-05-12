/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.services.EventService;

/**
 *
 * @author Hayfa
 */
public class modifierEventForm extends Form{
       Form current;
    public modifierEventForm(Resources res,Form previous,Event pr){
        setTitle("Modifier  Evenement");
        current= this;

        getContentPane().setScrollVisible(false);


        
     

       TextField nom = new TextField(pr.getNom(),"Nom ");
        nom.setUIID("TextFieldBlack");
       
       TextField description = new TextField(pr.getDescription(),"Description");
       description.setUIID("TextFieldBlack");

    
       
       TextField datedeb = new TextField(pr.getDatedeb(),"Datedeb");
        datedeb.setUIID("TextFieldBlack");

       
        TextField datefin = new TextField(pr.getDatefin(),"Datefin");
        datefin.setUIID("TextFieldBlack");
        
       
       Button btnAjouter = new Button("Modifier");
       btnAjouter.addActionListener((e) -> {
            
                try{
                  if(nom.getText()=="" || description.getText()==""|| datedeb.getText()==""||datefin.getText()=="") {
                    Dialog.show("Veuillez vérifier les données","","Annuler","OK");
                  }
                  else{
                        InfiniteProgress ip = new InfiniteProgress();;
                        final Dialog iDialog = ip.showInfiniteBlocking();
                        Event p ;
                        String datedebevent=datedeb.getText().toString();
                        String nomevent=nom.getText().toString();
                        String desc=description.getText().toString();
                        String datefinevent=datefin.getText().toString();

                        p= new Event(0,0,nomevent,datedebevent,datefinevent,"",desc,0)  ;  
                        p.setIdEvent(pr.getIdEvent());
                    System.out.println("data Auto == "+p );
                      EventService.getInstance().ModifierEvent(p);
                    iDialog.dispose();

                    new ListeEventForm(res).show();

                    refreshTheme();
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
       });
       this.add(nom);
       this.add(datedeb);
       this.add(datefin);
       this.add(description);
       this.add(btnAjouter);
       Button back= new Button("Cancel");
               back.addActionListener(l->{
                       previous.show();
               
               });
       this.add(back);
    }


    
}
