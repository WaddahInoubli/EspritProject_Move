package tn.gestion.evenement.forms;


import com.codename1.l10n.ParseException;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.layouts.BoxLayout;
import com.reclamation.entities.Reclamation;
import com.reclamation.services.ReclamationService;

public class BaseForm extends com.codename1.ui.Form {



    public void init(Resources theme) {
        Toolbar tb = getToolbar();

        tb.getAllStyles().setBgColor(0xffffff);

        Image logo = theme.getImage("logo.png");
        Label logoLabel = new Label(logo);
        Container logoContainer = BorderLayout.center(logoLabel);
        logoContainer.setUIID("SideCommandLogo");
        tb.addComponentToSideMenu(logoContainer);

        Label taglineLabel = new Label("MENU");
        taglineLabel.setUIID("SideCommandTagline");
        Container taglineContainer = BorderLayout.south(taglineLabel);
        taglineContainer.setUIID("SideCommand");

        tb.addComponentToSideMenu(taglineContainer);
        tb.addMaterialCommandToSideMenu("List Categorie", FontImage.MATERIAL_LIST, e -> {
            getCategorieForm f = new getCategorieForm();
            f.show();
        });
        tb.addMaterialCommandToSideMenu("Ajouter Categorie", FontImage.MATERIAL_ADD, e -> {
            newCategorieForm f = new newCategorieForm();
            f.show();
        });
        tb.addMaterialCommandToSideMenu("List Annonce", FontImage.MATERIAL_LIST, e -> {
            getAnnoncesForm f = new getAnnoncesForm();
            f.show();
        });
        tb.addMaterialCommandToSideMenu("Ajouter Annonce", FontImage.MATERIAL_LIST, e -> {
            newAnnonceForm f = new newAnnonceForm();
            f.show();
        });
        tb.addMaterialCommandToSideMenu("List Comment", FontImage.MATERIAL_LIST, e -> {
            getCommentForm f = new getCommentForm();
            f.show();
        });
        tb.addMaterialCommandToSideMenu("Ajouter Comment", FontImage.MATERIAL_LIST, e -> {
            newCommentForm f = new newCommentForm();
            f.show();
        });
       tb.addMaterialCommandToSideMenu("Afficher Reclamation", FontImage.MATERIAL_LIST, e -> {
                    com.reclamation.gui.back.AccueilBack form = new com.reclamation.gui.back.AccueilBack(this);

            form.show();
        });
         tb.addMaterialCommandToSideMenu("Afficher Reclamation Front", FontImage.MATERIAL_LIST, e -> {
                    com.reclamation.gui.front.AccueilFront form = new com.reclamation.gui.front.AccueilFront(this);

            form.show();
        });
    }
   
}
