package ci.miage.nutrici.controller;



import ci.miage.nutrici.stock.MouvementStock;
import ci.miage.nutrici.stock.StockService;


import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins="*")
public class StockController {



    private final StockService service;



    public StockController(
            StockService service){

        this.service = service;

    }





    @GetMapping
    public List<MouvementStock> historique(){

        return service.historique();

    }


}