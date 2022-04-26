package com.polytech.palmipedewebapp.mapper;

import com.polytech.palmipedewebapp.entities.Espece;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EspeceRowMapper implements RowMapper<Espece> {
    @Override
    public Espece mapRow(ResultSet rs, int rowNum) throws SQLException {

        Espece espece = new Espece();

        espece.setIdEspece(rs.getLong("id_espece"));
        espece.setName(rs.getString("nom"));
        espece.setPoidMaximalOeuf(rs.getFloat("poid_maximal_oeuf"));
        espece.setPoidMaximalPalmipede(rs.getFloat("poid_maximal_palmipede"));
        espece.setPoidMinimalPalmipede(rs.getFloat("poid_minimal_palmipede"));
        espece.setPoidMinimalOeuf(rs.getFloat("poid_minimal_oeuf"));

        return espece;

    }
}
