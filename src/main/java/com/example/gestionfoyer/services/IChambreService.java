package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre save (Chambre chambre);

    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
}
