package com.polytech.palmipedewebapp.service;

import com.polytech.palmipedewebapp.entities.AntenneRFID;
import com.polytech.palmipedewebapp.entities.Balance;
import com.polytech.palmipedewebapp.entities.Batiment;
import com.polytech.palmipedewebapp.entities.Nid;
import com.polytech.palmipedewebapp.repository.ApplicationRepository;
import com.polytech.palmipedewebapp.requests.AntenneCreationRequest;
import com.polytech.palmipedewebapp.requests.BalanceCreationRequest;
import com.polytech.palmipedewebapp.requests.BatimentCreationRequest;
import com.polytech.palmipedewebapp.requests.NidCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfraService {

    @Autowired
    private ApplicationRepository repository;

    //====================================== Batiment ================================================//
    public List<Batiment> getAllBatiment(){
        return repository.getBatiment();
    }

    public Batiment getBatimentById(Long id){
        return repository.getBatimentById(id);
    }

    public Long createBatiment(BatimentCreationRequest request){
        return repository.createBatiment(request);
    }

    public int deleteBatiment(Long id){
        return repository.deleteBatimentById(id);
    }

    //====================================== Nid ================================================//

    public List<Nid> getNid(){

        return repository.getNid();
    }

    public Nid getNidById(Long id){
        return repository.getNidById(id);
    }

    public Long createNid(NidCreationRequest request){
        return repository.createNid(request);
    }

    public int deleteNid(Long id){
        return repository.deleteNidById(id);
    }

    //====================================== Balance ================================================//

    public List<Balance> getBalance(){

        return repository.getBalance();
    }

    public Balance getBalanceById(Long id){

        return repository.getBalanceById(id);
    }

    public Long createBalance(BalanceCreationRequest request){

        return repository.createBalance(request);
    }

    public int deleteBalance(Long id){
        return repository.deleteBalanceById(id);
    }

    //====================================== Antenne ================================================//

    public List<AntenneRFID> getAntenne(){

        return repository.getAntenne();
    }

    public AntenneRFID getAntenneById(Long id){

        return repository.getAntenneById(id);
    }

    public Long createAntenne(AntenneCreationRequest request){

        return repository.createAntenne(request);
    }

    public int deleteAntenne(Long id){
        return repository.deleteAntenneById(id);
    }


}
