package ci.miage.nutrici.stock;


import java.time.LocalDateTime;


public class MouvementStock {


    private String referenceProduit;

    private String type;

    private int quantite;

    private LocalDateTime date;



    public MouvementStock() {
    }



    public String getReferenceProduit() {
        return referenceProduit;
    }


    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }



    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }



    public int getQuantite() {
        return quantite;
    }


    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }



    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}