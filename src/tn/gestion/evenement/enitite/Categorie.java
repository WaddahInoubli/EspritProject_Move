package tn.gestion.evenement.enitite;

public class Categorie {
    
    private int id;
    private String name;
    private String slug ;

    public Categorie() {
    }

    public Categorie(int id, String name, String slug) {
        this.id = id;
        this.name = name;
        this.slug = slug;
    }

    public Categorie(int id) {
        this.id = id;
    }
    
    public Categorie(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", name=" + name + ", slug=" + slug + '}';
    }

}
