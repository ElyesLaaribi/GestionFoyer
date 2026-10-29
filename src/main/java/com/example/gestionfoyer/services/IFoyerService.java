package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer save (Foyer foyer);

    public List<Foyer> retrieveAllFoyer();
    public Foyer retrieveFoyer(Long FoyerId);
    public Foyer addFoyer(Foyer f);
    public void removeFoyer(Long FoyerId);
    public Foyer modifyFoyer(Foyer foyer);
}
