package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.entities.Palmipede;
import com.polytech.palmipedewebapp.entities.Ponte;
import com.polytech.palmipedewebapp.requests.PalmipedeCreationRequest;
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

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(origins = "*")
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
    public ResponseEntity<?> getPontesByDate(
            @PathVariable String date
    ){
        try {
            return new ResponseEntity(service.getPonteByDay(date), HttpStatus.OK);
       }catch (IllegalArgumentException e) {
            String errMsg = "Error while parsing date, be sure to use the following format : yyyy - MM - dd   Trace : ";
            return new ResponseEntity<>( errMsg + e.getStackTrace(), HttpStatus.BAD_REQUEST);
        }

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
        Long id = service.createPonte(request);
        URI uri = new URI(ponteURL + id);
        HttpHeaders headers = new HttpHeaders();
        headers.set("uri", uri.toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{idPonte}")
    public ResponseEntity<?> updatePonte(
            @PathVariable Long idPonte,
            @RequestBody PonteCreationRequest request

    ){
        Ponte ponte = service.updatePonte(request, idPonte);
        return new ResponseEntity<>(ponte, HttpStatus.OK);

    }

    @DeleteMapping("/ponte/{idPonte}")
    public ResponseEntity<?> deletePonte(
            @PathVariable Long idPonte
    ){
        int nbRow = service.deletePonte(idPonte);

        if(nbRow > 0){
            return new ResponseEntity<>("Ponte deleted",HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Ponte not deleted",HttpStatus.NOT_FOUND);
        }
    }

}
