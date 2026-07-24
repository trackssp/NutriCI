package ci.miage.nutrici.service;


import ci.miage.nutrici.commande.Commande;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



@Service
public class CommandeService {


    private final Map<String, Commande> commandes = new LinkedHashMap<>();



    public void ajouter(Commande commande) {

        commandes.put(
                commande.getNumero(),
                commande
        );

    }



    public Commande trouver(String numero) {

        return commandes.get(numero);

    }



    public List<Commande> trouverToutes() {

        return new ArrayList<>(
                commandes.values()
        );

    }



    public boolean existe(String numero) {

        return commandes.containsKey(numero);

    }

}