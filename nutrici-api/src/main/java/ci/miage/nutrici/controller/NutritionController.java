package ci.miage.nutrici.controller;


import ci.miage.nutrici.nutrition.DemandeNutrition;
import ci.miage.nutrici.nutrition.ProfilNutritionnel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;



@RestController
@RequestMapping("/api/nutrition")
@CrossOrigin(origins = "*")
public class NutritionController {



    private final Map<String, ProfilNutritionnel> profils = new LinkedHashMap<>();





    /*
     * Créer un profil nutritionnel
     */
    @PostMapping
    public ResponseEntity<ProfilNutritionnel> creer(
            @RequestBody DemandeNutrition demande) {



        ProfilNutritionnel profil = new ProfilNutritionnel();



        profil.setId(
                "NUT-" + UUID.randomUUID()
                        .toString()
                        .substring(0,8)
        );



        profil.setUtilisateur(
                demande.getUtilisateur()
        );



        profil.setObjectif(
                demande.getObjectif()
        );



        profil.setAllergies(
                demande.getAllergies()
        );



        profil.setPreferences(
                demande.getPreferences()
        );



        profils.put(
                profil.getId(),
                profil
        );



        return ResponseEntity
                .status(201)
                .body(profil);

    }






    /*
     * Consulter le profil d'un utilisateur
     */
    @GetMapping("/utilisateur/{nom}")
    public ResponseEntity<ProfilNutritionnel> consulter(
            @PathVariable String nom) {



        for(ProfilNutritionnel profil : profils.values()){


            if(profil.getUtilisateur()
                    .equals(nom)){


                return ResponseEntity.ok(profil);

            }

        }



        return ResponseEntity
                .notFound()
                .build();

    }







    /*
     * Modifier un profil nutritionnel
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProfilNutritionnel> modifier(
            @PathVariable String id,
            @RequestBody DemandeNutrition demande) {



        ProfilNutritionnel profil = profils.get(id);



        if(profil == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        profil.setObjectif(
                demande.getObjectif()
        );


        profil.setAllergies(
                demande.getAllergies()
        );


        profil.setPreferences(
                demande.getPreferences()
        );



        return ResponseEntity.ok(profil);

    }






    /*
     * Supprimer un profil
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable String id) {



        ProfilNutritionnel profil = profils.remove(id);



        if(profil == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity
                .noContent()
                .build();

    }


}