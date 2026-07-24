package ci.miage.nutrici.panier;

import java.util.ArrayList;
import java.util.List;

public class Panier {

    private final List<LignePanier> lignes = new ArrayList<>();

    public List<LignePanier> getLignes() {
        return lignes;
    }

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

    public void supprimer(String reference) {

        lignes.removeIf(
                l -> l.getReference().equals(reference)
        );
    }

    public double getTotal() {

        return lignes.stream()
                .mapToDouble(LignePanier::getSousTotal)
                .sum();
    }

    public void vider() {

        lignes.clear();
    }
}