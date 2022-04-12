package com.polytech.palmipedewebapp.repository;


import com.polytech.palmipedewebapp.entities.*;
import com.polytech.palmipedewebapp.requests.*;
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

    public List<Ponte> getPonteByNid( Long idNid){
        return null;
    }

    public List<Ponte> getPonteByPalmipede(Long idPalmipede){
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

    public Batiment getBatimentById(Long id){return null;}

    public Batiment createBatiment(BatimentCreationRequest request){return null;}

    //====================================== Nid ================================================//

    public List<Nid> getNid(){
        return null;
    }

    public Nid getNidById(Long id){return null;}

    public Nid createNid(NidCreationRequest request){return null;}

    //====================================== Balance ================================================//

    public List<Balance> getBalance(){
        return null;
    }

    public Balance getBalanceById(Long id){return null;}

    public Balance createBalance(BalanceCreationRequest request){return null;}

    //====================================== Balance ================================================//

    public List<AntenneRFID> getAntenne(){
        return null;
    }

    public AntenneRFID getAntenneById(Long id){return null;}

    public AntenneRFID createAntenne(AntenneCreationRequest request){return null;}


}
