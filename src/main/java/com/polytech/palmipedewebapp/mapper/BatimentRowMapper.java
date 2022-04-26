package com.polytech.palmipedewebapp.mapper;

import com.polytech.palmipedewebapp.entities.Batiment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BatimentRowMapper implements RowMapper<Batiment> {
    @Override
    public Batiment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Batiment batiment = new Batiment();

        batiment.setIdBatiment(rs.getLong("id_batiment"));
        batiment.setName(rs.getString("nom"));
        batiment.setIdEspece(rs.getLong("id_espece"));

        return batiment;
    }
}
