package com.polytech.palmipedewebapp.repository;


import com.polytech.palmipedewebapp.entities.*;
import com.polytech.palmipedewebapp.mapper.*;
import com.polytech.palmipedewebapp.requests.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;

import java.util.List;

@Repository
public class ApplicationRepository {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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

    public Long createPalmipede(PalmipedeCreationRequest request){
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
            "INSERT INTO palmipede(id_espece, tag_rfid) VALUES(?, ?)", new String[]{"id_palmipede"});
            ps.setLong(1, request.getIdEspece());
            ps.setString(2, request.getTagRFID());

            return ps;
        }, keyHolder );

        return keyHolder.getKey().longValue();

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

        return jdbcTemplate.query("SELECT * FROM ponte WHERE date = ?", new Object[]{date}, new PonteRowMapper());

    }

    public List<Ponte> getPonteByBatiment(Long idBatiment){

        return jdbcTemplate.query("SELECT * FROM ponte JOIN nid ON ponte.id_nid = nid.id_nid WHERE nid.id_batiment = ?", new Object[]{idBatiment}, new PonteRowMapper());

    }

    public List<Ponte> getPonteByNid( Long idNid){

        return jdbcTemplate.query("SELECT * FROM ponte WHERE id_nid = ?", new Object[]{idNid}, new PonteRowMapper());

    }

    public List<Ponte> getPonteByPalmipede(Long idPalmipede){

        return jdbcTemplate.query("SELECT * FROM ponte WHERE id_palmipede = ?", new Object[]{idPalmipede}, new PonteRowMapper());

    }

    public Long createPonte(PonteCreationRequest request){
        //int result = jdbcTemplate.update("INSERT INTO ponte(date, id_nid, id_palmipede) VALUES(?, ?)", request.getDatePonte(), request.getIdNid(), request.getIdPalmipede() );

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO ponte(date, id_nid, id_palmipede) VALUES(?, ?, ?)", new String[]{"id_ponte"});
            ps.setDate(1, request.getDatePonte());
            ps.setLong(2, request.getIdNid());
            ps.setLong(3, request.getIdPalmipede());

            return ps;
        }, keyHolder );

        return keyHolder.getKey().longValue();

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

    public Long createEspece(EspeceCreationRequest request){
        //int result = jdbcTemplate.update("INSERT INTO ESPECE(nom, poid_minimal_palmipede, poid_maximal_palmipede, poid_minimal_oeuf, poid_maximal_oeuf) VALUES(?, ?, ?, ?, ?)", request.getName(), request.getPoidMinimalPalmipede(), request.getPoidMaximalPalmipede(), request.getPoidMinimalOeuf(), request.getPoidMaximalOeuf() );
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO ESPECE(nom, poid_minimal_palmipede, poid_maximal_palmipede, poid_minimal_oeuf, poid_maximal_oeuf) VALUES(?, ?, ?, ?, ?)", new String[]{"id_espece"});
            ps.setString(1,request.getName());
            ps.setFloat(2, request.getPoidMinimalPalmipede() );
            ps.setFloat(3, request.getPoidMaximalPalmipede());
            ps.setFloat(4, request.getPoidMinimalOeuf());
            ps.setFloat(5, request.getPoidMaximalOeuf());
            return ps;
        }, keyHolder );

        return keyHolder.getKey().longValue();
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

    public Long createBatiment(BatimentCreationRequest request){

        //int result = jdbcTemplate.update("INSERT INTO BATIMENT(nom, id_espece) VALUES(?, ?)", request.getName(), request.getIdEspece());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO BATIMENT(nom, id_espece) VALUES(?, ?)", new String[]{"id_batiment"});
            ps.setString(1, request.getName());
            ps.setLong(2,request.getIdEspece());

            return ps;
        }, keyHolder );

        return keyHolder.getKey().longValue();
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

    public Long createNid(NidCreationRequest request){

        //int result = jdbcTemplate.update("INSERT INTO NID(id_antenne, id_balance, id_batiment) VALUES(?, ?, ?)", request.getIdAntenne(), request.getIdBalance(), request.getIdBatiment());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO NID(id_antenne, id_balance, id_batiment) VALUES(?, ?, ?)", new String[]{"id_nid"});
            ps.setLong(1, request.getIdAntenne());
            ps.setLong(2,request.getIdBalance());
            ps.setLong(3, request.getIdBatiment());

            return ps;
        }, keyHolder );

        return keyHolder.getKey().longValue();
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

    public Long createBalance(BalanceCreationRequest request){
        //int result = jdbcTemplate.update("INSERT INTO BALANCE");

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO BALANCE", new String[]{"id_nid"});


            return ps;
        }, keyHolder );

        return keyHolder.getKey().longValue();
    }

    public int deleteBalanceById(Long id){

        return jdbcTemplate.update("DELETE FROM BALANCE WHERE id_balance = ?", new Object[]{id});

    }

    //====================================== Antenne ================================================//

    public List<AntenneRFID> getAntenne(){

        return jdbcTemplate.query("SELECT * FROM ANTENNE_RFID", new AntenneRFIDRowMapper() );

    }

    public AntenneRFID getAntenneById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM ANTENNE_RFID WHERE id_antenne_rfid = ?", new Object[]{id}, new AntenneRFIDRowMapper());
    }

    public Long createAntenne(AntenneCreationRequest request){
        //int result = jdbcTemplate.update("INSERT INTO ANTENNE_RFID");

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO ANTENNE_RFID", new String[]{"id_nid"});


            return ps;
        }, keyHolder );

        return keyHolder.getKey().longValue();

    }

    public int deleteAntenneById(Long id){
        return jdbcTemplate.update("DELETE FROM ANTENNE_RFID WHERE id_antenne_rfid = ?", new Object[]{id});

    }

}
