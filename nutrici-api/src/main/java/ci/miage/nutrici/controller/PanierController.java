package ci.miage.nutrici.controller;

import ci.miage.nutrici.panier.LignePanier;
import ci.miage.nutrici.panier.Panier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/panier")
public class PanierController {

    private final Panier panier = new Panier();

    @GetMapping
    public Panier consulter() {
        return panier;
    }

    @PostMapping
    public ResponseEntity<Panier> ajouter(
            @RequestBody LignePanier ligne) {

        if (ligne.getQuantite() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        panier.ajouter(ligne);

        return ResponseEntity
                .status(201)
                .body(panier);
    }

    @DeleteMapping("/{reference}")
    public ResponseEntity<Void> supprimer(
            @PathVariable String reference) {

        panier.supprimer(reference);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> vider() {

        panier.vider();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total")
    public Map<String, Double> total() {

        return Map.of(
                "total",
                panier.getTotal()
        );
    }
}