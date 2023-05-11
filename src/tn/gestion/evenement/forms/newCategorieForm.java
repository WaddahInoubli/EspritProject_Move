package tn.gestion.evenement.forms;

import com.codename1.ui.Button;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import tn.gestion.evenement.enitite.Categorie;
import tn.gestion.evenement.service.CategorieWebService;

public class newCategorieForm extends BaseForm {

    public newCategorieForm() {
        this.init(Resources.getGlobalResources());
        TextField nomField = new TextField("", "Nom");
        TextField slugField = new TextField("", "Descriptif");

        this.add(nomField);

        this.add(slugField);

        Button submitButton = new Button("Submit");

        submitButton.addActionListener(s
                -> {
            String nom = nomField.getText();
            String slug = slugField.getText();

            Categorie newCat = new Categorie();
            newCat.setName(nom);
            newCat.setSlug(slug);
            CategorieWebService service = new CategorieWebService();
            service.newCategorie(newCat);
        }
        );
        this.add(submitButton);
        Button goToFormButton = new Button("Go Back");
        goToFormButton.addActionListener(e -> {
            getCategorieForm myForm = new getCategorieForm();
            myForm.show();
        });
        this.add(goToFormButton);
    }

}
