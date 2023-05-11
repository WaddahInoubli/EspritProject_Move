package tn.gestion.evenement.forms;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import java.util.List;
import tn.gestion.evenement.enitite.Annonces;
import tn.gestion.evenement.enitite.Categorie;
import tn.gestion.evenement.service.AnnonceWebService;
import tn.gestion.evenement.service.CategorieWebService;

public class newAnnonceForm extends BaseForm {

    public newAnnonceForm() {
        this.init(Resources.getGlobalResources());
        TextField nomField = new TextField("", "title");
        TextField slugField = new TextField("", "slug");
        TextField contentField = new TextField("", "content");
        RadioButton activeButton = new RadioButton("Active");
        TextField name_userField = new TextField("", "name_user");
        TextField created_atField = new TextField("", "created_at");
        CategorieWebService serviceCat = new CategorieWebService();
        ComboBox<Categorie> categorieField = new ComboBox<>();
        List<Categorie> categories = serviceCat.getAllCategorie();
        for (Categorie categorie : categories) {
            categorieField.addItem(categorie);
        }

        this.add(nomField);
        this.add(slugField);
        this.add(contentField);
        this.add(activeButton);
        this.add(name_userField);
        this.add(created_atField);
        this.add(categorieField);

        Button submitButton = new Button("Submit");

        submitButton.addActionListener(s
                -> {
            String nom = nomField.getText();
            String slug = slugField.getText();
            String content = contentField.getText();
            boolean active = activeButton.isSelected();
            String name_user = name_userField.getText();
            String created_at = created_atField.getText();
            Categorie selectedCategorie = categorieField.getSelectedItem();

            Annonces newAnnonce = new Annonces();
            newAnnonce.setContent(nom);
            newAnnonce.setCreated_at(nom);
            newAnnonce.setActive(active);
            newAnnonce.setName_User(nom);
            newAnnonce.setCategories(new Categorie(selectedCategorie.getId()));
            newAnnonce.setTitle(nom);
            newAnnonce.setSlug(slug);
            AnnonceWebService service = new AnnonceWebService();
            service.newAnnonce(newAnnonce);
        }
        );
        this.add(submitButton);
        Button goToFormButton = new Button("Go Back");
        goToFormButton.addActionListener(e -> {
            getAnnoncesForm myForm = new getAnnoncesForm();
            myForm.show();
        });
        this.add(goToFormButton);
    }

}
