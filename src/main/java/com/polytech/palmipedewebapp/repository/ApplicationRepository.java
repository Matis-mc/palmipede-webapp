package com.polytech.palmipedewebapp.repository;


import com.polytech.palmipedewebapp.entities.*;
import com.polytech.palmipedewebapp.mapper.*;
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

    public int deletePalmipedeById(Long id){
        return jdbcTemplate.update("DELETE FROM PALMIPEDE WHERE id_palmipede = ?", new Object[]{id});
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

    public int deletePonteById(Long id){
        return jdbcTemplate.update("DELETE FROM PONTE WHERE id_ponte = ?", new Object[]{id});
    }

    //====================================== Espece ================================================//

    public List<Espece> getEspece(){

        return jdbcTemplate.query("SELECT * FROM ESPECE", new EspeceRowMapper());

    }

    public Espece getEspeceById(Long id){

        return jdbcTemplate.queryForObject("SELECT * FROM ESPECE WHERE id_espece = ?", new Object[]{id}, new EspeceRowMapper());

    }

    public Espece createEspece(EspeceCreationRequest request){
        int result = jdbcTemplate.update("INSERT INTO ESPECE(nom, poid_minimal_palmipede, poid_maximal_palmipede, poid_minimal_oeuf, poid_maximal_oeuf) VALUES(?, ?, ?, ?, ?)", request.getName(), request.getPoidMinimalPalmipede(), request.getPoidMaximalPalmipede(), request.getPoidMinimalOeuf(), request.getPoidMaximalOeuf() );
        return null;
    }

    public int deleteEspeceById(Long id){
        return jdbcTemplate.update("DELETE FROM ESPECE WHERE id_espece = ?", new Object[]{id});

    }

    //====================================== Batiment ================================================//

    public List<Batiment> getBatiment(){

        return jdbcTemplate.query("SELECT * FROM BATIMENT", new BatimentRowMapper());

    }

    public Batiment getBatimentById(Long id){

        return jdbcTemplate.queryForObject("SELECT * FROM BATIMENT WHERE id_batiment = ?", new Object[]{id}, new BatimentRowMapper());


    }

    public Batiment getBatimentByIdEspece(Long id){

        return jdbcTemplate.queryForObject("SELECT * FROM BATIMENT WHERE id_espece = ?", new Object[]{id}, new BatimentRowMapper());


    }

    public Batiment createBatiment(BatimentCreationRequest request){

        int result = jdbcTemplate.update("INSERT INTO BATIMENT(nom, id_espece) VALUES(?, ?)", request.getName(), request.getIdEspece());

        return null;
    }

    public int deleteBatimentById(Long id){
        return jdbcTemplate.update("DELETE FROM BATIMENT WHERE id_batiment = ?", new Object[]{id});

    }

    //====================================== Nid ================================================//

    public List<Nid> getNid(){

        return jdbcTemplate.query("SELECT * FROM NID", new NidRowMapper());

    }

    public Nid getNidById(Long id){

        return jdbcTemplate.queryForObject("SELECT * FROM NID WHERE id_nid = ?", new Object[]{id}, new NidRowMapper());

    }

    public Nid createNid(NidCreationRequest request){

        int result = jdbcTemplate.update("INSERT INTO NID(id_antenne, id_balance, id_batiment) VALUES(?, ?, ?)", request.getIdAntenne(), request.getIdBalance(), request.getIdBatiment());

        return null;

    }

    public int deleteNidById(Long id){
        return jdbcTemplate.update("DELETE FROM NID WHERE id_nid = ?", new Object[]{id});

    }

    //====================================== Balance ================================================//

    public List<Balance> getBalance(){

        return jdbcTemplate.query("SELECT * FROM BALANCE", new BalanceRowMapper());
    }

    public Balance getBalanceById(Long id){

        return jdbcTemplate.queryForObject("SELECT * FROM BALANCE WHERE id_balance = ?", new Object[]{id}, new BalanceRowMapper());

    }

    public Balance createBalance(BalanceCreationRequest request){
        int result = jdbcTemplate.update("INSERT INTO BALANCE");
        return null;

    }

    public int deleteBalanceById(Long id){

        return jdbcTemplate.update("DELETE FROM BALANCE WHERE id_balance = ?", new Object[]{id});

    }

    //====================================== Antenne ================================================//

    public List<AntenneRFID> getAntenne(){

        return jdbcTemplate.query("SELECT * FROM ANTENNE", new AntenneRFIDRowMapper() );

    }

    public AntenneRFID getAntenneById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM ANTENNE_RFID WHERE id_antenne_rfid = ?", new Object[]{id}, new AntenneRFIDRowMapper());
    }

    public AntenneRFID createAntenne(AntenneCreationRequest request){
        int result = jdbcTemplate.update("INSERT INTO ANTENNE_RFID");
        return null;
    }

    public int deleteAntenneById(Long id){
        return jdbcTemplate.update("DELETE FROM ANTENNE WHERE id_antenne = ?", new Object[]{id});

    }

}
