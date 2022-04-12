package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.entities.Espece;
import com.polytech.palmipedewebapp.entities.Palmipede;
import com.polytech.palmipedewebapp.requests.PalmipedeCreationRequest;
import com.polytech.palmipedewebapp.service.PalmipedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@RequestMapping("palmipede")
@PropertySource("url.repository")
public class PalmipedeController {

    private String palmipedeURL;

    @Autowired
    private PalmipedeService service;

    @GetMapping
    public ResponseEntity<Palmipede> getPalmipede(){
        return new ResponseEntity(service.getAllPalmipede(), HttpStatus.OK);
    }

    @GetMapping("/espece")
    public ResponseEntity<Espece> getEspece(){
        return new ResponseEntity(service.getAllEspece(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Palmipede> createPalmipede(
            @RequestBody PalmipedeCreationRequest request
            ) throws URISyntaxException {
        Palmipede palmipedeCreated = service.createPalmipede(request);
        URI uri = new URI(palmipedeURL + palmipedeCreated.getIdPalmipede());
        HttpHeaders headers = new HttpHeaders();
        headers.set("uri", uri.toString());
        return ResponseEntity.ok().headers(headers).body(palmipedeCreated);
    }
}
