package ci.miage.nutrici.controller;


import ci.miage.nutrici.categorie.Categorie;
import ci.miage.nutrici.categorie.DemandeCategorie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategorieController {



    private final Map<String, Categorie> categories = new LinkedHashMap<>();






    /*
     * Ajouter une catégorie
     */
    @PostMapping
    public ResponseEntity<Categorie> ajouter(
            @RequestBody DemandeCategorie demande) {



        Categorie categorie = new Categorie();



        categorie.setId(
                "CAT-" + UUID.randomUUID()
                        .toString()
                        .substring(0,8)
        );



        categorie.setNom(
                demande.getNom()
        );



        categorie.setDescription(
                demande.getDescription()
        );



        categories.put(
                categorie.getId(),
                categorie
        );



        return ResponseEntity
                .status(201)
                .body(categorie);

    }







    /*
     * Liste toutes les catégories
     */
    @GetMapping
    public List<Categorie> lister(){


        return new ArrayList<>(categories.values());

    }







    /*
     * Consulter une catégorie
     */
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> consulter(
            @PathVariable String id) {



        Categorie categorie = categories.get(id);



        if(categorie == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity.ok(categorie);

    }








    /*
     * Modifier une catégorie
     */
    @PutMapping("/{id}")
    public ResponseEntity<Categorie> modifier(
            @PathVariable String id,
            @RequestBody DemandeCategorie demande) {



        Categorie categorie = categories.get(id);



        if(categorie == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        categorie.setNom(
                demande.getNom()
        );


        categorie.setDescription(
                demande.getDescription()
        );



        return ResponseEntity.ok(categorie);

    }








    /*
     * Supprimer une catégorie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable String id) {



        Categorie categorie = categories.remove(id);



        if(categorie == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity
                .noContent()
                .build();

    }


}