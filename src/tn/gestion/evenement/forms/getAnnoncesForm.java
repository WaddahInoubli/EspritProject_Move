package tn.gestion.evenement.forms;

import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.list.MultiList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.util.Resources;
import java.util.Collections;
import java.util.Comparator;
import tn.gestion.evenement.enitite.Annonces;
import tn.gestion.evenement.service.AnnonceWebService;

public class getAnnoncesForm extends BaseForm {

    private MultiList eventList;
    private List<Annonces> annonces;
    private TextField searchField;

    public getAnnoncesForm() {
        this.init(Resources.getGlobalResources());

        Button sortButton = new Button("Sort by Type");
        sortButton.addActionListener(e -> {
            Collections.sort(annonces, new Comparator<Annonces>() {
                @Override
                public int compare(Annonces p1, Annonces p2) {
                    return p1.getTitle().compareToIgnoreCase(p2.getTitle());
                }
            });
            updateList();
        });
        addComponent(BorderLayout.south(sortButton));
        eventList = new MultiList(new DefaultListModel<>());
        add(eventList);
        getAllAnnonces();
    }

    private void getAllAnnonces() {
        AnnonceWebService service = new AnnonceWebService();
        annonces = service.getAllAnnonce();
        DefaultListModel<Map<String, Object>> model = (DefaultListModel<Map<String, Object>>) eventList.getModel();
        model.removeAll();
        for (Annonces c : annonces) {
            Map<String, Object> item = new HashMap<>();
            item.put("Line1", "Title: " + c.getTitle());
            item.put("Line2", "Desc : " + c.getSlug());
            item.put("Line3", c.getId());
            model.addItem(item);
        }
        eventList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    Map<String, Object> selectedItem = (Map<String, Object>) eventList.getSelectedItem();
                    int catId = (int) selectedItem.get("Line3");
                    Annonces selectedEvent = null;
                    for (Annonces c : annonces) {
                        if (c.getId() == catId) {
                            selectedEvent = c;
                            break;
                        }
                    }
                    editFormAnnonce myForm2 = new editFormAnnonce(selectedEvent);
                    myForm2.show();
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
        });

        searchField = new TextField("", "Enter Promotion Type");
        Button searchButton = new Button("Search");
        searchButton.addActionListener(e -> {
            try {
                String searchId = searchField.getText();
                Annonces selectedAnnonce = null;
                for (Annonces p : annonces) {
                    if (p.getName_User()== null ? searchId == null : p.getName_User().equals(searchId)) {
                        selectedAnnonce = p;
                        break;
                    }
                }
                if (selectedAnnonce != null) {
                    editFormAnnonce myForm2 = new editFormAnnonce(selectedAnnonce);
                    myForm2.show();
                } else {
                    Dialog.show("Error", "Annonces not found", "OK", null);
                }
            } catch (NumberFormatException ex) {
                Dialog.show("Error", "Invalid ID", "OK", null);
            } catch (ParseException ex) {
                System.out.println(ex);
            }
        });
        Container searchContainer = BorderLayout.west(searchField).add(BorderLayout.EAST, searchButton);
        addComponent(searchContainer);
    }

    private void updateList() {
        DefaultListModel<Map<String, Object>> model = (DefaultListModel<Map<String, Object>>) eventList.getModel();
        model.removeAll();
        for (Annonces c : annonces) {
            Map<String, Object> item = new HashMap<>();
            item.put("Line1", "Title: " + c.getTitle());
            item.put("Line2", "Desc : " + c.getSlug());
            item.put("Line3", c.getId());
            model.addItem(item);
        }
    }
}
