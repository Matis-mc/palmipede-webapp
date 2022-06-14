package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.exception.UserNotFoundException;
import com.polytech.palmipedewebapp.entities.Espece;
import com.polytech.palmipedewebapp.entities.Palmipede;
import com.polytech.palmipedewebapp.requests.EspeceCreationRequest;
import com.polytech.palmipedewebapp.requests.PalmipedeCreationRequest;
import com.polytech.palmipedewebapp.security.AuthProvider;
import com.polytech.palmipedewebapp.service.PalmipedeService;
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
@RequestMapping("palmipede")
public class PalmipedeController {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private String palmipedeURL = "palmipede/";
    private String especeUrl = "palmipede/espece/";

    @Autowired
    private PalmipedeService service;

    @Autowired
    private AuthProvider authProvider;


    @GetMapping
    public ResponseEntity<List<Palmipede>> getPalmipede(
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)){
            return new ResponseEntity(service.getAllPalmipede(), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{idPalmipede}")
    public ResponseEntity<Palmipede> getPalmipedeById(
            @PathVariable Long idPalmipede,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {
            return new ResponseEntity(service.getPalmipedeById(idPalmipede), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Palmipede> getCount(            @RequestHeader("username") String username,
                                                          @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {
            return new ResponseEntity(service.getCount(), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/espece")
    public ResponseEntity<List<Espece>> getEspece(            @RequestHeader("username") String username,
                                                              @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {
            return new ResponseEntity(service.getAllEspece(), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/espece/{idEspece}")
    public ResponseEntity<Espece> getEspeceById(
            @PathVariable Long idEspece,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {
            return new ResponseEntity(service.getPalmipedeById(idEspece), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createPalmipede(
            @RequestBody PalmipedeCreationRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException , URISyntaxException {
        if(authProvider.isAuth(username,password)) {
            LOGGER.info(request.toString());
            Long id = service.createPalmipede(request);
            URI uri = new URI(palmipedeURL + id);
            HttpHeaders headers = new HttpHeaders();
            headers.set("uri", uri.toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{idPalmipede}")
    public ResponseEntity<?> updatePalmipede(
            @PathVariable Long idPalmipede,
            @RequestBody PalmipedeCreationRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {
            Palmipede palmipede = service.updatePalmipede(request, idPalmipede);
            return new ResponseEntity<>(palmipede, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

    }

    @PostMapping("/espece")
    public ResponseEntity<Espece> createEspece(
            @RequestBody EspeceCreationRequest request,

            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException, URISyntaxException {
        if(authProvider.isAuthWithRole(username,password,"TECHNICIEN")) {
            LOGGER.info(request.toString());
            Long id = service.createEspece(request);
            URI uri = new URI(especeUrl + id);
            HttpHeaders headers = new HttpHeaders();
            headers.set("uri", uri.toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }


    @PutMapping("/espece/{idEspece}")
    public ResponseEntity<?> updateEspece(
            @PathVariable Long idEspece,
            @RequestBody EspeceCreationRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuthWithRole(username,password,"TECHNICIEN")) {
            Espece espece = service.updateEspece(request, idEspece);
            return new ResponseEntity<>(espece, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

    }

    @DeleteMapping("/palmipede/{idPalmipede}")
    public ResponseEntity<?> deletePalmipede(
            @PathVariable Long idPalmipede,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {

            int nbrow = service.deletePalmipede(idPalmipede);
            if (nbrow > 0) {
                return new ResponseEntity<>("Palmipede deleted", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("Palmipede not deleted", HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/espece/{idEspece}")
    public ResponseEntity<?> deleteNid(
            @PathVariable Long idEspece,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuthWithRole(username, password, "ADMIN")) {

            int nbrow = service.deleteEspece(idEspece);

            if (nbrow > 0) {
                return new ResponseEntity<>("Espece deleted", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("Espece not deleted", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

}
