package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.services.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ChambreRestController {

    @Autowired
    private IChambreService chambreService;

}
