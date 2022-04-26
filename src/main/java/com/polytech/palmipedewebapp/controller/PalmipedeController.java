package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.entities.Espece;
import com.polytech.palmipedewebapp.entities.Palmipede;
import com.polytech.palmipedewebapp.requests.EspeceCreationRequest;
import com.polytech.palmipedewebapp.requests.PalmipedeCreationRequest;
import com.polytech.palmipedewebapp.service.PalmipedeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("palmipede")
public class PalmipedeController {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private String palmipedeURL = "palmipede/";
    private String especeUrl = "url/";

    @Autowired
    private PalmipedeService service;

    @GetMapping
    public ResponseEntity<List<Palmipede>> getPalmipede(){
        return new ResponseEntity(service.getAllPalmipede(), HttpStatus.OK);
    }

    @GetMapping("/{idPalmipede}")
    public ResponseEntity<Palmipede> getPalmipedeById(
            @PathVariable Long idPalmipede
    ){
        return new ResponseEntity(service.getPalmipedeById(idPalmipede), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Palmipede> getCount(){
        return new ResponseEntity(service.getCount(), HttpStatus.OK);
    }

    @GetMapping("/espece")
    public ResponseEntity<List<Espece>> getEspece(){
        return new ResponseEntity(service.getAllEspece(), HttpStatus.OK);
    }

    @GetMapping("/espece/{idEspece}")
    public ResponseEntity<Espece> getEspeceById(
            @PathVariable Long idEspece
    ){
        return new ResponseEntity(service.getPalmipedeById(idEspece), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Palmipede> createPalmipede(
            @RequestBody PalmipedeCreationRequest request
            ) throws URISyntaxException {
        LOGGER.info(request.toString());
        Palmipede palmipedeCreated = service.createPalmipede(request);
        URI uri = new URI(palmipedeURL + palmipedeCreated.getIdPalmipede());
        HttpHeaders headers = new HttpHeaders();
        headers.set("uri", uri.toString());
        return ResponseEntity.ok().headers(headers).body(palmipedeCreated);
    }

    @PostMapping("/espece")
    public ResponseEntity<Espece> createEspece(
            @RequestBody EspeceCreationRequest request
            ) throws URISyntaxException {
        LOGGER.info(request.toString());
        Espece especeCreated = service.createEspece(request);
        URI uri = new URI(especeUrl + especeCreated.getIdEspece());
        HttpHeaders headers = new HttpHeaders();
        headers.set("uri", uri.toString());
        return ResponseEntity.ok().headers(headers).body(especeCreated);
    }

    //TODO delete
}
