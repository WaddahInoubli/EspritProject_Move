package com.reclamation.gui.front.reponse;


import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.reclamation.entities.Reponse;
import com.reclamation.gui.uikit.BaseForm;
import com.reclamation.services.ReponseService;

import java.util.ArrayList;

public class AfficherToutReponse extends BaseForm {

    Form previous;

    public static Reponse currentReponse = null;

    TextField searchTF;
    ArrayList<Component> componentModels;


    public AfficherToutReponse(Form previous) {
        super(new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;

        addGUIs();
        addActions();

        super.getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    public void refresh() {
        this.removeAll();
        addGUIs();
        addActions();
        this.refreshTheme();
    }

    private void addGUIs() {


        ArrayList<Reponse> listReponses = ReponseService.getInstance().getAll();
        componentModels = new ArrayList<>();

        searchTF = new TextField("", "Chercher reponse par Content");
        searchTF.addDataChangedListener((d, t) -> {
            if (componentModels.size() > 0) {
                for (Component componentModel : componentModels) {
                    this.removeComponent(componentModel);
                }
            }
            componentModels = new ArrayList<>();
            for (Reponse reponse : listReponses) {
                if (reponse.getObjectif().toLowerCase().startsWith(searchTF.getText().toLowerCase())) {
                    Component model = makeReponseModel(reponse);
                    this.add(model);
                    componentModels.add(model);
                }
            }
            this.revalidate();
        });
        this.add(searchTF);


        if (listReponses.size() > 0) {
            for (Reponse reponse : listReponses) {
                Component model = makeReponseModel(reponse);
                this.add(model);
                componentModels.add(model);
            }
        } else {
            this.add(new Label("Aucune donnée"));
        }
    }

    private void addActions() {

    }

    Label reclamationLabel, objectifLabel, texteLabel, userLabel;


    private Container makeModelWithoutButtons(Reponse reponse) {
        Container reponseModel = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        reponseModel.setUIID("containerRounded");


        reclamationLabel = new Label("Reclamation : " + reponse.getReclamation());
        reclamationLabel.setUIID("labelDefault");

        objectifLabel = new Label("Objectif : " + reponse.getObjectif());
        objectifLabel.setUIID("labelDefault");

        texteLabel = new Label("Texte : " + reponse.getTexte());
        texteLabel.setUIID("labelDefault");

        userLabel = new Label("User : " + reponse.getUser());
        userLabel.setUIID("labelDefault");


        reponseModel.addAll(

                reclamationLabel, objectifLabel, texteLabel, userLabel
        );

        return reponseModel;
    }

    private Component makeReponseModel(Reponse reponse) {


        return makeModelWithoutButtons(reponse);
    }

}