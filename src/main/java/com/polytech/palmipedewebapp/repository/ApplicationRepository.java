package com.polytech.palmipedewebapp.repository;


import com.polytech.palmipedewebapp.entities.*;
import com.polytech.palmipedewebapp.mapper.PalmipedeRowMapper;
import com.polytech.palmipedewebapp.mapper.PonteRowMapper;
import com.polytech.palmipedewebapp.requests.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ApplicationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //====================================== Palmipede ================================================//

    public List<Palmipede> getPalmipede(){
         return jdbcTemplate.query("SELECT * FROM palmipede", new PalmipedeRowMapper());
    }

    public int getCountPalmipede(){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM palmipede", Integer.class);
    }

    public Palmipede getPalmipedeById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM palmipede WHERE id_palmipede = ?", new Object[]{id}, new PalmipedeRowMapper());

    }

    public Palmipede createPalmipede(PalmipedeCreationRequest request){
        int result = jdbcTemplate.update("INSERT INTO palmipede(id_espece) VALUES(?, ?)", request.getIdEspece(), request.getTagRFID() );

        return null;
    }

    //====================================== Ponte ================================================//

    public List<Ponte> getAllPonte(){

        return jdbcTemplate.query("SELECT * FROM PONTE", new PonteRowMapper());

    }

    public Ponte getPonteById( Long id){

        return jdbcTemplate.queryForObject("SELECT * FROM PONTE WHERE id_ponte = ?", new Object[]{id}, new PonteRowMapper());

    }

    public List<Ponte> getPonteByDay(Date date){
        return null;
    }

    public List<Ponte> getPonteByBatiment(Long idBatiment){

        return jdbcTemplate.query("SELECT * FROM ponte WHERE id_batiment = ?", new Object[]{idBatiment}, new PonteRowMapper());

    }

    public List<Ponte> getPonteByNid( Long idNid){

        return jdbcTemplate.query("SELECT * FROM ponte WHERE id_nid = ?", new Object[]{idNid}, new PonteRowMapper());

    }

    public List<Ponte> getPonteByPalmipede(Long idPalmipede){

        return jdbcTemplate.query("SELECT * FROM ponte WHERE id_palmipede = ?", new Object[]{idPalmipede}, new PonteRowMapper());

    }

    public Ponte createPonte(PonteCreationRequest request){
        int result = jdbcTemplate.update("INSERT INTO ponte(date, id_nid, id_palmipede) VALUES(?, ?)", request.getDatePonte(), request.getIdNid(), request.getIdPalmipede() );
        return null;
    }

    //====================================== Espece ================================================//

    public List<Espece> getEspece(){
        return null;
    }

    public Espece getEspeceById(Long id){return null;}

    public Espece createEspece(EspeceCreationRequest request){return null;}

    //====================================== Batiment ================================================//

    public List<Batiment> getBatiment(){
        return null;
    }

    public Batiment getBatimentById(Long id){return null;}

    public Batiment createBatiment(BatimentCreationRequest request){return null;}

    //====================================== Nid ================================================//

    public List<Nid> getNid(){
        return null;
    }

    public Nid getNidById(Long id){return null;}

    public Nid createNid(NidCreationRequest request){return null;}

    //====================================== Balance ================================================//

    public List<Balance> getBalance(){
        return null;
    }

    public Balance getBalanceById(Long id){return null;}

    public Balance createBalance(BalanceCreationRequest request){return null;}

    //====================================== Balance ================================================//

    public List<AntenneRFID> getAntenne(){
        return null;
    }

    public AntenneRFID getAntenneById(Long id){return null;}

    public AntenneRFID createAntenne(AntenneCreationRequest request){return null;}


}
