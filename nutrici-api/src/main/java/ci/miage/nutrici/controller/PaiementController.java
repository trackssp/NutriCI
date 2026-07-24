package ci.miage.nutrici.controller;

import ci.miage.nutrici.paiement.Paiement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    private final Map<String, Paiement> paiements = new LinkedHashMap<>();


    @PostMapping
    public ResponseEntity<Paiement> effectuerPaiement(
            @RequestBody Paiement paiement) {


        paiement.setId(
                UUID.randomUUID().toString()
        );


        paiement.setDate(
                LocalDateTime.now()
        );


        if (paiement.getMethode() == null || paiement.getMethode().isEmpty()) {
            paiement.setMethode("MOBILE_MONEY");
        }


        paiement.setStatut(
                "REUSSI"
        );


        paiements.put(
                paiement.getId(),
                paiement
        );


        return ResponseEntity
                .status(201)
                .body(paiement);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Paiement> consulterPaiement(
            @PathVariable String id) {


        Paiement paiement = paiements.get(id);


        if (paiement == null) {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(paiement);
    }



    @GetMapping("/commande/{numeroCommande}")
    public ResponseEntity<Paiement> rechercherParCommande(
            @PathVariable String numeroCommande) {


        for (Paiement paiement : paiements.values()) {

            if (paiement.getNumeroCommande()
                    .equals(numeroCommande)) {

                return ResponseEntity.ok(paiement);
            }
        }


        return ResponseEntity.notFound().build();
    }



    @PutMapping("/{id}/annuler")
    public ResponseEntity<Paiement> annulerPaiement(
            @PathVariable String id) {


        Paiement paiement = paiements.get(id);


        if (paiement == null) {
            return ResponseEntity.notFound().build();
        }


        paiement.setStatut(
                "ANNULE"
        );


        return ResponseEntity.ok(paiement);
    }

}