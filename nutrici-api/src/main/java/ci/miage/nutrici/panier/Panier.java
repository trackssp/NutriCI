package ci.miage.nutrici.panier;

import java.util.ArrayList;
import java.util.List;

public class Panier {

    private final List<LignePanier> lignes = new ArrayList<>();


    public List<LignePanier> getLignes() {
        return lignes;
    }


    /**
     * Ajouter un produit au panier
     * Si le produit existe déjà, on augmente la quantité
     */
    public void ajouter(LignePanier nouvelle) {

        for (LignePanier ligne : lignes) {

            if (ligne.getReference().equals(nouvelle.getReference())) {

                ligne.setQuantite(
                        ligne.getQuantite() + nouvelle.getQuantite()
                );

                return;
            }
        }

        lignes.add(nouvelle);
    }


    /**
     * Modifier la quantité d'un produit existant
     */
    public boolean modifierQuantite(String reference, int quantite) {

        for (LignePanier ligne : lignes) {

            if (ligne.getReference().equals(reference)) {

                ligne.setQuantite(quantite);
                return true;
            }
        }

        return false;
    }


    /**
     * Supprimer un produit du panier
     */
    public void supprimer(String reference) {

        lignes.removeIf(
                l -> l.getReference().equals(reference)
        );
    }


    /**
     * Calculer le montant total du panier
     */
    public double getTotal() {

        return lignes.stream()
                .mapToDouble(LignePanier::getSousTotal)
                .sum();
    }


    /**
     * Vider le panier
     */
    public void vider() {

        lignes.clear();
    }
}