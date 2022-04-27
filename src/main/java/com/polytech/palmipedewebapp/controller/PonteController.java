package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.entities.Ponte;
import com.polytech.palmipedewebapp.requests.PonteCreationRequest;
import com.polytech.palmipedewebapp.service.PonteService;
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
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("ponte")
public class PonteController {

    @Autowired
    private PonteService service;

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private String ponteURL = "ponte/";

    @GetMapping()
    public ResponseEntity<List<Ponte>> getPontes(){

        return new ResponseEntity(service.getPonte(), HttpStatus.OK);
    }

    @GetMapping("/{idPonte}")
    public ResponseEntity<Ponte> getPontes(
            @PathVariable Long idPonte
    ){
        return new ResponseEntity(service.getPonteById(idPonte), HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Ponte>> getPontesByDate(
            @PathVariable Date date
    ){
        return new ResponseEntity(service.getPonteByDay(date), HttpStatus.OK);
    }

    @GetMapping("/nid/{idNid}")
    public ResponseEntity<List<Ponte>> getPontesByNid(
            @PathVariable Long idNid
    ){
        return new ResponseEntity(service.getPonteByNid(idNid), HttpStatus.OK);
    }

    @GetMapping("/batiment/{idBatiment}")
    public ResponseEntity<List<Ponte>> getPonteByBatiment(
            @PathVariable Long idBatiment
    ){
        return new ResponseEntity(service.getPonteByBatiment(idBatiment), HttpStatus.OK);
    }

    @GetMapping("/palmipede/{idPalmipede}")
    public ResponseEntity<List<Ponte>> getPonteByPalmipede(
            @PathVariable Long idPalmipede
    ){
        return new ResponseEntity(service.getPonteByPalmipede(idPalmipede), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Ponte> createPonte(
            @RequestBody PonteCreationRequest request
            ) throws URISyntaxException {
        LOGGER.info(request.toString());
        Ponte ponteCreated = service.createPonte(request);
        URI uri = new URI(ponteURL + ponteCreated.getIdPalmipede());
        HttpHeaders headers = new HttpHeaders();
        headers.set("uri", uri.toString());
        return ResponseEntity.ok().headers(headers).body(ponteCreated);
    }

    @RolesAllowed("TECHNICIEN")
    @DeleteMapping("/ponte/{idPonte}")
    public void deletePonte(
            @PathVariable Long idPonte
    ){
        service.deletePonte(idPonte);
    }

}
