package ci.miage.nutrici.controller;

import ci.miage.nutrici.model.Produit;
import ci.miage.nutrici.repository.ProduitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST de l'API NutriCI.
 * Chaque méthode associe un verbe HTTP à une opération sur les produits.
 */
@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins = "*")
public class ProduitController {

    private final ProduitRepository repo;

    /**
     * Construit le contrôleur avec le repository injecté par Spring.
     *
     * @param repo repository des produits
     */
    public ProduitController(ProduitRepository repo) {
        this.repo = repo;
    }

    /**
     * Liste tous les produits.
     *
     * @return liste des produits en JSON
     */
    @GetMapping
    public List<Produit> listerTous() {
        return repo.findAll();
    }

    /**
     * Recherche un produit avec sa référence.
     *
     * @param ref référence du produit
     * @return 200 avec le produit ou 404
     */
    @GetMapping("/{ref}")
    public ResponseEntity<Produit> trouver(@PathVariable String ref) {
        return repo.findById(ref)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Ajoute un produit.
     *
     * @param produit produit reçu en JSON
     * @return 201 avec le produit ou 400
     */
    @PostMapping
    public ResponseEntity<Produit> ajouter(@RequestBody Produit produit) {
        if (produit.getReference() == null || produit.getPrixUnitaire() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repo.save(produit));
    }

    /**
     * Supprime un produit.
     *
     * @param ref référence du produit
     * @return 204 ou 404
     */
    @DeleteMapping("/{ref}")
    public ResponseEntity<Void> supprimer(@PathVariable String ref) {
        if (!repo.existsById(ref)) {
            return ResponseEntity.notFound().build();
        }

        repo.deleteById(ref);
        return ResponseEntity.noContent().build();
    }

    /**
     * Liste les produits dont le stock est inférieur à 5.
     *
     * @return produits en alerte
     */
    @GetMapping("/alertes")
    public List<Produit> alertes() {
        return repo.findByQteStockLessThan(5);
    }

    /**
     * Recherche les produits par nom.
     *
     * @param q mot recherché
     * @return produits correspondants
     */
    @GetMapping("/recherche")
    public List<Produit> rechercher(@RequestParam String q) {
        return repo.findByNomContainingIgnoreCase(q);
    }
}