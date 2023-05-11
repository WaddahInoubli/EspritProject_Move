package tn.gestion.evenement.enitite;

public class Comment {
    
    private int id;
    private int annonces_id;
    private String content;
    private boolean active;
    private String nickname;
    private boolean rpgd;

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", annonces_id=" + annonces_id + ", content=" + content + ", active=" + active + ", nickname=" + nickname + ", rpgd=" + rpgd + '}';
    }
    
    public Comment(int id, int annonces_id, String content, boolean active, String nickname, boolean rpgd) {
        this.id = id;
        this.annonces_id = annonces_id;
        this.content = content;
        this.active = active;
        this.nickname = nickname;
        this.rpgd = rpgd;
    }

    public Comment(int annonces_id, String content, boolean active, String nickname, String created_at, boolean rpgd) {
        this.annonces_id = annonces_id;
        this.content = content;
        this.active = active;
        this.nickname = nickname;
        this.rpgd = rpgd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnnonces_id() {
        return annonces_id;
    }

    public void setAnnonces_id(int annonces_id) {
        this.annonces_id = annonces_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean getRpgd() {
        return rpgd;
    }

    public void setRpgd(boolean rpgd) {
        this.rpgd = rpgd;
    }

    
}
