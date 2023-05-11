package tn.gestion.evenement.forms;

import com.codename1.l10n.ParseException;
import com.codename1.ui.list.MultiList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.util.Resources;
import tn.gestion.evenement.enitite.Comment;
import tn.gestion.evenement.service.CommentWebService;

public class getCommentForm extends BaseForm {

    private MultiList commentList;

    public getCommentForm() {
        this.init(Resources.getGlobalResources());
        commentList = new MultiList(new DefaultListModel<>());
        add(commentList);
        getAllComments();
    }

    private void getAllComments() {
        CommentWebService service = new CommentWebService();
        List<Comment> comments = service.getAllComments();
        DefaultListModel<Map<String, Object>> model = (DefaultListModel<Map<String, Object>>) commentList.getModel();
        model.removeAll();
        for (Comment c : comments) {
            Map<String, Object> item = new HashMap<>();
            item.put("Line1", "Content: " + c.getContent());
            item.put("Line2", "Nickname : " + c.getNickname());
            item.put("Line3", c.getId());
            model.addItem(item);
        }
        commentList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    Map<String, Object> selectedItem = (Map<String, Object>) commentList.getSelectedItem();
                    int commentId = (int) selectedItem.get("Line3");
                    Comment selectedComment = null;
                    for (Comment c : comments) {
                        if (c.getId() == commentId) {
                            selectedComment = c;
                            break;
                        }
                    }
                    editFormComment myForm2 = new editFormComment(selectedComment);
                    myForm2.show();
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
        });

    }
}