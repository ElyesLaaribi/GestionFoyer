package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.entities.Universite;
import com.example.gestionfoyer.services.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    @Autowired
    private IUniversiteService universiteService;

    @GetMapping("/retrieve-all-universite")
    public List<Universite> getUniversite(){
        List<Universite> listUniversite = universiteService.retrieveAllUniversite();
        return listUniversite;
    }

    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }

    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long UniversiteId){
        universiteService.removeUniversite(UniversiteId);
    }

    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite u){
        Universite universite = universiteService.modifyUniversite(u);
        return universite;
    }

    @PostMapping("/affecterFoyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(
            @PathVariable("idFoyer") Long idFoyer,
            @PathVariable("nomUniversite") String nomUniversite
    )
    {
        Universite universite = universiteService
                .affecterFoyerAUniversite(idFoyer, nomUniversite);
        return  universite;
    }

    @PutMapping("/desaffecterFoyer/{universite-id}")
    public Universite desaffecterFoyerAUniversite(
            @PathVariable("universite-id") long universiteId
    ) {
        Universite universite =  universiteService
                .desaffecterFoyerAUniversite(universiteId);
        return universite;
    }

}
