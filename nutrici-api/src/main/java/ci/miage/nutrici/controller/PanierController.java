package ci.miage.nutrici.controller;

import ci.miage.nutrici.panier.LignePanier;
import ci.miage.nutrici.panier.Panier;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/panier")
@CrossOrigin(origins = "*")
public class PanierController {

    private final Panier panier = new Panier();


    /**
     * Consulter le panier actuel
     */
    @GetMapping
    public Panier consulter() {
        return panier;
    }


    /**
     * Ajouter un produit au panier
     */
    @PostMapping
    public ResponseEntity<Panier> ajouter(
            @RequestBody LignePanier ligne) {

        if (ligne.getReference() == null ||
                ligne.getQuantite() <= 0) {

            return ResponseEntity.badRequest().build();
        }

        panier.ajouter(ligne);

        return ResponseEntity
                .status(201)
                .body(panier);
    }


    /**
     * Modifier la quantité d'un produit
     */
    @PutMapping("/{reference}")
    public ResponseEntity<Panier> modifierQuantite(
            @PathVariable String reference,
            @RequestBody Map<String, Integer> body) {


        Integer quantite = body.get("quantite");


        if (quantite == null || quantite <= 0) {
            return ResponseEntity.badRequest().build();
        }


        boolean modifie = panier.modifierQuantite(
                reference,
                quantite
        );


        if (!modifie) {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(panier);
    }


    /**
     * Supprimer un produit du panier
     */
    @DeleteMapping("/{reference}")
    public ResponseEntity<Void> supprimer(
            @PathVariable String reference) {


        panier.supprimer(reference);

        return ResponseEntity.noContent().build();
    }


    /**
     * Vider complètement le panier
     */
    @DeleteMapping
    public ResponseEntity<Void> vider() {

        panier.vider();

        return ResponseEntity.noContent().build();
    }


    /**
     * Obtenir uniquement le total
     */
    @GetMapping("/total")
    public Map<String, Double> total() {

        return Map.of(
                "total",
                panier.getTotal()
        );
    }
}