package entities;

public class User{
    int id=2;

    public User() {
    }
private static final    User user=new User();
    public int getId() {
        return id;
    }
public static  User getInstance(){
        return user;
}
    public void setId(int id) {
        this.id = id;
    }

    private String nom;
    private String prenom;
    private String address;
    private int phone;
    private String email ;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public User(String nom, String s, String prenom, String address, int phone, String email) {
        this.nom = nom;
    }
    public User(String nom, String prenom, String address, int phone, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

}
