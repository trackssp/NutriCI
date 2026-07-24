package ci.miage.nutrici.controller;


import ci.miage.nutrici.historique.Historique;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



@RestController
@RequestMapping("/api/historique")
@CrossOrigin(origins = "*")
public class HistoriqueController {



    private final Map<String, Historique> historiques =
            new LinkedHashMap<>();







    /*
     * Ajouter une action dans l'historique
     */
    @PostMapping
    public ResponseEntity<Historique> ajouter(
            @RequestBody Historique historique) {



        historique.setId(
                "HIST-" +
                        UUID.randomUUID()
                                .toString()
                                .substring(0,8)
        );



        historique.setDate(
                LocalDateTime.now()
        );



        historiques.put(
                historique.getId(),
                historique
        );



        return ResponseEntity
                .status(201)
                .body(historique);

    }








    /*
     * Consulter tout l'historique
     */
    @GetMapping
    public List<Historique> lister(){


        return new ArrayList<>(
                historiques.values()
        );

    }








    /*
     * Consulter une entrée historique
     */
    @GetMapping("/{id}")
    public ResponseEntity<Historique> consulter(
            @PathVariable String id) {



        Historique historique =
                historiques.get(id);



        if(historique == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity.ok(historique);

    }








    /*
     * Supprimer une entrée
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable String id) {



        Historique historique =
                historiques.remove(id);



        if(historique == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity
                .noContent()
                .build();

    }



}