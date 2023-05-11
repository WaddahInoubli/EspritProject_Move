package com.reclamation.gui.front;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.reclamation.gui.Login;
import com.reclamation.gui.front.reclamation.AfficherToutReclamation;
import com.reclamation.gui.front.reponse.AfficherToutReponse;

public class AccueilFront extends Form {

    Resources theme = UIManager.initFirstTheme("/theme");
    Label label;
    Form previous;
    public static Form accueilForm;

    public AccueilFront(Form previous) {
        super("Menu", new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;
        accueilForm = this;
        addGUIs();
    }

    private void addGUIs() {
        label = new Label("Espace Utilisateur"/*MainApp.getSession().getEmail()*/);
        label.setUIID("links");
        Button btnDeconnexion = new Button();
        btnDeconnexion.setMaterialIcon(FontImage.MATERIAL_ARROW_FORWARD);
        btnDeconnexion.addActionListener(action -> {
            Login.loginForm.showBack();
        });

        Container userContainer = new Container(new BorderLayout());
        userContainer.setUIID("userContainer");
        userContainer.add(BorderLayout.CENTER, label);
        userContainer.add(BorderLayout.EAST, btnDeconnexion);

        Container menuContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        menuContainer.addAll(userContainer, makeReclamationsButton(), makeReponsesButton());

        this.add(menuContainer);
    }

    private Button makeReclamationsButton() {
        Button button = new Button("Reclamations");
        button.setUIID("buttonMenu");
        button.setMaterialIcon(FontImage.MATERIAL_REPORT);
        button.addActionListener(action -> new AfficherToutReclamation(this).show());
        return button;
    }

    private Button makeReponsesButton() {
        Button button = new Button("Reponses");
        button.setUIID("buttonMenu");
        button.setMaterialIcon(FontImage.MATERIAL_MESSAGE);
        button.addActionListener(action -> new AfficherToutReponse(this).show());
        return button;
    }

}
