package tn.gestion.evenement.forms;

import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import tn.gestion.evenement.enitite.Categorie;
import tn.gestion.evenement.service.CategorieWebService;

public class editFormCategorie extends BaseForm {

    CategorieWebService service = new CategorieWebService();
    public editFormCategorie(Categorie e) throws ParseException {
        this.init(Resources.getGlobalResources());
        TextField nomField = new TextField(e.getName(), "name");
        TextField slugField = new TextField(e.getSlug(), "slug");
        this.add(nomField);
        this.add(slugField);
        Button submitButton = new Button("Submit");
        submitButton.addActionListener(s-> {
            String nom = nomField.getText();
            String slug = slugField.getText();

            Categorie categorie = new Categorie();
            categorie.setId(e.getId());
            categorie.setName(nom);
            categorie.setSlug(slug);
            
            service.editCategorie(categorie);
            getCategorieForm myForm = new getCategorieForm();
            myForm.show();
        }
        );
        Button goToFormButton = new Button("Go back");
        goToFormButton.addActionListener(ee -> {
            getCategorieForm myForm = new getCategorieForm();
            myForm.show();
        });
        Button deleteButton = new Button("Delete");
        deleteButton.addActionListener(cc -> {
            service.delCategorie(e);
            getCategorieForm myForm = new getCategorieForm();
            myForm.show();
        });
        this.add(deleteButton);
        this.add(goToFormButton);
        this.add(submitButton);
    }

}
