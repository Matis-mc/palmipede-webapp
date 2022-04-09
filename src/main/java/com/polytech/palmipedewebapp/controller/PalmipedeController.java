package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.entities.Espece;
import com.polytech.palmipedewebapp.entities.Palmipede;
import com.polytech.palmipedewebapp.service.PalmipedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("palmipede")
public class PalmipedeController {

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

}
