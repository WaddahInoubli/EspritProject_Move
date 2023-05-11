package com.reclamation.gui.back.reponse;


import com.codename1.components.InteractionDialog;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.reclamation.entities.Reponse;
import com.reclamation.gui.uikit.BaseForm;
import com.reclamation.services.ReponseService;

import java.util.ArrayList;

public class AfficherToutReponse extends BaseForm {

    Form previous;

    public static Reponse currentReponse = null;
    Button addBtn;

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


        addBtn = new Button("Ajouter");
        addBtn.setUIID("buttonWhiteCenter");
        this.add(addBtn);


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
        addBtn.addActionListener(action -> {
            currentReponse = null;
            new AjouterReponse(this).show();
        });

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

    Button editBtn, deleteBtn;
    Container btnsContainer;

    private Component makeReponseModel(Reponse reponse) {

        Container reponseModel = makeModelWithoutButtons(reponse);

        btnsContainer = new Container(new BorderLayout());
        btnsContainer.setUIID("containerButtons");

        editBtn = new Button("Modifier");
        editBtn.setUIID("buttonWhiteCenter");
        editBtn.addActionListener(action -> {
            currentReponse = reponse;
            new ModifierReponse(this).show();
        });

        deleteBtn = new Button("Supprimer");
        deleteBtn.setUIID("buttonWhiteCenter");
        deleteBtn.addActionListener(action -> {
            InteractionDialog dlg = new InteractionDialog("Confirmer la suppression");
            dlg.setLayout(new BorderLayout());
            dlg.add(BorderLayout.CENTER, new Label("Voulez vous vraiment supprimer ce reponse ?"));
            Button btnClose = new Button("Annuler");
            btnClose.addActionListener((ee) -> dlg.dispose());
            Button btnConfirm = new Button("Confirmer");
            btnConfirm.addActionListener(actionConf -> {
                int responseCode = ReponseService.getInstance().delete(reponse.getId());

                if (responseCode == 200) {
                    currentReponse = null;
                    dlg.dispose();
                    reponseModel.remove();
                    this.refreshTheme();
                } else {
                    Dialog.show("Erreur", "Erreur de suppression du reponse. Code d'erreur : " + responseCode, new Command("Ok"));
                }
            });
            Container btnContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
            btnContainer.addAll(btnClose, btnConfirm);
            dlg.addComponent(BorderLayout.SOUTH, btnContainer);
            dlg.show(800, 800, 0, 0);
        });

        btnsContainer.add(BorderLayout.WEST, editBtn);
        btnsContainer.add(BorderLayout.EAST, deleteBtn);


        reponseModel.add(btnsContainer);

        return reponseModel;
    }

}