package tn.gestion.evenement.service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tn.gestion.evenement.enitite.Annonces;
import tn.gestion.evenement.enitite.Categorie;

public class AnnonceWebService {

    private static final String BASE_URL = "http://127.0.0.1:8000/api";
    private ConnectionRequest connection;

    public AnnonceWebService() {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
    }

    public List<Annonces> getAllAnnonce() {
        String url = BASE_URL + "/annonces";
        this.connection.setUrl(url);
        this.connection.setHttpMethod("GET");
        List<Annonces> annonces = new ArrayList<>();
        this.connection.addResponseListener(e -> {
            if (this.connection.getResponseCode() == 200) {
                String response = new String(this.connection.getResponseData());
                try {
                    JSONArray jsonEvents = new JSONArray(response);
                    for (int i = 0; i < jsonEvents.length(); i++) {
                        JSONObject jsonEvent = jsonEvents.getJSONObject(i);
                        Annonces annonce = new Annonces(
                                jsonEvent.getInt("id"),
                                jsonEvent.getString("title"),
                                jsonEvent.getString("slug"),
                                jsonEvent.getString("content"),
                                jsonEvent.getJSONObject("created_at").getString("date"),
                                jsonEvent.getBoolean("active"),
                                jsonEvent.getString("name_user"),
                                new Categorie(jsonEvent.getInt("categories_id"))
                        );
                        annonces.add(annonce);
                    }
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            } else {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(this.connection);
        return annonces;
    }

    public void newAnnonce(Annonces c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        this.connection.setUrl(BASE_URL + "/annonces/add");
        this.connection.setHttpMethod("POST");

        connection.addArgument("title", c.getTitle());
        connection.addArgument("slug", c.getSlug());
        connection.addArgument("content", c.getContent());
        connection.addArgument("active", c.isActive() + "");
        connection.addArgument("name_user", c.getName_User());
        connection.addArgument("categories_id", c.getCategories().getId() + "");

        NetworkManager.getInstance().addToQueue(connection);
    }

    public void editAnnonce(Annonces c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        this.connection.setUrl(BASE_URL + "/annonces/" + c.getId());
        this.connection.setHttpMethod("PUT");
        
        connection.addArgument("title", c.getTitle());
        connection.addArgument("slug", c.getSlug());
        connection.addArgument("content", c.getContent());
        connection.addArgument("created_at", c.getCreated_at());
        connection.addArgument("active", c.isActive() + "");
        connection.addArgument("name_user", c.getName_User());
        connection.addArgument("categories_id", c.getCategories().getId() + "");

        NetworkManager.getInstance().addToQueue(connection);
    }

    public void delAnnonce(Annonces c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        this.connection.setUrl(BASE_URL + "/annonces/" + c.getId());
        this.connection.setHttpMethod("DELETE");
        NetworkManager.getInstance().addToQueue(connection);
    }

}
