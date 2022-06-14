package com.polytech.palmipedewebapp.controller;

import com.polytech.palmipedewebapp.exception.UserNotFoundException;
import com.polytech.palmipedewebapp.entities.*;
import com.polytech.palmipedewebapp.requests.*;
import com.polytech.palmipedewebapp.security.AuthProvider;
import com.polytech.palmipedewebapp.service.InfraService;
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
@CrossOrigin(origins = "*")
@RequestMapping("infra")
public class InfraController {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InfraService service;

    @Autowired
    private AuthProvider authProvider;


    private String nidURL = "infra/nid/";
    private String balanceURL = "infra/balance/";
    private String antenneURL = "infra/antenne/";
    private String batimentURL = "infra/batiment/";

    //====================================== Nid ================================================//

    /**
     * Renvoit la liste de tous les nids
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/nid")
    public ResponseEntity<List<Nid>> getNids(@RequestHeader("username") String username,
                                             @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuth(username, password)) {
            return new ResponseEntity(service.getNid(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Renvoit le nid dont l'id est en paramètre.
     * @param idNid
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/nid/{idNid}")
    public ResponseEntity<Nid> getNid(
            @PathVariable Long idNid,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuth(username, password)) {
            return new ResponseEntity(service.getNidById(idNid), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Créer un nouveau nid, à partir d'une requête donnée en payload.
     * @param request
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     * @throws URISyntaxException
     */
    @PostMapping("/nid")
    public ResponseEntity<Nid> createNid(
            @RequestBody NidCreationRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException, URISyntaxException {
        if (authProvider.isAuthWithRole(username, password, "TECHNICIEN")) {
            Long id = service.createNid(request);
            URI uri = new URI(nidURL + id);
            HttpHeaders headers = new HttpHeaders();
            headers.set("uri", uri.toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Modifie un nid à partir d'une requête donnée en payload.
     * @param idNid
     * @param request
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @PutMapping("/nid/{idNid}")
    public ResponseEntity<?> updateNid(
            @PathVariable Long idNid,
            @RequestBody NidCreationRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuthWithRole(username, password, "TECHNICIEN")) {

            Nid nid = service.updateNid(request, idNid);
            return new ResponseEntity<>(nid, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

    }

    /**
     * Supprime un nid à partir de l'id donnée en paramètre.
     * @param idNid
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @DeleteMapping("/nid/{idNid}")
    public ResponseEntity<?> deleteNid(
            @PathVariable Long idNid,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuthWithRole(username, password, "TECHNICIEN")) {
            int nbRow = service.deleteNid(idNid);
            if (nbRow > 0) {
                return new ResponseEntity<>("Nid deleted", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("Nid not deleted", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    //====================================== Balance ================================================//

    /**
     * Renvoit la liste de tous les balances
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/balance")
    public ResponseEntity<List<Balance>> getBalances(@RequestHeader("username") String username,
                                                     @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuth(username, password)) {
            return new ResponseEntity(service.getBalance(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Renvoit la balance dont l'id est en paramètre.
     * @param idBalance
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/balance/{idBalance}")
    public ResponseEntity<Balance> getBalance(
            @PathVariable Long idBalance,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuth(username, password)) {
            return new ResponseEntity(service.getBalanceById(idBalance), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/balance")
    public ResponseEntity<Balance> createBalance(
            @RequestBody BalanceCreationRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException, URISyntaxException {
        if (authProvider.isAuthWithRole(username, password, "TECHNICIEN")) {

            Long id = service.createBalance(request);
            URI uri = new URI(balanceURL + id);
            HttpHeaders headers = new HttpHeaders();
            headers.set("uri", uri.toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/balance/{idBalance}")
    public ResponseEntity<?> deleteBalance(
            @PathVariable Long idBalance,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuthWithRole(username, password, "TECHNICIEN")) {

            int nbRow = service.deleteBalance(idBalance);
            if (nbRow > 0) {
                return new ResponseEntity<>("Balance deleted", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("Balance not deleted", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }


    //====================================== Antenne ================================================//

    /**
     * Renvoit la liste de toutes les antennes
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/antenne")
    public ResponseEntity<List<AntenneRFID>> getAntennes(@RequestHeader("username") String username,
                                                         @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuth(username, password)) {
            return new ResponseEntity(service.getAntenne(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Renvoit le nid dont l'id est en paramètre.
     * @param idAntenne
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/antenne/{idAntenne}")
    public ResponseEntity<AntenneRFID> getAntenne(
            @PathVariable Long idAntenne,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuth(username, password)) {
            return new ResponseEntity(service.getAntenneById(idAntenne), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/antenne")
    public ResponseEntity<AntenneRFID> createAntenne(
            @RequestBody AntenneCreationRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException, URISyntaxException {
        if (authProvider.isAuth(username, password)) {
            LOGGER.info(request.toString());
            Long id = service.createAntenne(request);
            URI uri = new URI(antenneURL + id);
            HttpHeaders headers = new HttpHeaders();
            headers.set("uri", uri.toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/antenne/{idAntenne}")
    public ResponseEntity<?> deleteAntenne(
            @PathVariable Long idAntenne,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuth(username, password)) {

            int nbRow = service.deleteAntenne(idAntenne);
            if (nbRow > 0) {
                return new ResponseEntity<>("Antenne deleted", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("Antenne not deleted", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    //====================================== Batiment ================================================//

    /**
     * Renvoit la liste de tous les batiments
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/Batiment")
    public ResponseEntity<List<Batiment>> getBatiments(@RequestHeader("username") String username,
                                                       @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuth(username, password)) {
            return new ResponseEntity(service.getAllBatiment(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/batiment/{idBatiment}")
    public ResponseEntity<Batiment> getBatiment(
            @PathVariable Long idBatiment,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuth(username, password)) {
            return new ResponseEntity(service.getBatimentById(idBatiment), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/batiment")
    public ResponseEntity<Batiment> createBatiment(
            @RequestBody BatimentCreationRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException, URISyntaxException {
        if (authProvider.isAuth(username, password)) {

            Long id = service.createBatiment(request);
            URI uri = new URI(batimentURL + id);
            HttpHeaders headers = new HttpHeaders();
            headers.set("uri", uri.toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/batiment/{idBatiment}")
    public ResponseEntity<?> updateBatiment(
            @PathVariable Long idBatiment,
            @RequestBody BatimentCreationRequest request,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuth(username, password)) {

            Batiment batiment = service.updateBatiment(request, idBatiment);
            return new ResponseEntity<>(batiment, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

    }

    @DeleteMapping("/batiment/{idBatiment}")
    public ResponseEntity<?> deleteBatiment(
            @PathVariable Long idBatiment,
            @RequestHeader("username") String username,
            @RequestHeader("password") String password
    ) throws UserNotFoundException {
        if (authProvider.isAuth(username, password)) {

            int nbRow = service.deleteBatiment(idBatiment);
            if (nbRow > 0) {
                return new ResponseEntity<>("Batiment deleted", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("Batiment not deleted", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }
}



