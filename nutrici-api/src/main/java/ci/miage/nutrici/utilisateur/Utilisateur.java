package ci.miage.nutrici.utilisateur;


public class Utilisateur {


    private String id;

    private String nom;

    private String email;

    private String telephone;

    private String motDePasse;

    private String role;



    public Utilisateur() {
    }



    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }



    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }



    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }



    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public String getMotDePasse() {
        return motDePasse;
    }


    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }



    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }

}