package tn.gestion.evenement.enitite;

public class Annonces {
    private int id;
    private String title;
    private String slug ;
    private String content ;
    private String created_at ;
    private boolean active ;
    private String Name_User ;
    private Categorie categories ;

    public Annonces() {
    }

    public Annonces(String title, String slug, String content, String created_at, boolean active, String Name_User, Categorie categories) {
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.created_at = created_at;
        this.active = active;
        this.Name_User = Name_User;
        this.categories = categories;
    }

    public Annonces(int id, String title, String slug, String content, String created_at, boolean active, String Name_User, Categorie categories) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.created_at = created_at;
        this.active = active;
        this.Name_User = Name_User;
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName_User() {
        return Name_User;
    }

    public void setName_User(String Name_User) {
        this.Name_User = Name_User;
    }

    public Categorie getCategories() {
        return categories;
    }

    public void setCategories(Categorie categories) {
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Annonces{" + "id=" + id + ", title=" + title + ", slug=" + slug + ", content=" + content + ", created_at=" + created_at + ", active=" + active + ", Name_User=" + Name_User + ", categories=" + categories + '}';
    }

}
