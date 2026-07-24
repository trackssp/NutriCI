package ci.miage.nutrici.livraison;


public class DemandeLivraison {


    private String numeroCommande;

    private String client;

    private String adresse;

    private String telephone;



    public DemandeLivraison() {
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

}