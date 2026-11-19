package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Foyer;
import com.example.gestionfoyer.entities.Universite;
import com.example.gestionfoyer.repositories.FoyerRepository;
import com.example.gestionfoyer.repositories.UniversiteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImp implements IUniversiteService {

    private UniversiteRepository universiteRepository;

    private FoyerRepository foyerRepository;

    @Override
    public Universite save(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> retrieveAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long UniversiteId) {
        return universiteRepository.findById(UniversiteId).get();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void removeUniversite(Long UniversiteId) {
        universiteRepository.deleteById(UniversiteId);
    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Transactional
    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
       Foyer foyer = foyerRepository.findById(idFoyer)
               .orElseThrow(() -> new EntityNotFoundException(
                       "Foyer introuvable avec l'ID : " + idFoyer
               ));

       Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
               .orElseThrow(() -> new EntityNotFoundException(
                  "Université introuvable avec le nom : " + nomUniversite
               ));

       if (foyer.getUniversite() != null) {
           throw new IllegalStateException(
                   "Le foyer " + idFoyer + " est déjà affecté à une université."
           );
       }

       if (universite.getFoyer() != null ){
           throw new IllegalStateException(
                   "Luniversité " + nomUniversite + " a déjà un foyer."
           );
       }

       universite.setFoyer(foyer);

       foyer.setUniversite(universite);
       return universite;
    }

    @Transactional
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findByIdUniversite(idUniversite)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Université introuvable avec l'id : " + idUniversite
                ));

        if (universite.getFoyer() == null ){
            throw new IllegalStateException("Luniversité " + idUniversite + " n'a pas un foyer.");
        }

        universite.setFoyer(null);
        return universite;
    }


}
