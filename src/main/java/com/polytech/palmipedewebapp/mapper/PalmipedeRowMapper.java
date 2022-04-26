package com.polytech.palmipedewebapp.mapper;

import com.polytech.palmipedewebapp.entities.Palmipede;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PalmipedeRowMapper implements RowMapper<Palmipede> {
    @Override
    public Palmipede mapRow(ResultSet rs, int rowNum) throws SQLException {
        Palmipede palmipede = new Palmipede();
        palmipede.setIdPalmipede(rs.getLong("id_palmipede"));
        palmipede.setIdEspece(rs.getLong("id_espece"));

        return palmipede;
    }
}
