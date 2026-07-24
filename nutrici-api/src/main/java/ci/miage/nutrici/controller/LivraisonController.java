package ci.miage.nutrici.controller;

import ci.miage.nutrici.livraison.DemandeLivraison;
import ci.miage.nutrici.livraison.Livraison;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/api/livraisons")
@CrossOrigin(origins = "*")
public class LivraisonController {


    private final Map<String, Livraison> livraisons = new LinkedHashMap<>();


    /*
     * Créer une livraison
     */
    @PostMapping
    public ResponseEntity<Livraison> creer(
            @RequestBody DemandeLivraison demande) {


        Livraison livraison = new Livraison();


        livraison.setId(
                "LIV-" + UUID.randomUUID()
                        .toString()
                        .substring(0,8)
        );


        livraison.setNumeroCommande(
                demande.getNumeroCommande()
        );


        livraison.setClient(
                demande.getClient()
        );


        livraison.setAdresse(
                demande.getAdresse()
        );


        livraison.setTelephone(
                demande.getTelephone()
        );


        livraison.setStatut(
                "EN_PREPARATION"
        );


        livraison.setDateCreation(
                LocalDateTime.now()
        );


        livraisons.put(
                livraison.getId(),
                livraison
        );


        return ResponseEntity
                .status(201)
                .body(livraison);
    }




    /*
     * Consulter une livraison
     */
    @GetMapping("/{id}")
    public ResponseEntity<Livraison> consulter(
            @PathVariable String id) {


        Livraison livraison = livraisons.get(id);


        if(livraison == null){
            return ResponseEntity
                    .notFound()
                    .build();
        }


        return ResponseEntity.ok(livraison);
    }





    /*
     * Modifier le statut de livraison
     */
    @PutMapping("/{id}/statut")
    public ResponseEntity<Livraison> modifierStatut(
            @PathVariable String id,
            @RequestParam String statut) {


        Livraison livraison = livraisons.get(id);


        if(livraison == null){
            return ResponseEntity
                    .notFound()
                    .build();
        }


        livraison.setStatut(statut);


        return ResponseEntity.ok(livraison);
    }





    /*
     * Supprimer une livraison
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable String id) {


        Livraison livraison = livraisons.remove(id);


        if(livraison == null){
            return ResponseEntity
                    .notFound()
                    .build();
        }


        return ResponseEntity
                .noContent()
                .build();
    }



}