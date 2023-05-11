package com.reclamation.gui.front.reclamation;


import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.reclamation.entities.Reclamation;
import com.reclamation.gui.front.reclamation.AfficherToutReclamation;
import com.reclamation.services.ReclamationService;
import com.reclamation.utils.AlertUtils;

public class AjouterReclamation extends Form {


    TextField userTF;
    TextField objectifTF;
    TextField textTF;
    TextField etatTF;
    Label userLabel;
    Label objectifLabel;
    Label textLabel;
    Label etatLabel;


    Button manageButton;

    Form previous;

    public AjouterReclamation(Form previous) {
        super("Ajouter", new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;

        addGUIs();
        addActions();


        getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    private void addGUIs() {


        userLabel = new Label("User : ");
        userLabel.setUIID("labelDefault");
        userTF = new TextField();
        userTF.setHint("Tapez le user");


        objectifLabel = new Label("Objectif : ");
        objectifLabel.setUIID("labelDefault");
        objectifTF = new TextField();
        objectifTF.setHint("Tapez le objectif");


        textLabel = new Label("Text : ");
        textLabel.setUIID("labelDefault");
        textTF = new TextField();
        textTF.setHint("Tapez le text");


        etatLabel = new Label("Etat : ");
        etatLabel.setUIID("labelDefault");
        etatTF = new TextField();
        etatTF.setHint("Tapez le etat");


        manageButton = new Button("Ajouter");
        manageButton.setUIID("buttonWhiteCenter");

        Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        container.setUIID("containerRounded");

        container.addAll(

                userLabel, userTF,
                objectifLabel, objectifTF,
                textLabel, textTF,
                etatLabel, etatTF,

                manageButton
        );

        this.addAll(container);
    }

    private void addActions() {

        manageButton.addActionListener(action -> {
            if (controleDeSaisie()) {
                int responseCode = ReclamationService.getInstance().add(
                        new Reclamation(


                                (int) Float.parseFloat(userTF.getText()),
                                objectifTF.getText(),
                                textTF.getText(),
                                (int) Float.parseFloat(etatTF.getText())
                        )
                );
                if (responseCode == 200) {
                    AlertUtils.makeNotification("Reclamation ajouté avec succes");
                    showBackAndRefresh();
                } else {
                    Dialog.show("Erreur", "Erreur d'ajout de reclamation. Code d'erreur : " + responseCode, new Command("Ok"));
                }
            }
        });
    }

    private void showBackAndRefresh() {
        ((AfficherToutReclamation) previous).refresh();
        previous.showBack();
    }

    private boolean controleDeSaisie() {


        if (userTF.getText().equals("")) {
            Dialog.show("Avertissement", "User vide", new Command("Ok"));
            return false;
        }
        try {
            Float.parseFloat(userTF.getText());
        } catch (NumberFormatException e) {
            Dialog.show("Avertissement", userTF.getText() + " n'est pas un nombre valide (user)", new Command("Ok"));
            return false;
        }


        if (objectifTF.getText().equals("")) {
            Dialog.show("Avertissement", "Objectif vide", new Command("Ok"));
            return false;
        }


        if (textTF.getText().equals("")) {
            Dialog.show("Avertissement", "Text vide", new Command("Ok"));
            return false;
        }


        if (etatTF.getText().equals("")) {
            Dialog.show("Avertissement", "Etat vide", new Command("Ok"));
            return false;
        }
        try {
            Float.parseFloat(etatTF.getText());
        } catch (NumberFormatException e) {
            Dialog.show("Avertissement", etatTF.getText() + " n'est pas un nombre valide (etat)", new Command("Ok"));
            return false;
        }


        return true;
    }
}