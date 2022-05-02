package com.polytech.palmipedewebapp.service;

import com.polytech.palmipedewebapp.entities.*;
import com.polytech.palmipedewebapp.repository.ApplicationRepository;
import com.polytech.palmipedewebapp.requests.*;
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

    public Batiment updateBatiment(BatimentCreationRequest request, long id){
        int result = repository.updateBatiment(request, id);
        if(result > 0) {
            return repository.getBatimentById(id);
        }else{
            throw new RuntimeException("une erreur est survenue durant l'update");
        }
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

    public Nid updateNid(NidCreationRequest request, long id){
        int result = repository.updateNid(request, id);
        if(result > 0) {
            return repository.getNidById(id);
        }else{
            throw new RuntimeException("une erreur est survenue durant l'update");
        }
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
