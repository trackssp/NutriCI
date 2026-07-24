package ci.miage.nutrici.model;

import jakarta.persistence.*;

/**
 * Entité JPA représentant un complément alimentaire.
 * Hibernate mappe cette classe vers la table {@code produit} dans MySQL.
 *
 * @author Équipe NutriCI
 * @version 1.0
 */
@Entity
@Table(name = "produit")
public class Produit {

    /** Identifiant unique du produit, composé de 6 caractères. */
    @Id
    @Column(length = 6)
    private String reference;

    /** Nom commercial du complément alimentaire. */
    @Column(nullable = false, length = 100)
    private String nom;

    /** Prix unitaire en FCFA. */
    @Column(name = "prix_unitaire", nullable = false)
    private double prixUnitaire;

    /** Quantité actuellement en stock. */
    @Column(name = "qte_stock", nullable = false)
    private int qteStock;

    /** Constructeur vide requis par JPA. */
    public Produit() {
    }

    /**
     * Construit un produit complet.
     *
     * @param reference référence du produit
     * @param nom nom commercial
     * @param prixUnitaire prix en FCFA
     * @param qteStock quantité disponible
     */
    public Produit(String reference, String nom, double prixUnitaire, int qteStock) {
        this.reference = reference;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.qteStock = qteStock;
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

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    /**
     * Indique si le stock est inférieur à 5.
     *
     * @return true lorsque le stock est bas
     */
    public boolean isStockBas() {
        return qteStock < 5;
    }
}