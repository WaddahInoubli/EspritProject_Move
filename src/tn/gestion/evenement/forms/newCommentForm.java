/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.gestion.evenement.forms;

import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import java.util.List;
import tn.gestion.evenement.enitite.Annonces;
import tn.gestion.evenement.enitite.Comment;
import tn.gestion.evenement.service.AnnonceWebService;
import tn.gestion.evenement.service.CommentWebService;

class newCommentForm extends BaseForm {

    private CommentWebService service = new CommentWebService();

    public newCommentForm() {
        this.init(Resources.getGlobalResources());
        TextField contentField = new TextField("");
        RadioButton activeButton = new RadioButton("active");
        TextField nicknameField = new TextField("", "nickname");
        RadioButton rpgdField = new RadioButton("rpgd");
        AnnonceWebService serviceAnnonce = new AnnonceWebService();

        ComboBox<Annonces> annonceField = new ComboBox<>();
        List<Annonces> annonces = serviceAnnonce.getAllAnnonce();
        for (Annonces a : annonces) {
            annonceField.addItem(a);
        }

        this.add(contentField);
        this.add(annonceField);
        this.add(activeButton);
        this.add(nicknameField);
        this.add(rpgdField);
        
        
        Button submitButton = new Button("Submit");
        submitButton.addActionListener(s -> {
            String content = contentField.getText();
            boolean active = activeButton.isSelected();
            String nickname = nicknameField.getText();
            boolean rpgd = rpgdField.isSelected();
            
            Annonces selectedCategorie = annonceField.getSelectedItem();
            Comment comment = new Comment();
            comment.setAnnonces_id(selectedCategorie.getId());
            comment.setContent(content);
            comment.setActive(active);
            comment.setNickname(nickname);
            comment.setRpgd(rpgd);

            service.newComment(comment);
            getCommentForm myForm = new getCommentForm();
            myForm.show();
        });

        Button goToFormButton = new Button("Go back");
        goToFormButton.addActionListener(ee -> {
            getCommentForm myForm = new getCommentForm();
            myForm.show();
        });

        this.add(goToFormButton);
        this.add(submitButton);
    }
}
