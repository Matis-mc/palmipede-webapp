package com.polytech.palmipedewebapp.mapper;

import com.polytech.palmipedewebapp.entities.Ponte;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PonteRowMapper implements RowMapper<Ponte> {
    @Override
    public Ponte mapRow(ResultSet rs, int rowNum) throws SQLException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Ponte ponte = new Ponte();

        ponte.setIdPonte(rs.getLong("id_ponte"));
        ponte.setDatePonte(LocalDate.parse(rs.getString("date"),formatter));
        ponte.setIdNid(rs.getLong("id_nid"));
        ponte.setIdPalmipede(rs.getLong("id_palmipede"));

        return ponte;
    }
}
