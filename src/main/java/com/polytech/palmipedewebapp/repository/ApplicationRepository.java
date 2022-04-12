package com.polytech.palmipedewebapp.repository;


import com.polytech.palmipedewebapp.entities.Batiment;
import com.polytech.palmipedewebapp.entities.Espece;
import com.polytech.palmipedewebapp.entities.Palmipede;
import com.polytech.palmipedewebapp.entities.Ponte;
import com.polytech.palmipedewebapp.requests.EspeceCreationRequest;
import com.polytech.palmipedewebapp.requests.PalmipedeCreationRequest;
import com.polytech.palmipedewebapp.requests.PonteCreationRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ApplicationRepository {

    //====================================== Palmipede ================================================//
    public List<Palmipede> getPalmipede(){
        return null;
    }

    public Palmipede getPalmipedeById(Long id){
        return null;
    }

    public Palmipede createPalmipede(PalmipedeCreationRequest request){
        return null;
    }

    //====================================== Ponte ================================================//

    public List<Ponte> getAllPonte(){
        return null;
    }

    public Ponte getPonteById( Long id){
        return null;
    }

    public List<Ponte> getPonteByDay(Date date){
        return null;
    }

    public List<Ponte> getPonteByBatiment(Long idBatiment){
        return null;
    }

    public Ponte createPonte(PonteCreationRequest request){
        return null;
    }

    //====================================== Espece ================================================//

    public List<Espece> getEspece(){
        return null;
    }

    public Espece getEspeceById(Long id){return null;}

    public Espece createEspece(EspeceCreationRequest request){return null;}

    //====================================== Batiment ================================================//

    public List<Batiment> getBatiment(){
        return null;
    }


}
