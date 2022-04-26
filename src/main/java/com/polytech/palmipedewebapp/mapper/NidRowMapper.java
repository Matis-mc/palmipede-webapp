package com.polytech.palmipedewebapp.mapper;

import com.polytech.palmipedewebapp.entities.Nid;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NidRowMapper implements RowMapper<Nid> {
    @Override
    public Nid mapRow(ResultSet rs, int rowNum) throws SQLException {
        Nid nid  = new Nid();

        nid.setIdNid(rs.getLong("id_nid"));
        nid.setIdAntenne(rs.getLong("id_antenne"));
        nid.setIdBalance(rs.getLong("id_balance"));
        nid.setIdBatiment(rs.getLong("id_batiment"));

        return nid;
    }
}
