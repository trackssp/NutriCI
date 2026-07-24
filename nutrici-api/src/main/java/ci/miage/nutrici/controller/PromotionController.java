package ci.miage.nutrici.controller;


import ci.miage.nutrici.promotion.DemandePromotion;
import ci.miage.nutrici.promotion.Promotion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



@RestController
@RequestMapping("/api/promotions")
@CrossOrigin(origins = "*")
public class PromotionController {



    private final Map<String, Promotion> promotions = new LinkedHashMap<>();






    /*
     * Créer une promotion
     */
    @PostMapping
    public ResponseEntity<Promotion> creer(
            @RequestBody DemandePromotion demande) {



        Promotion promotion = new Promotion();



        promotion.setId(
                "PROMO-" +
                        UUID.randomUUID()
                                .toString()
                                .substring(0,8)
        );



        promotion.setCode(
                demande.getCode()
        );



        promotion.setDescription(
                demande.getDescription()
        );



        promotion.setReduction(
                demande.getReduction()
        );



        promotion.setDateExpiration(
                demande.getDateExpiration()
        );



        promotion.setActive(true);



        promotions.put(
                promotion.getId(),
                promotion
        );



        return ResponseEntity
                .status(201)
                .body(promotion);

    }








    /*
     * Voir toutes les promotions
     */
    @GetMapping
    public List<Promotion> lister(){


        return new ArrayList<>(
                promotions.values()
        );

    }








    /*
     * Consulter une promotion
     */
    @GetMapping("/{id}")
    public ResponseEntity<Promotion> consulter(
            @PathVariable String id) {



        Promotion promotion = promotions.get(id);



        if(promotion == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity.ok(promotion);

    }








    /*
     * Activer / désactiver une promotion
     */
    @PutMapping("/{id}/statut")
    public ResponseEntity<Promotion> changerStatut(
            @PathVariable String id) {



        Promotion promotion = promotions.get(id);



        if(promotion == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        promotion.setActive(
                !promotion.isActive()
        );



        return ResponseEntity.ok(promotion);

    }








    /*
     * Supprimer une promotion
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable String id) {



        Promotion promotion = promotions.remove(id);



        if(promotion == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity
                .noContent()
                .build();

    }








    /*
     * Vérifier un code promotionnel
     */
    @GetMapping("/verification/{code}")
    public ResponseEntity<Promotion> verifierCode(
            @PathVariable String code) {



        for(Promotion promotion : promotions.values()){


            if(
                    promotion.getCode()
                            .equalsIgnoreCase(code)
                            &&
                            promotion.isActive()
            ){

                return ResponseEntity.ok(promotion);

            }

        }



        return ResponseEntity
                .notFound()
                .build();

    }



}