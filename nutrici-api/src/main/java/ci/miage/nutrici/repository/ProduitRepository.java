package ci.miage.nutrici.repository;

import ci.miage.nutrici.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Accès aux produits enregistrés dans la base de données.
 */
@Repository
public interface ProduitRepository extends JpaRepository<Produit, String> {

    /**
     * Recherche les produits dont le stock est inférieur au seuil.
     *
     * @param seuil seuil de stock
     * @return produits dont le stock est bas
     */
    List<Produit> findByQteStockLessThan(int seuil);

    /**
     * Recherche les produits par nom sans tenir compte de la casse.
     *
     * @param mot mot recherché
     * @return produits correspondants
     */
    List<Produit> findByNomContainingIgnoreCase(String mot);
    List<Produit> findByCategorieIgnoreCase(String categorie);}