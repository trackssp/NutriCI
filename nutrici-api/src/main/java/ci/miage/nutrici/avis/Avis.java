package ci.miage.nutrici.avis;

import java.time.LocalDateTime;


public class Avis {


    private String id;

    private String referenceProduit;

    private String client;

    private int note;

    private String commentaire;

    private LocalDateTime date;



    public Avis() {
    }



    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }



    public String getReferenceProduit() {
        return referenceProduit;
    }


    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }



    public String getClient() {
        return client;
    }


    public void setClient(String client) {
        this.client = client;
    }



    public int getNote() {
        return note;
    }


    public void setNote(int note) {
        this.note = note;
    }



    public String getCommentaire() {
        return commentaire;
    }


    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }



    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}