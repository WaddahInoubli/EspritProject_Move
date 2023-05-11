/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.reclamation.gui;

import com.codename1.capture.Capture;
import com.codename1.components.FloatingHint;
import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import static com.codename1.ui.TextArea.NUMERIC;
import static com.codename1.ui.TextArea.PASSWORD;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.Date;
import com.codename1.io.Util;
import com.codename1.ui.ComboBox;
import com.reclamation.entities.User;
import com.reclamation.gui.uikit.BaseForm;

import com.reclamation.services.ServiceUtilisateur;

/**
 * Signup UI
 *
 * @author Shai Almog
 */
public class AddUser extends BaseForm {

    String FileNameInServer;

    public AddUser(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container1");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        super.getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

        //setUIID("addUSERR");
        TextField nom = new TextField();
        TextField prenom = new TextField();
        TextField email = new TextField();
        TextField password = new TextField();
        TextField adresse = new TextField();
        TextField telephone = new TextField();
        TextField age = new TextField();
        ComboBox<String> roles = new ComboBox<>();
        roles.addItem("ADMIN");
        roles.addItem("CLIENT");
        roles.addItem("CONDUCTEUR");

        Container h1 = new Container(BoxLayout.x());
        TextField imagel = new TextField();
        Button imageb = new Button();

        email.setHint("E-mail");
        password.setHint("Mot de passe");
        nom.setHint("Nom");
        prenom.setHint("Prenom");
        adresse.setHint("Adresse");
        telephone.setHint("Telephone");
        age.setHint("Age");
        password.setConstraint(PASSWORD);
        telephone.setConstraint(NUMERIC);
        email.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        nom.setSingleLineTextArea(false);
        prenom.setSingleLineTextArea(false);
        adresse.setSingleLineTextArea(false);
        telephone.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);

               Button next = new Button("Valider");


        Container content = BoxLayout.encloseY(
                new Label("Créer un nouveau", "LogoLabel"),
                new FloatingHint(nom),
                createLineSeparator(),
                new FloatingHint(prenom),
                createLineSeparator(),
                new FloatingHint(email),
                createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
                new FloatingHint(adresse),
                createLineSeparator(),
                roles,
                createLineSeparator(),
                                createLineSeparator(),
                                age,
                                telephone,
                                next
        );

        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        

        next.requestFocus();
        

        next.addActionListener(l -> {
            User user = new User(0, nom.getText(), prenom.getText(), Integer.parseInt(age.getText()), adresse.getText(),telephone.getText(), email.getText(),roles.getSelectedItem(), password.getText());
            ServiceUtilisateur.getInstance().submitUser(user);

            new UserList(this).show();
        });

    }
}
