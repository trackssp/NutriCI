package ci.miage.nutrici.commande;

import ci.miage.nutrici.panier.LignePanier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Commande {


    private String numero;

    private String client;

    private String telephone;

    private LocalDateTime date;

    private List<LignePanier> lignes = new ArrayList<>();

    private double total;

    private String statutPaiement;



    public Commande() {
    }



    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }



    public String getClient() {
        return client;
    }


    public void setClient(String client) {
        this.client = client;
    }



    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }



    public List<LignePanier> getLignes() {
        return lignes;
    }


    public void setLignes(List<LignePanier> lignes) {
        this.lignes = lignes;
    }



    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }



    public String getStatutPaiement() {
        return statutPaiement;
    }


    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

}