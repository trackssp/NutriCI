package ci.miage.nutrici.historique;


import java.time.LocalDateTime;


public class Historique {


    private String id;

    private String action;

    private String utilisateur;

    private String description;

    private LocalDateTime date;



    public Historique() {
    }



    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }



    public String getAction() {
        return action;
    }


    public void setAction(String action) {
        this.action = action;
    }



    public String getUtilisateur() {
        return utilisateur;
    }


    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }



    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }



    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}