package com.reclamation.gui.back.reclamation;


import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.reclamation.entities.Reclamation;
import com.reclamation.gui.uikit.BaseForm;
import com.reclamation.services.ReclamationService;

import java.util.ArrayList;

public class AfficherToutReclamation extends BaseForm {

    Form previous;

    public static Reclamation currentReclamation = null;

    TextField searchTF;
    ArrayList<Component> componentModels;


    public AfficherToutReclamation(Form previous) {
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


        ArrayList<Reclamation> listReclamations = ReclamationService.getInstance().getAll();
        componentModels = new ArrayList<>();

        searchTF = new TextField("", "Chercher reclamation par Title");
        searchTF.addDataChangedListener((d, t) -> {
            if (componentModels.size() > 0) {
                for (Component componentModel : componentModels) {
                    this.removeComponent(componentModel);
                }
            }
            componentModels = new ArrayList<>();
            for (Reclamation reclamation : listReclamations) {
                if (reclamation.getObjectif().toLowerCase().startsWith(searchTF.getText().toLowerCase())) {
                    Component model = makeReclamationModel(reclamation);
                    this.add(model);
                    componentModels.add(model);
                }
            }
            this.revalidate();
        });
        this.add(searchTF);


        if (listReclamations.size() > 0) {
            for (Reclamation reclamation : listReclamations) {
                Component model = makeReclamationModel(reclamation);
                this.add(model);
                componentModels.add(model);
            }
        } else {
            this.add(new Label("Aucune donnée"));
        }
    }

    private void addActions() {

    }

    Label userLabel, objectifLabel, textLabel, etatLabel;


    private Container makeModelWithoutButtons(Reclamation reclamation) {
        Container reclamationModel = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        reclamationModel.setUIID("containerRounded");


        userLabel = new Label("User : " + reclamation.getUser());
        userLabel.setUIID("labelDefault");

        objectifLabel = new Label("Objectif : " + reclamation.getObjectif());
        objectifLabel.setUIID("labelDefault");

        textLabel = new Label("Text : " + reclamation.getText());
        textLabel.setUIID("labelDefault");

        etatLabel = new Label("Etat : " + reclamation.getEtat());
        etatLabel.setUIID("labelDefault");


        reclamationModel.addAll(

                userLabel, objectifLabel, textLabel, etatLabel
        );

        return reclamationModel;
    }

    private Component makeReclamationModel(Reclamation reclamation) {


        return makeModelWithoutButtons(reclamation);
    }

}