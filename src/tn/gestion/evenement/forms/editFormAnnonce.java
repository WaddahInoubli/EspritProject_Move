package tn.gestion.evenement.forms;

import com.codename1.l10n.ParseException;
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

public class editFormAnnonce extends BaseForm {

    AnnonceWebService service = new AnnonceWebService();

    public editFormAnnonce(Annonces e) throws ParseException {
        this.init(Resources.getGlobalResources());

        TextField nomField = new TextField(e.getTitle(), "title");
        TextField slugField = new TextField(e.getSlug(), "slug");
        TextField contentField = new TextField(e.getContent(), "content");
        RadioButton activeButton = new RadioButton("Active");
        TextField name_userField = new TextField(e.getName_User(), "name_user");
        TextField created_atField = new TextField(e.getCreated_at(), "created_at");
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
        submitButton.addActionListener(s -> {
            String nom = nomField.getText();
            String slug = slugField.getText();
            String content = contentField.getText();
            boolean active = activeButton.isSelected();
            String name_user = name_userField.getText();
            String created_at = created_atField.getText();
            Categorie selectedCategorie = categorieField.getSelectedItem();

            Annonces newAnnonce = new Annonces();
            newAnnonce.setId(e.getId());
            newAnnonce.setContent(nom);
            newAnnonce.setCreated_at(nom);
            newAnnonce.setActive(active);
            newAnnonce.setName_User(nom);
            newAnnonce.setCategories(new Categorie(selectedCategorie.getId()));
            newAnnonce.setTitle(nom);
            newAnnonce.setSlug(slug);
            service.editAnnonce(newAnnonce);
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
            service.delAnnonce(e);
            getCategorieForm myForm = new getCategorieForm();
            myForm.show();
        });
        this.add(deleteButton);
        this.add(goToFormButton);
        this.add(submitButton);
    }

}
