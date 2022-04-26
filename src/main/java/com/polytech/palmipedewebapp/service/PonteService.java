package com.polytech.palmipedewebapp.service;


import com.polytech.palmipedewebapp.entities.Ponte;
import com.polytech.palmipedewebapp.repository.ApplicationRepository;
import com.polytech.palmipedewebapp.requests.PonteCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PonteService {

    @Autowired
    private ApplicationRepository repository;

    public List<Ponte> getPonte(){
        return repository.getAllPonte();
    }

    public Ponte getPonteById( Long id){
        return repository.getPonteById(id);
    }

    public List<Ponte> getPonteByDay(Date date){
        return
                repository.getPonteByDay(date);
    }

    public List<Ponte> getPonteByBatiment(Long idBatiment){

        return repository.getPonteByBatiment(idBatiment);
    }

    public List<Ponte> getPonteByNid( Long idNid){
        return repository.getPonteByNid(idNid);
    }

    public List<Ponte> getPonteByPalmipede(Long idPalmipede){
        return repository.getPonteByPalmipede(idPalmipede);
    }

    public Ponte createPonte(PonteCreationRequest request){
        return repository.createPonte(request);
    }

    public void deletePonte(Long id){
        repository.deletePonteById(id);
    }

}
