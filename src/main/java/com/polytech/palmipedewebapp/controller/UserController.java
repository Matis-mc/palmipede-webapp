package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.requests.AuthRequest;
import com.polytech.palmipedewebapp.requests.GrantRequest;
import com.polytech.palmipedewebapp.security.AuthProvider;
import com.polytech.palmipedewebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthProvider authProvider;


    private String userURL = "user/";

    //@RolesAllowed("*")
    @PostMapping()
    public ResponseEntity<?> addUtilisateur(
            @RequestBody AuthRequest request)
            throws URISyntaxException {
        try {
            Long id = service.createUser(request.getUsername(), request.getHashPassword());
            URI uri = new URI(userURL + id);
            HttpHeaders headers = new HttpHeaders();
            headers.set("uri", uri.toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @RolesAllowed("ADMIN")
    @PostMapping("/grant/role/")
    public ResponseEntity<?> grantRole(
            @RequestBody GrantRequest request
            ) {
        try {
            service.grantRole(request.getUsername(), request.getRole());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RolesAllowed("ADMIN")
    @PostMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(
            @PathVariable String username
    ) {
            int nbRow = service.deleteUser(username);
        if(nbRow > 0){
            return new ResponseEntity<>("User deleted",HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("User not deleted",HttpStatus.BAD_REQUEST);
        }
    }



}
