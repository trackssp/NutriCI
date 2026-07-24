package ci.miage.nutrici.stock;


import ci.miage.nutrici.produit.Produit;

import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Service
public class StockService {



    private final List<MouvementStock> mouvements = new ArrayList<>();




    public void retirerStock(
            Produit produit,
            int quantite) {



        if(produit.getStock() < quantite){

            throw new RuntimeException(
                    "Stock insuffisant"
            );

        }



        produit.setStock(
                produit.getStock() - quantite
        );



        MouvementStock mouvement =
                new MouvementStock();


        mouvement.setReferenceProduit(
                produit.getReference()
        );


        mouvement.setType(
                "SORTIE"
        );


        mouvement.setQuantite(
                quantite
        );


        mouvement.setDate(
                LocalDateTime.now()
        );


        mouvements.add(mouvement);

    }





    public List<MouvementStock> historique(){

        return mouvements;

    }


}