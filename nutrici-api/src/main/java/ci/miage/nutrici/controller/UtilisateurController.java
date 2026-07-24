package ci.miage.nutrici.controller;


import ci.miage.nutrici.utilisateur.Utilisateur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "*")
public class UtilisateurController {


    private final Map<String, Utilisateur> utilisateurs =
            new LinkedHashMap<>();



    @PostMapping
    public ResponseEntity<Utilisateur> creer(
            @RequestBody Utilisateur utilisateur
    ) {


        String id = UUID.randomUUID().toString();


        utilisateur.setId(id);



        if(utilisateur.getRole() == null
                || utilisateur.getRole().isEmpty()) {

            utilisateur.setRole("CLIENT");
        }



        utilisateurs.put(
                id,
                utilisateur
        );



        return ResponseEntity
                .status(201)
                .body(utilisateur);

    }





    @GetMapping
    public ResponseEntity<List<Utilisateur>> lister() {


        return ResponseEntity.ok(
                new ArrayList<>(utilisateurs.values())
        );

    }







    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> consulter(
            @PathVariable String id
    ) {


        Utilisateur utilisateur =
                utilisateurs.get(id);



        if(utilisateur == null) {

            return ResponseEntity
                    .notFound()
                    .build();
        }



        return ResponseEntity.ok(utilisateur);

    }







    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> modifier(
            @PathVariable String id,
            @RequestBody Utilisateur modification
    ) {


        Utilisateur utilisateur =
                utilisateurs.get(id);



        if(utilisateur == null) {

            return ResponseEntity
                    .notFound()
                    .build();
        }



        utilisateur.setNom(
                modification.getNom()
        );


        utilisateur.setEmail(
                modification.getEmail()
        );


        utilisateur.setTelephone(
                modification.getTelephone()
        );


        utilisateur.setMotDePasse(
                modification.getMotDePasse()
        );



        return ResponseEntity.ok(utilisateur);

    }







    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable String id
    ) {


        if(!utilisateurs.containsKey(id)) {

            return ResponseEntity
                    .notFound()
                    .build();
        }



        utilisateurs.remove(id);



        return ResponseEntity
                .noContent()
                .build();

    }

}