package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation save (Reservation foyer);
    public List<Reservation> retrieveAllReservation();
    public Reservation retrieveReservation(Long idReservation);
    public Reservation addReservation(Reservation r);
    public void removeReservation(Long idReservation);
    public Reservation modifyReservation(Reservation reservation);
}
