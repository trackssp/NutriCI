package ci.miage.nutrici.avis;


public class DemandeAvis {


    private String referenceProduit;

    private String client;

    private int note;

    private String commentaire;



    public DemandeAvis() {
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

}