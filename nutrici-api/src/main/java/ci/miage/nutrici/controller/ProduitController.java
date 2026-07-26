package ci.miage.nutrici.controller;

import ci.miage.nutrici.model.Produit;
import ci.miage.nutrici.repository.ProduitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins = "*")
public class ProduitController {

    private static final String TOKEN_ADMIN = "TOKEN-NUTRICI-ADMIN";
    private final ProduitRepository repo;

    public ProduitController(ProduitRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Produit> listerTous() {
        return repo.findAll();
    }

    @GetMapping("/{ref}")
    public ResponseEntity<Produit> trouver(@PathVariable String ref) {
        return repo.findById(ref)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produit> ajouter(
            @RequestHeader(value = "X-Auth-Token", required = false) String token,
            @RequestBody Produit produit) {
        if (!estAdmin(token)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        if (!estValide(produit) || repo.existsById(produit.getReference())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(produit));
    }

    @PutMapping("/{ref}")
    public ResponseEntity<Produit> modifier(
            @RequestHeader(value = "X-Auth-Token", required = false) String token,
            @PathVariable String ref,
            @RequestBody Produit donnees) {
        if (!estAdmin(token)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        if (!estValide(donnees)) {
            return ResponseEntity.badRequest().build();
        }
        return repo.findById(ref).map(produit -> {
            produit.setNom(donnees.getNom());
            produit.setCategorie(donnees.getCategorie());
            produit.setPrixUnitaire(donnees.getPrixUnitaire());
            produit.setQteStock(donnees.getQteStock());
            return ResponseEntity.ok(repo.save(produit));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{ref}")
    public ResponseEntity<Void> supprimer(
            @RequestHeader(value = "X-Auth-Token", required = false) String token,
            @PathVariable String ref) {
        if (!estAdmin(token)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        if (!repo.existsById(ref)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(ref);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/alertes")
    public List<Produit> alertes() {
        return repo.findByQteStockLessThan(5);
    }

    @GetMapping("/recherche")
    public List<Produit> rechercher(@RequestParam String q) {
        return repo.findByNomContainingIgnoreCase(q);
    }

    private boolean estAdmin(String token) {
        return TOKEN_ADMIN.equals(token);
    }

    private boolean estValide(Produit produit) {
        return produit != null
                && produit.getReference() != null
                && !produit.getReference().isBlank()
                && produit.getNom() != null
                && !produit.getNom().isBlank()
                && produit.getCategorie() != null
                && !produit.getCategorie().isBlank()
                && produit.getPrixUnitaire() > 0
                && produit.getQteStock() >= 0;
    }
}
