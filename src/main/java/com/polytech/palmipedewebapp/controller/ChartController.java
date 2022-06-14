package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.exception.UserNotFoundException;
import com.polytech.palmipedewebapp.requests.ChartRequest;
import com.polytech.palmipedewebapp.security.AuthProvider;
import com.polytech.palmipedewebapp.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.sql.Date;
import java.util.Map;

@Controller
@CrossOrigin(origins = {"*"})
@RequestMapping("chart")
public class ChartController {

    @Autowired
    private ChartService service;

    @Autowired
    private AuthProvider authProvider;


    /**
     *
     * @param request
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @RolesAllowed("USER")
    @PostMapping("/ponte/espece")
    public ResponseEntity<?> getPonteByDayAndEspece(
            @RequestBody ChartRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {

            Map<Date, Integer> pontes = service.getNbPontesByDayByEspece(request.getId(), request.getDate(), request.getInterval());
            return new ResponseEntity<Map<Date, Integer>>(pontes, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     *
     * @param request
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @RolesAllowed("USER")
    @PostMapping("/ponte/batiment")
    public ResponseEntity<?> getPonteByDayAndBatiment(
            @RequestBody ChartRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if(authProvider.isAuth(username,password)) {

            Map<Date, Integer> pontes = service.getNbPontesByDayByBatiment(request.getId(), request.getDate(), request.getInterval());
            return new ResponseEntity<Map<Date, Integer>>(pontes, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

}
