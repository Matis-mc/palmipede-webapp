package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.entities.*;
import com.polytech.palmipedewebapp.requests.*;
import com.polytech.palmipedewebapp.service.InfraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Controller
@CrossOrigin(origins = "*")
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

    @RolesAllowed("TECHNICIEN")
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

    @RolesAllowed("TECHNICIEN")
    @PutMapping("/nid/{idNid}")
    public ResponseEntity<?> updateNid(
            @PathVariable Long idNid,
            @RequestBody NidCreationRequest request

    ){
        Nid nid = service.updateNid(request, idNid);
        return new ResponseEntity<>(nid, HttpStatus.OK);

    }

    @RolesAllowed("TECHNICIEN")
    @DeleteMapping("/nid/{idNid}")
    public ResponseEntity<?> deleteNid(
            @PathVariable Long idNid
    ){
        int nbRow = service.deleteNid(idNid);
        if(nbRow > 0){
            return new ResponseEntity<>("Nid deleted",HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Nid not deleted",HttpStatus.NOT_FOUND);
        }
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

    @RolesAllowed("TECHNICIEN")
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

    @RolesAllowed("TECHNICIEN")
    @DeleteMapping("/balance/{idBalance}")
    public ResponseEntity<?> deleteBalance(
            @PathVariable Long idBalance
    ){
        int nbRow = service.deleteBalance(idBalance);
        if(nbRow > 0){
            return new ResponseEntity<>("Balance deleted",HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Balance not deleted",HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity<?> deleteAntenne(
            @PathVariable Long idAntenne
    ){
        int nbRow = service.deleteAntenne(idAntenne);
        if(nbRow > 0){
            return new ResponseEntity<>("Antenne deleted",HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Antenne not deleted",HttpStatus.NOT_FOUND);
        }
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

    @PutMapping("/batiment/{idBatiment}")
    public ResponseEntity<?> updateBatiment(
            @PathVariable Long idBatiment,
            @RequestBody BatimentCreationRequest request

    ){
        Batiment batiment = service.updateBatiment(request, idBatiment);
        return new ResponseEntity<>(batiment, HttpStatus.OK);

    }

    @DeleteMapping("/batiment/{idBatiment}")
    public ResponseEntity<?> deleteBatiment(
            @PathVariable Long idBatiment
    ){
        int nbRow = service.deleteBatiment(idBatiment);
        if(nbRow > 0){
            return new ResponseEntity<>("Batiment deleted",HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Batiment not deleted",HttpStatus.NOT_FOUND);
        }
    }
    }

