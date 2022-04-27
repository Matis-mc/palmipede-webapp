package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.entities.*;
import com.polytech.palmipedewebapp.requests.*;
import com.polytech.palmipedewebapp.service.InfraService;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("infra")
public class InfraController {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InfraService service;

    private String nidURL = "infra/nid/";
    private String balanceURL = "infra/balance/";
    private String antenneURL = "infra/antenne/";
    private String batimentURL = "infra/batiment/";

    //====================================== Nid ================================================//

    @GetMapping("/nid")
    public ResponseEntity<List<Nid>> getNids(){
        return new ResponseEntity(service.getNid(), HttpStatus.OK);
    }

    @GetMapping("/nid/{idNid}")
    public ResponseEntity<Nid> getNid(
            @PathVariable Long idNid
    ){
        return new ResponseEntity(service.getNidById(idNid), HttpStatus.OK);
    }

    @PostMapping("/nid")
    public ResponseEntity<Nid> createNid(
            @RequestBody NidCreationRequest request
    ) throws URISyntaxException {
        Long id = service.createNid(request);
        URI uri = new URI(nidURL + id);
        HttpHeaders headers = new HttpHeaders();
        headers.set("uri", uri.toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/nid/{idNid}")
    public void deleteNid(
            @PathVariable Long idNid
    ){
        service.deleteNid(idNid);
    }

    //====================================== Balance ================================================//

    @GetMapping("/balance")
    public ResponseEntity<List<Balance>> getBalances(){
        return new ResponseEntity(service.getBalance(), HttpStatus.OK);
    }

    @GetMapping("/balance/{idBalance}")
    public ResponseEntity<Balance> getBalance(
            @PathVariable Long idBalance
    ){
        return new ResponseEntity(service.getBalanceById(idBalance), HttpStatus.OK);
    }

    @PostMapping("/balance")
    public ResponseEntity<Balance> createBalance(
            @RequestBody BalanceCreationRequest request
    ) throws URISyntaxException {
        Long id = service.createBalance(request);
        URI uri = new URI(balanceURL + id);
        HttpHeaders headers = new HttpHeaders();
        headers.set("uri", uri.toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/balance/{idBalance}")
    public void deleteBalance(
            @PathVariable Long idBalance
    ){
        service.deleteBalance(idBalance);
    }

    //====================================== Antenne ================================================//

    @GetMapping("/antenne")
    public ResponseEntity<List<AntenneRFID>> getAntennes(){
        return new ResponseEntity(service.getAntenne(), HttpStatus.OK);
    }

    @GetMapping("/antenne/{idAntenne}")
    public ResponseEntity<AntenneRFID> getAntenne(
            @PathVariable Long idAntenne
    ){
        return new ResponseEntity(service.getAntenneById(idAntenne), HttpStatus.OK);
    }

    @PostMapping("/antenne")
    public ResponseEntity<AntenneRFID> createAntenne(
            @RequestBody AntenneCreationRequest request
    ) throws URISyntaxException {
        LOGGER.info(request.toString());
        Long id = service.createAntenne(request);
        URI uri = new URI(antenneURL + id);
        HttpHeaders headers = new HttpHeaders();
        headers.set("uri", uri.toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/antenne/{idAntenne}")
    public void deleteAntenne(
            @PathVariable Long idAntenne
    ){
        service.deleteAntenne(idAntenne);
    }

    //====================================== Batiment ================================================//

    @GetMapping("/Batiment")
    public ResponseEntity<List<Batiment>> getBatiments(){
        return new ResponseEntity(service.getAllBatiment(), HttpStatus.OK);
    }

    @GetMapping("/batiment/{idBatiment}")
    public ResponseEntity<Batiment> getBatiment(
            @PathVariable Long idBatiment
    ){
        return new ResponseEntity(service.getBatimentById(idBatiment), HttpStatus.OK);
    }
    
    @PostMapping("/batiment")
    public ResponseEntity<Batiment> createBatiment(
            @RequestBody BatimentCreationRequest request
    ) throws URISyntaxException {
        Long id = service.createBatiment(request);
        URI uri = new URI(batimentURL + id);
        HttpHeaders headers = new HttpHeaders();
        headers.set("uri", uri.toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/batiment/{idBatiment}")
    public void deleteBatiment(
            @PathVariable Long idBatiment
    ){
        service.deleteBatiment(idBatiment);
    }
}
