package ci.miage.nutrici.favoris;


import java.time.LocalDateTime;


public class Favori {


    private String id;

    private String utilisateur;

    private String referenceProduit;

    private LocalDateTime dateAjout;



    public Favori() {
    }



    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }



    public String getUtilisateur() {
        return utilisateur;
    }


    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }



    public String getReferenceProduit() {
        return referenceProduit;
    }


    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }



    public LocalDateTime getDateAjout() {
        return dateAjout;
    }


    public void setDateAjout(LocalDateTime dateAjout) {
        this.dateAjout = dateAjout;
    }

}