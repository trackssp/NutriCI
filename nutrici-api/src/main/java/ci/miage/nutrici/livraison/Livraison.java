package ci.miage.nutrici.livraison;

import java.time.LocalDateTime;

public class Livraison {

    private String id;

    private String numeroCommande;

    private String client;

    private String adresse;

    private String telephone;

    private String statut;

    private LocalDateTime dateCreation;



    public Livraison() {
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



    public String getClient() {
        return client;
    }


    public void setClient(String client) {
        this.client = client;
    }



    public String getAdresse() {
        return adresse;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public String getStatut() {
        return statut;
    }


    public void setStatut(String statut) {
        this.statut = statut;
    }



    public LocalDateTime getDateCreation() {
        return dateCreation;
    }


    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
}