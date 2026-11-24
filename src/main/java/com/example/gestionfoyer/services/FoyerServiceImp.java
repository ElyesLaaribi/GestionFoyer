package com.example.gestionfoyer.services;
    import com.example.gestionfoyer.entities.Foyer;
    import com.example.gestionfoyer.entities.Universite;
    import com.example.gestionfoyer.repositories.FoyerRepository;
    import com.example.gestionfoyer.repositories.UniversiteRepository;
    import jakarta.transaction.Transactional;
    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImp implements IFoyerService {

    @Autowired
    private FoyerRepository foyerRepository;

    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public Foyer save(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> retrieveAllFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long FoyerId) {
        return foyerRepository.findById(FoyerId).get();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void removeFoyer(Long FoyerId) {
        foyerRepository.deleteById(FoyerId);
    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    @Transactional
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new IllegalStateException(
                        "Université introuvable avec l'ID : " + idUniversite));
        if (universite.getFoyer() != null)
            throw new IllegalStateException(
                    "L'université " + idUniversite + " est déjà associé à un foyer."
            );
        if (foyer.getBlocs() != null)
            foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));

        Foyer saveFoyer = foyerRepository.save(foyer);
        universite.setFoyer(saveFoyer);
        return saveFoyer;
    }
}
