package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.entities.Etudiant;
import com.example.gestionfoyer.services.IEtudiantService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private IEtudiantService etudiantService;

    @GetMapping("/retrieve-all-etudiant")
    public List<Etudiant> getEtudiant(){
        List<Etudiant> listEtudiant = etudiantService.retrieveAllEtudiant();
        return listEtudiant;
    }

    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long eId){
        Etudiant etudiant = etudiantService.retrieveEtudiant(eId);
        return etudiant;
    }

    @PostMapping("add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return etudiantService.addEtudiant(e);
    }

    @DeleteMapping("/remove-foyer/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long eId){
        etudiantService.removeEtudiant(eId);
    }

    @PutMapping("/modify-foyer")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e){
        Etudiant etudiant = etudiantService.modifyEtudiant(e);
        return etudiant;
    }
}