package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.entities.Foyer;
import com.example.gestionfoyer.entities.Reservation;
import com.example.gestionfoyer.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    @Autowired
    private IReservationService reservationService;

    @GetMapping("/retrieve-all-reservation")
    public List<Reservation> getReservation(){
        List<Reservation> listReservation = reservationService.retrieveAllReservation();
        return listReservation;
    }

    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long rId){
        Reservation reservation = reservationService.retrieveReservation(rId);
        return reservation;
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r){
        return reservationService.addReservation(r);
    }

    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long rId){
        reservationService.removeReservation(rId);
    }

    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r){
        Reservation reservation = reservationService.modifyReservation(r);
        return reservation;
    }

}

