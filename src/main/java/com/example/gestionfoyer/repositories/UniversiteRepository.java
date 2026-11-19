package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    Optional<Universite> findByNomUniversite(String nomUniversite);
    Optional<Universite> findByIdUniversite(long idUniversite);
}
