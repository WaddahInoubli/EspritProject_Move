package com.reclamation.gui;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.reclamation.entities.User;
import com.reclamation.gui.uikit.BaseForm;
import com.reclamation.services.ServiceUtilisateur;

import java.util.ArrayList;

public class UserList extends BaseForm {

    Form previous;

    public static User currentUser = null;

    TextField searchTF;
    ArrayList<Component> componentModels;

    public UserList(Form previous) {
        super(new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;
        Button ajouterUser = new Button("Ajouter user");
        ajouterUser.addActionListener(l -> {

            new AddUser(null).show();
        });
        this.add(ajouterUser);

        addGUIs();
        addActions();
        super.getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_LOCK, e -> new SignInForm(null).show());

    }

    public void refresh() {
        this.removeAll();
        addGUIs();
        addActions();
        this.refreshTheme();
    }

    private void addGUIs() {

        ArrayList<User> listUser = ServiceUtilisateur.getInstance().getAll();
        componentModels = new ArrayList<>();

        searchTF = new TextField("", "Chercher utilisateur par nom et prenom");
        searchTF.addDataChangedListener((d, t) -> {
            if (componentModels.size() > 0) {
                for (Component componentModel : componentModels) {
                    this.removeComponent(componentModel);
                }
            }
            componentModels = new ArrayList<>();
            for (User user : listUser) {
                if ((user.getNom() + " " + user.getPrenom()).toLowerCase().startsWith(searchTF.getText().toLowerCase())) {
                    Component model = makeUsernModel(user);
                    this.add(model);
                    componentModels.add(model);
                }
            }
            this.revalidate();
        });
        this.add(searchTF);

        if (listUser.size() > 0) {
            for (User user : listUser) {
                Component model = makeUsernModel(user);
                this.add(model);
                componentModels.add(model);
            }
        } else {
            this.add(new Label("Aucune donnée"));
        }
    }

    private void addActions() {

    }

    Label emailLabel, nameLabel, ageLabel, adresseLabel, numTelLabel, roleLabel;

    private Container makeModelWithoutButtons(User user) {
        Container reclamationModel = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        reclamationModel.setUIID("containerRounded");

        emailLabel = new Label("Email : " + user.getEmail());
        emailLabel.setUIID("labelDefault");

        nameLabel = new Label(user.getNom() + " " + user.getPrenom());
        nameLabel.setUIID("labelDefault");

        ageLabel = new Label("Age : " + user.getAge());
        ageLabel.setUIID("labelDefault");

        adresseLabel = new Label("Adresse : " + user.getAdress());
        adresseLabel.setUIID("labelDefault");

        roleLabel = new Label("Role : " + user.getRole());
        roleLabel.setUIID("labelDefault");

        Button editButton = new Button("Edit ");
        editButton.addActionListener(e -> {
            //System.out.println("result users"+ServiceUtilisateur.getInstance().getAll().size());

            new EditForm(null, user).show();

        });
        
        Button deleteButton = new Button("Delete ");
        deleteButton.addActionListener(e -> {
            ServiceUtilisateur.getInstance().delete(user.getId());
            this.refresh();
        });

        reclamationModel.addAll(
                emailLabel, nameLabel, ageLabel, adresseLabel, roleLabel, editButton,deleteButton
        );

        return reclamationModel;
    }

    private Component makeUsernModel(User user) {

        return makeModelWithoutButtons(user);
    }

}
