package ci.miage.nutrici.controller;


import ci.miage.nutrici.commande.Commande;
import ci.miage.nutrici.commande.DemandeCommande;
import ci.miage.nutrici.panier.Panier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api/commandes")
@CrossOrigin(origins = "*")
public class CommandeController {



    private final Map<String, Commande> commandes =
            new LinkedHashMap<>();


    private final Panier panier;



    public CommandeController(
            PanierController panierController) {

        this.panier = panierController.consulter();

    }





    /**
     * Création d'une commande
     */
    @PostMapping
    public ResponseEntity<Commande> creer(
            @RequestBody DemandeCommande demande) {



        if(panier.getLignes().isEmpty()){

            return ResponseEntity
                    .badRequest()
                    .build();

        }




        Commande commande = new Commande();



        commande.setNumero(
                "CMD-" + System.currentTimeMillis()
        );



        commande.setClient(
                demande.getClient()
        );



        commande.setTelephone(
                demande.getTelephone()
        );



        commande.setDate(
                LocalDateTime.now()
        );



        commande.setLignes(
                new ArrayList<>(panier.getLignes())
        );



        commande.setTotal(
                panier.getTotal()
        );



        commande.setStatutPaiement(
                "EN_ATTENTE_PAIEMENT"
        );



        commandes.put(
                commande.getNumero(),
                commande
        );



        panier.vider();



        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(commande);

    }







    /**
     * Liste toutes les commandes
     */
    @GetMapping
    public ResponseEntity<List<Commande>> toutesLesCommandes(){


        return ResponseEntity.ok(
                new ArrayList<>(commandes.values())
        );

    }







    /**
     * Consulter une commande
     */
    @GetMapping("/{numero}")
    public ResponseEntity<Commande> consulter(
            @PathVariable String numero){



        Commande commande =
                commandes.get(numero);



        if(commande == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity.ok(commande);

    }







    /**
     * Modifier le statut paiement
     */
    @PutMapping("/{numero}/payer")
    public ResponseEntity<Commande> payer(
            @PathVariable String numero){



        Commande commande =
                commandes.get(numero);



        if(commande == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        commande.setStatutPaiement(
                "PAYEE"
        );



        return ResponseEntity.ok(commande);

    }







    /**
     * Mettre la commande en préparation
     */
    @PutMapping("/{numero}/preparation")
    public ResponseEntity<Commande> preparation(
            @PathVariable String numero){



        Commande commande =
                commandes.get(numero);



        if(commande == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        commande.setStatutPaiement(
                "EN_PREPARATION"
        );



        return ResponseEntity.ok(commande);

    }







    /**
     * Expédier une commande
     */
    @PutMapping("/{numero}/expedition")
    public ResponseEntity<Commande> expedition(
            @PathVariable String numero){



        Commande commande =
                commandes.get(numero);



        if(commande == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        commande.setStatutPaiement(
                "EXPEDIEE"
        );



        return ResponseEntity.ok(commande);

    }







    /**
     * Livrer une commande
     */
    @PutMapping("/{numero}/livraison")
    public ResponseEntity<Commande> livraison(
            @PathVariable String numero){



        Commande commande =
                commandes.get(numero);



        if(commande == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        commande.setStatutPaiement(
                "LIVREE"
        );



        return ResponseEntity.ok(commande);

    }







    /**
     * Annuler une commande
     */
    @PutMapping("/{numero}/annuler")
    public ResponseEntity<Commande> annuler(
            @PathVariable String numero){



        Commande commande =
                commandes.get(numero);



        if(commande == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        commande.setStatutPaiement(
                "ANNULEE"
        );



        return ResponseEntity.ok(commande);

    }







    /**
     * Génération d'un bon de livraison simple
     */
    @GetMapping("/{numero}/bon-livraison")
    public ResponseEntity<String> bonLivraison(
            @PathVariable String numero){



        Commande commande =
                commandes.get(numero);



        if(commande == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        String bon =

                "BON DE LIVRAISON\n\n" +

                        "Commande : "
                        + commande.getNumero()
                        + "\nClient : "
                        + commande.getClient()

                        + "\nTéléphone : "
                        + commande.getTelephone()

                        + "\nTotal : "
                        + commande.getTotal()
                        + " FCFA"

                        + "\nStatut : "
                        + commande.getStatutPaiement();



        return ResponseEntity.ok(bon);

    }


}