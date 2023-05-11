package tn.gestion.evenement.forms;


import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import java.util.List;
import tn.gestion.evenement.enitite.Annonces;
import tn.gestion.evenement.enitite.Comment;
import tn.gestion.evenement.service.AnnonceWebService;
import tn.gestion.evenement.service.CommentWebService;

public class editFormComment extends BaseForm {

    private CommentWebService service = new CommentWebService();

    public editFormComment(Comment c) throws ParseException {
        this.init(Resources.getGlobalResources());
        TextField contentField = new TextField(c.getContent());
        RadioButton activeField = new RadioButton("active");
        TextField nicknameField = new TextField(c.getNickname(), "nickname");
        RadioButton rpgdField = new RadioButton("rpgd");
        AnnonceWebService serviceAnnonce = new AnnonceWebService();

        ComboBox<Annonces> annonceField = new ComboBox<>();
        List<Annonces> annonces = serviceAnnonce.getAllAnnonce();
        for (Annonces a : annonces) {
            annonceField.addItem(a);
        }

        this.add(contentField);
        this.add(annonceField);
        this.add(activeField);
        this.add(nicknameField);
        this.add(rpgdField);
        
        Button submitButton = new Button("Submit");
        submitButton.addActionListener(s -> {
            String content = contentField.getText();
            boolean active = activeField.isSelected();
            String nickname = nicknameField.getText();
            boolean rpgd = rpgdField.isSelected();
            Annonces selectedCategorie = annonceField.getSelectedItem();
            Comment comment = new Comment();
            comment.setId(c.getId());
            comment.setAnnonces_id(selectedCategorie.getId());
            comment.setContent(content);
            comment.setActive(active);
            comment.setNickname(nickname);
            comment.setRpgd(rpgd);

            service.editComment(comment);
            getCommentForm myForm = new getCommentForm();
            myForm.show();
        });

        Button goToFormButton = new Button("Go back");
        goToFormButton.addActionListener(ee -> {
            getCommentForm myForm = new getCommentForm();
            myForm.show();
        });

        Button deleteButton = new Button("Delete");
        deleteButton.addActionListener(cc -> {
            service.delComment(c);
            getCommentForm myForm = new getCommentForm();
            myForm.show();
        });

        this.add(deleteButton);
        this.add(goToFormButton);
        this.add(submitButton);
    }

}
