package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Bloc;


import java.util.List;

public interface IBlocService {
    Bloc save (Bloc bloc);

    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long BlocId);
    public Bloc addBloc(Bloc b);
    public void removeBloc(Long BlocId);
    public Bloc modifyBloc(Bloc bloc);
}
