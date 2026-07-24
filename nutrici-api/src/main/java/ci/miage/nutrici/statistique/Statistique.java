package ci.miage.nutrici.statistique;


public class Statistique {


    private int nombreProduits;

    private int nombreCommandes;

    private int nombrePaiements;

    private double chiffreAffaires;



    public Statistique() {
    }



    public int getNombreProduits() {
        return nombreProduits;
    }


    public void setNombreProduits(int nombreProduits) {
        this.nombreProduits = nombreProduits;
    }



    public int getNombreCommandes() {
        return nombreCommandes;
    }


    public void setNombreCommandes(int nombreCommandes) {
        this.nombreCommandes = nombreCommandes;
    }



    public int getNombrePaiements() {
        return nombrePaiements;
    }


    public void setNombrePaiements(int nombrePaiements) {
        this.nombrePaiements = nombrePaiements;
    }



    public double getChiffreAffaires() {
        return chiffreAffaires;
    }


    public void setChiffreAffaires(double chiffreAffaires) {
        this.chiffreAffaires = chiffreAffaires;
    }

}