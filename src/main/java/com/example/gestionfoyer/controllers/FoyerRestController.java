package com.example.gestionfoyer.controllers;


import com.example.gestionfoyer.entities.Foyer;
import com.example.gestionfoyer.services.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController @AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {

    @Autowired
    private IFoyerService foyerService;

    @GetMapping("/retrieve-all-foyer")
    public List<Foyer> getFoyer(){
        List<Foyer> listFoyer = foyerService.retrieveAllFoyer();
        return listFoyer;
    }

    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long fId){
        Foyer foyer = foyerService.retrieveFoyer(fId);
        return foyer;
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return foyerService.addFoyer(f);
    }

    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long fId){
        foyerService.removeFoyer(fId);
    }

    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer f){
        Foyer foyer = foyerService.modifyFoyer(f);
        return foyer;
    }



}
