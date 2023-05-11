package tn.gestion.evenement.service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tn.gestion.evenement.enitite.Comment;

public class CommentWebService {

    private static final String BASE_URL = "http://127.0.0.1:8000/api";
    private ConnectionRequest connection;

    public CommentWebService() {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
    }

    public List<Comment> getAllComments() {
        String url = BASE_URL + "/comments";
        this.connection.setUrl(url);
        this.connection.setHttpMethod("GET");
        List<Comment> comments = new ArrayList<>();
        this.connection.addResponseListener(e -> {
            if (this.connection.getResponseCode() == 200) {
                String response = new String(this.connection.getResponseData());
                try {
                    JSONArray jsonComments = new JSONArray(response);
                    for (int i = 0; i < jsonComments.length(); i++) {
                        JSONObject jsonComment = jsonComments.getJSONObject(i);
                        Comment comment = new Comment(
                                jsonComment.getInt("id"),
                                jsonComment.getInt("annonces_id"),
                                jsonComment.getString("content"),
                                jsonComment.getBoolean("active"),
                                jsonComment.getString("nickname"),
                                jsonComment.getBoolean("rpgd")
                        );
                        comments.add(comment);
                    }
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            } else {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(this.connection);
        return comments;
    }

    public void newComment(Comment c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        this.connection.setUrl(BASE_URL + "/comments/add");
        this.connection.setHttpMethod("POST");

        connection.addArgument("annonces_id", String.valueOf(c.getAnnonces_id()));
        connection.addArgument("content", c.getContent());
        connection.addArgument("active", c.getActive()+"");
        connection.addArgument("nickname", c.getNickname());
        connection.addArgument("rpgd", c.getRpgd()+"");

        NetworkManager.getInstance().addToQueue(connection);
    }

    public void editComment(Comment c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        System.out.println(c);
        this.connection.setUrl(BASE_URL + "/comments/" + c.getId());
        this.connection.setHttpMethod("PUT");
        connection.addArgument("annonces_id", String.valueOf(c.getAnnonces_id()));
        connection.addArgument("content", c.getContent());
        connection.addArgument("active", c.getActive()+"");
        connection.addArgument("nickname", c.getNickname());
        connection.addArgument("rpgd", c.getRpgd()+"");
        NetworkManager.getInstance().addToQueue(connection);
    }

    public void delComment(Comment c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        this.connection.setUrl(BASE_URL + "/comments/" + c.getId());
        this.connection.setHttpMethod("DELETE");
        NetworkManager.getInstance().addToQueue(connection);
    }

}
