package com.reclamation.gui.back.reponse;


import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.reclamation.entities.Reponse;
import com.reclamation.services.ReponseService;
import com.reclamation.utils.AlertUtils;

public class AjouterReponse extends Form {


    TextField reclamationTF;
    TextField objectifTF;
    TextField texteTF;
    TextField userTF;
    Label reclamationLabel;
    Label objectifLabel;
    Label texteLabel;
    Label userLabel;


    Button manageButton;

    Form previous;

    public AjouterReponse(Form previous) {
        super("Ajouter", new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;

        addGUIs();
        addActions();


        getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    private void addGUIs() {


        reclamationLabel = new Label("Reclamation : ");
        reclamationLabel.setUIID("labelDefault");
        reclamationTF = new TextField();
        reclamationTF.setHint("Tapez le reclamation");


        objectifLabel = new Label("Objectif : ");
        objectifLabel.setUIID("labelDefault");
        objectifTF = new TextField();
        objectifTF.setHint("Tapez le objectif");


        texteLabel = new Label("Texte : ");
        texteLabel.setUIID("labelDefault");
        texteTF = new TextField();
        texteTF.setHint("Tapez le texte");


        userLabel = new Label("User : ");
        userLabel.setUIID("labelDefault");
        userTF = new TextField();
        userTF.setHint("Tapez le user");


        manageButton = new Button("Ajouter");
        manageButton.setUIID("buttonWhiteCenter");

        Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        container.setUIID("containerRounded");

        container.addAll(

                reclamationLabel, reclamationTF,
                objectifLabel, objectifTF,
                texteLabel, texteTF,
                userLabel, userTF,

                manageButton
        );

        this.addAll(container);
    }

    private void addActions() {

        manageButton.addActionListener(action -> {
            if (controleDeSaisie()) {
                int responseCode = ReponseService.getInstance().add(
                        new Reponse(


                                (int) Float.parseFloat(reclamationTF.getText()),
                                objectifTF.getText(),
                                texteTF.getText(),
                                (int) Float.parseFloat(userTF.getText())
                        )
                );
                if (responseCode == 200) {
                    AlertUtils.makeNotification("Reponse ajouté avec succes");
                    showBackAndRefresh();
                } else {
                    Dialog.show("Erreur", "Erreur d'ajout de reponse. Code d'erreur : " + responseCode, new Command("Ok"));
                }
            }
        });
    }

    private void showBackAndRefresh() {
        ((AfficherToutReponse) previous).refresh();
        previous.showBack();
    }

    private boolean controleDeSaisie() {


        if (reclamationTF.getText().equals("")) {
            Dialog.show("Avertissement", "Reclamation vide", new Command("Ok"));
            return false;
        }
        try {
            Float.parseFloat(reclamationTF.getText());
        } catch (NumberFormatException e) {
            Dialog.show("Avertissement", reclamationTF.getText() + " n'est pas un nombre valide (reclamation)", new Command("Ok"));
            return false;
        }


        if (objectifTF.getText().equals("")) {
            Dialog.show("Avertissement", "Objectif vide", new Command("Ok"));
            return false;
        }


        if (texteTF.getText().equals("")) {
            Dialog.show("Avertissement", "Texte vide", new Command("Ok"));
            return false;
        }


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


        return true;
    }
}