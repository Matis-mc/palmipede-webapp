package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.exception.UserNotFoundException;
import com.polytech.palmipedewebapp.entities.Ponte;
import com.polytech.palmipedewebapp.requests.PonteCreationRequest;
import com.polytech.palmipedewebapp.security.AuthProvider;
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
import java.util.List;

@Controller
@CrossOrigin(origins = {"*"})
@RequestMapping("ponte")
public class PonteController {

    @Autowired
    private PonteService service;

    @Autowired
    private AuthProvider authProvider;


    Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private String ponteURL = "ponte/";

    @GetMapping()
    public ResponseEntity<List<Ponte>> getPontes(
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {
            return new ResponseEntity(service.getPonte(), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{idPonte}")
    public ResponseEntity<Ponte> getPontes(
            @PathVariable Long idPonte,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {
            return new ResponseEntity(service.getPonteById(idPonte), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<?> getPontesByDate(
            @PathVariable String date,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {

            try {
                return new ResponseEntity(service.getPonteByDay(date), HttpStatus.OK);
            } catch (IllegalArgumentException e) {
                String errMsg = "Error while parsing date, be sure to use the following format : yyyy - MM - dd   Trace : ";
                return new ResponseEntity<>(errMsg + e.getStackTrace(), HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

    }

    @GetMapping("/nid/{idNid}")
    public ResponseEntity<List<Ponte>> getPontesByNid(
            @PathVariable Long idNid,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {
            return new ResponseEntity(service.getPonteByNid(idNid), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/batiment/{idBatiment}")
    public ResponseEntity<List<Ponte>> getPonteByBatiment(
            @PathVariable Long idBatiment,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {
            return new ResponseEntity(service.getPonteByBatiment(idBatiment), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/palmipede/{idPalmipede}")
    public ResponseEntity<List<Ponte>> getPonteByPalmipede(
            @PathVariable Long idPalmipede,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {
            return new ResponseEntity(service.getPonteByPalmipede(idPalmipede), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping()
    public ResponseEntity<Ponte> createPonte(
            @RequestBody PonteCreationRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException, URISyntaxException {
        if(authProvider.isAuth(username,password)) {

            LOGGER.info(request.toString());
            Long id = service.createPonte(request);
            URI uri = new URI(ponteURL + id);
            HttpHeaders headers = new HttpHeaders();
            headers.set("uri", uri.toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{idPonte}")
    public ResponseEntity<?> updatePonte(
            @PathVariable Long idPonte,
            @RequestBody PonteCreationRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {

            Ponte ponte = service.updatePonte(request, idPonte);
            return new ResponseEntity<>(ponte, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

    }

    @DeleteMapping("/ponte/{idPonte}")
    public ResponseEntity<?> deletePonte(
            @PathVariable Long idPonte,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {

            int nbRow = service.deletePonte(idPonte);

            if (nbRow > 0) {
                return new ResponseEntity<>("Ponte deleted", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("Ponte not deleted", HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

}
