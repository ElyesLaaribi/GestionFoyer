package com.example.gestionfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;

    @JsonIgnore
    @OneToOne(mappedBy = "foyer")
    private Universite universite;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
    private List<Bloc> blocs;

}
