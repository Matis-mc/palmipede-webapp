package com.polytech.palmipedewebapp.mapper;

import com.polytech.palmipedewebapp.entities.Ponte;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PonteRowMapper implements RowMapper<Ponte> {
    @Override
    public Ponte mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ponte ponte = new Ponte();

        ponte.setIdPonte(rs.getLong("id_ponte"));
        ponte.setDatePonte(rs.getDate("date"));
        ponte.setIdNid(rs.getLong("id_nid"));
        ponte.setIdPalmipede(rs.getLong("id_palmipede"));

        return ponte;
    }
}
