package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant save (Etudiant etudiant);
    public List<Etudiant> retrieveAllEtudiant();
    public Etudiant retrieveEtudiant(Long idEtudiant);
    public Etudiant addEtudiant(Etudiant e);
    public void removeEtudiant(Long idEtudiant);
    public Etudiant modifyEtudiant(Etudiant etudiant);
}
