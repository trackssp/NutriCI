package ci.miage.nutrici.controller;


import ci.miage.nutrici.avis.Avis;
import ci.miage.nutrici.avis.DemandeAvis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



@RestController
@RequestMapping("/api/avis")
@CrossOrigin(origins = "*")
public class AvisController {


    private final Map<String, Avis> avis = new LinkedHashMap<>();



    /*
     * Ajouter un avis
     */
    @PostMapping
    public ResponseEntity<Avis> ajouter(
            @RequestBody DemandeAvis demande) {


        if(demande.getNote() < 1 || demande.getNote() > 5){

            return ResponseEntity
                    .badRequest()
                    .build();
        }



        Avis nouvelAvis = new Avis();


        nouvelAvis.setId(
                "AV-" + UUID.randomUUID()
                        .toString()
                        .substring(0,8)
        );


        nouvelAvis.setReferenceProduit(
                demande.getReferenceProduit()
        );


        nouvelAvis.setClient(
                demande.getClient()
        );


        nouvelAvis.setNote(
                demande.getNote()
        );


        nouvelAvis.setCommentaire(
                demande.getCommentaire()
        );


        nouvelAvis.setDate(
                LocalDateTime.now()
        );



        avis.put(
                nouvelAvis.getId(),
                nouvelAvis
        );


        return ResponseEntity
                .status(201)
                .body(nouvelAvis);
    }





    /*
     * Voir tous les avis
     */
    @GetMapping
    public List<Avis> tousLesAvis(){

        return new ArrayList<>(avis.values());

    }





    /*
     * Voir les avis d'un produit
     */
    @GetMapping("/produit/{reference}")
    public List<Avis> avisProduit(
            @PathVariable String reference){


        List<Avis> resultat = new ArrayList<>();


        for(Avis a : avis.values()){


            if(a.getReferenceProduit()
                    .equals(reference)){


                resultat.add(a);
            }

        }


        return resultat;
    }





    /*
     * Calculer la moyenne des notes d'un produit
     */
    @GetMapping("/produit/{reference}/moyenne")
    public ResponseEntity<Double> moyenne(
            @PathVariable String reference){



        int total = 0;

        int nombre = 0;



        for(Avis a : avis.values()){


            if(a.getReferenceProduit()
                    .equals(reference)){


                total += a.getNote();

                nombre++;
            }

        }



        if(nombre == 0){

            return ResponseEntity.ok(0.0);

        }



        return ResponseEntity.ok(
                (double) total / nombre
        );

    }





    /*
     * Supprimer un avis
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable String id){



        Avis supprimer = avis.remove(id);



        if(supprimer == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity
                .noContent()
                .build();

    }


}