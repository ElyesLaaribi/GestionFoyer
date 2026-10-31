package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    //void deleteAllById(Long universiteId);
}
