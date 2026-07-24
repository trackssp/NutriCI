package ci.miage.nutrici.controller;


import ci.miage.nutrici.statistique.Statistique;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/statistiques")
@CrossOrigin(origins = "*")
public class StatistiqueController {



    @GetMapping
    public Statistique obtenirStatistiques(){


        Statistique statistique = new Statistique();



        /*
         * Valeurs temporaires.
         * Elles seront remplacées ensuite
         * par les vraies données de la base.
         */


        statistique.setNombreProduits(0);

        statistique.setNombreCommandes(0);

        statistique.setNombrePaiements(0);

        statistique.setChiffreAffaires(0);



        return statistique;

    }


}