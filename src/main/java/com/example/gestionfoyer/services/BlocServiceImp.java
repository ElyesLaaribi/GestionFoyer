package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Bloc;
import com.example.gestionfoyer.entities.Chambre;
import com.example.gestionfoyer.repositories.BlocRepository;
import com.example.gestionfoyer.repositories.ChambreRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
@Service
public class BlocServiceImp implements IBlocService{
    @Autowired
    private BlocRepository blocRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Bloc save(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long BlocId) {

        return blocRepository.findById(BlocId).get();
    }

    @Override
    public Bloc addBloc(Bloc b) {

        return blocRepository.save(b);
    }

    @Override
    public void removeBloc(Long BlocId) {
        blocRepository.deleteById(BlocId);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {

        return blocRepository.save(bloc);
    }

    @Transactional
    @Override
    public Bloc affecterChambresABlocs(List<Long> numChambres, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new EntityNotFoundException("Bloc introuvable avec l'id : " + idBloc));

        List<Chambre> chambres = chambreRepository.findAllByNumeroChambreIn(numChambres);


        if (chambres.size() != new HashSet<>(numChambres).size()) {
            throw new EntityNotFoundException("Une ou plusieurs chambres n'existent pas");}

        for (Chambre chambre : chambres) {

            if (chambre.getBloc() != null) {
                throw new IllegalStateException("La chambre "
                        + chambre.getNumeroChambre() + " est déjà affectée à un bloc");
            }
        }

        for (Chambre chambre : chambres) {chambre.setBloc(bloc);
        }



        return bloc;
    }
}
