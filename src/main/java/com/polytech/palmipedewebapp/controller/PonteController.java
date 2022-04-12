package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.entities.Ponte;
import com.polytech.palmipedewebapp.service.PonteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("ponte")
public class PonteController {

    @Autowired
    private PonteService service;

    @GetMapping()
    public ResponseEntity<List<Ponte>> getPontes(){
        return new ResponseEntity(service.getPonte(), HttpStatus.OK);
    }

    @GetMapping("/{idPonte}")
    public ResponseEntity<List<Ponte>> getPontes(
            @PathVariable Long idPonte
    ){
        return new ResponseEntity(service.getPonteById(idPonte), HttpStatus.OK);
    }

}
