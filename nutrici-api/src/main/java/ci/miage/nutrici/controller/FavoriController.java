package ci.miage.nutrici.controller;


import ci.miage.nutrici.favoris.DemandeFavori;
import ci.miage.nutrici.favoris.Favori;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



@RestController
@RequestMapping("/api/favoris")
@CrossOrigin(origins = "*")
public class FavoriController {



    private final Map<String, Favori> favoris = new LinkedHashMap<>();





    /*
     * Ajouter un produit aux favoris
     */
    @PostMapping
    public ResponseEntity<Favori> ajouter(
            @RequestBody DemandeFavori demande) {



        Favori favori = new Favori();



        favori.setId(
                "FAV-" + UUID.randomUUID()
                        .toString()
                        .substring(0,8)
        );



        favori.setUtilisateur(
                demande.getUtilisateur()
        );



        favori.setReferenceProduit(
                demande.getReferenceProduit()
        );



        favori.setDateAjout(
                LocalDateTime.now()
        );



        favoris.put(
                favori.getId(),
                favori
        );



        return ResponseEntity
                .status(201)
                .body(favori);
    }






    /*
     * Voir tous les favoris
     */
    @GetMapping
    public List<Favori> tousLesFavoris(){

        return new ArrayList<>(favoris.values());

    }






    /*
     * Voir les favoris d'un utilisateur
     */
    @GetMapping("/utilisateur/{nom}")
    public List<Favori> favorisUtilisateur(
            @PathVariable String nom) {



        List<Favori> resultat = new ArrayList<>();



        for(Favori f : favoris.values()){


            if(f.getUtilisateur()
                    .equals(nom)){


                resultat.add(f);

            }

        }



        return resultat;
    }







    /*
     * Supprimer un favori
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable String id) {



        Favori favori = favoris.remove(id);



        if(favori == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity
                .noContent()
                .build();

    }

}