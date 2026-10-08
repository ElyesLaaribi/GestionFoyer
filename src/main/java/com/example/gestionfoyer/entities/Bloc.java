package com.example.gestionfoyer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;


    @OnetoMany(cascade = CascadeType.ALL, mappedBy="bloc")
    private Set<Bloc> Bloc;

    @ManyToOne
    Chambre chambre;

}
