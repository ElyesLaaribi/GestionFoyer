package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Bloc;
import com.example.gestionfoyer.repositories.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class BlocServiceImp implements IBlocService{
    @Autowired
    private BlocRepository blocRepository;

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
}
