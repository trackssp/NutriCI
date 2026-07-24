package ci.miage.nutrici.paiement;


import java.time.LocalDateTime;


public class Paiement {


    private String id;

    private String numeroCommande;

    private double montant;

    private String methode;

    private String statut;

    private LocalDateTime date;



    public Paiement() {
    }



    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }



    public String getNumeroCommande() {
        return numeroCommande;
    }


    public void setNumeroCommande(String numeroCommande) {
        this.numeroCommande = numeroCommande;
    }



    public double getMontant() {
        return montant;
    }


    public void setMontant(double montant) {
        this.montant = montant;
    }



    public String getMethode() {
        return methode;
    }


    public void setMethode(String methode) {
        this.methode = methode;
    }



    public String getStatut() {
        return statut;
    }


    public void setStatut(String statut) {
        this.statut = statut;
    }



    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}