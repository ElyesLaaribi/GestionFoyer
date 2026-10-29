package com.example.gestionfoyer.controllers;


import com.example.gestionfoyer.entities.Bloc;
import com.example.gestionfoyer.services.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController @AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {

    @Autowired
    private IBlocService blocService;

    //retrieve all blocs
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }

    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long BId)
    {
        Bloc bloc = blocService.retrieveBloc(BId);
        return bloc;
    }

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b)
    {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long BId)
    {
        blocService.removeBloc(BId);
    }

    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b)
    {
        Bloc bloc = blocService.modifyBloc(b);
        return bloc;
    }

}
