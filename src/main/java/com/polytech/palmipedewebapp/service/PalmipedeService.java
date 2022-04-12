package com.polytech.palmipedewebapp.service;

import com.polytech.palmipedewebapp.entities.Batiment;
import com.polytech.palmipedewebapp.entities.Espece;
import com.polytech.palmipedewebapp.entities.Palmipede;
import com.polytech.palmipedewebapp.entities.Ponte;
import com.polytech.palmipedewebapp.repository.PalmipedeRepository;
import com.polytech.palmipedewebapp.requests.PalmipedeCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PalmipedeService {

    @Autowired
    private PalmipedeRepository repository;

    public List<Espece> getAllEspece(){
        return repository.getEspece();
    }

    public List<Batiment> getAllBatiment(){
        return repository.getBatiment();
    }

    public List<Ponte> getAllPonte(){
        return repository.getAllPonte();
    }

    public List<Ponte> getPonteOfTheDay(){
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        return repository.getPonteByDay(date);
    }

    public List<Ponte> getPonteByBatiment(Long idBatiment){
        return repository.getPonteByBatiment(idBatiment);
    }

    public List<Palmipede> getAllPalmipede(){
        return repository.getPalmipede();
    }

    public Palmipede createPalmipede(PalmipedeCreationRequest request){
        return repository.createPalmipede(request);
    }

}
