package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.entities.Chambre;
import com.example.gestionfoyer.services.IChambreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Chambre")
@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {

    @Autowired
    private IChambreService chambreService;

    // retrieve all chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return  listChambres;
    }

    // retrieve chambre by ID
    //http://localhost:8089/Gestionfoyer/chambre/retrieve-all-chambres
    @Operation(description = "récupérer toutes les chambres de la base de données")
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId)
    {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }

    // add chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c)
    {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }

    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId)
    {
        chambreService.removeChambre(chId);
    }

    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c)
    {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }
}
