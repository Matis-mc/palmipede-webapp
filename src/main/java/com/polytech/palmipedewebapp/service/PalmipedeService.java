package com.polytech.palmipedewebapp.service;

import com.polytech.palmipedewebapp.entities.Batiment;
import com.polytech.palmipedewebapp.entities.Espece;
import com.polytech.palmipedewebapp.entities.Palmipede;
import com.polytech.palmipedewebapp.entities.Ponte;
import com.polytech.palmipedewebapp.repository.ApplicationRepository;
import com.polytech.palmipedewebapp.repository.UserRepository;
import com.polytech.palmipedewebapp.requests.EspeceCreationRequest;
import com.polytech.palmipedewebapp.requests.PalmipedeCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class PalmipedeService {

    @Autowired
    private ApplicationRepository repository;

    @Autowired
    private UserRepository repository1;

    public List<Espece> getAllEspece(){
        return repository.getEspece();
    }

    public Palmipede getPalmipedeById(Long id){
        return repository.getPalmipedeById(id);
    }

    public int getCount(){
        return repository.getCountPalmipede();
    }

    public Espece getEspeceById(Long id){
        return repository.getEspeceById(id);
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

    public Long createPalmipede(PalmipedeCreationRequest request){
        return repository.createPalmipede(request);
    }

    public Long createEspece(EspeceCreationRequest request){
        return repository.createEspece(request);
    }

    public Palmipede updatePalmipede(PalmipedeCreationRequest request, long id){
        int result = repository.updatePalmipede(request, id);
        if(result > 0) {
            return repository.getPalmipedeById(id);
        }else{
            throw new RuntimeException("une erreur est survenue durant l'update");
        }
    }

    public Espece updateEspece(EspeceCreationRequest request, long id){
        int result = repository.updateEspece(request, id);
        if(result > 0) {
            return repository.getEspeceById(id);
        }else{
            throw new RuntimeException("une erreur est survenue durant l'update");
        }
    }

    public int deletePalmipede(Long id){
        return repository.deletePalmipedeById(id);
    }

    public int deleteEspece(Long id){
        return repository.deleteEspeceById(id);
    }

}
