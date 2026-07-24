package ci.miage.nutrici.panier;

public class LignePanier {

    private String reference;
    private String nom;
    private double prixUnitaire;
    private int quantite;

    public LignePanier() {
    }

    public LignePanier(String reference, String nom,
                       double prixUnitaire, int quantite) {
        this.reference = reference;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
    }

    public double getSousTotal() {
        return prixUnitaire * quantite;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}