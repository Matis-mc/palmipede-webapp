package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.repository.ApplicationRepository;
import com.polytech.palmipedewebapp.requests.ChartRequest;
import com.polytech.palmipedewebapp.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;

@Controller
@CrossOrigin(origins = {"*"})
@RequestMapping("chart")
public class ChartController {

    @Autowired
    private ChartService service;

    @PostMapping("/ponte/espece")
    public ResponseEntity<?> getPonteByDayAndEspece(
            @RequestBody ChartRequest request){
        Map<Date,Integer> pontes = service.getNbPontesByDayByEspece(request.getId(), request.getDate(), request.getInterval());
        return new ResponseEntity<Map<Date, Integer>>(pontes, HttpStatus.OK);
    }

    @PostMapping("/ponte/batiment")
    public ResponseEntity<?> getPonteByDayAndBatiment(
            @RequestBody ChartRequest request){
        Map<Date,Integer> pontes = service.getNbPontesByDayByBatiment(request.getId(), request.getDate(), request.getInterval());
        return new ResponseEntity<Map<Date, Integer>>(pontes, HttpStatus.OK);
    }

}
