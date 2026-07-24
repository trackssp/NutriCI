package ci.miage.nutrici.produit;

public class Produit {

    private String reference;

    private String nom;

    private String description;

    private String categorie;

    private double prixUnitaire;

    private int stock;



    public Produit() {
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



    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }



    public String getCategorie() {
        return categorie;
    }


    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }



    public double getPrixUnitaire() {
        return prixUnitaire;
    }


    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }



    public int getStock() {
        return stock;
    }


    public void setStock(int stock) {
        this.stock = stock;
    }

}