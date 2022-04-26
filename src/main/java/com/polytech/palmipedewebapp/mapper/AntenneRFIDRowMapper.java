package com.polytech.palmipedewebapp.mapper;

import com.polytech.palmipedewebapp.entities.AntenneRFID;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AntenneRFIDRowMapper implements RowMapper<AntenneRFID> {
    @Override
    public AntenneRFID mapRow(ResultSet rs, int rowNum) throws SQLException {
        AntenneRFID antenne = new AntenneRFID();

        antenne.setIdAntenne(rs.getLong("id_antenne_rfid"));

        return antenne;
    }
}
