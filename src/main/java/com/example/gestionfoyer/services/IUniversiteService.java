package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite save (Universite universite);

    public List<Universite> retrieveAllUniversite();
    public Universite retrieveUniversite(Long UniversiteId);
    public Universite addUniversite(Universite u);
    public void removeUniversite(Long UniversiteId);
    public Universite modifyUniversite(Universite universite);
}
