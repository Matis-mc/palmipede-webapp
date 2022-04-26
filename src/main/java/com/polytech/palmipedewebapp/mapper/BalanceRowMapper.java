package com.polytech.palmipedewebapp.mapper;

import com.polytech.palmipedewebapp.entities.Balance;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceRowMapper implements RowMapper<Balance> {
    @Override
    public Balance mapRow(ResultSet rs, int rowNum) throws SQLException {
        Balance balance = new Balance();

        balance.setIdbalance(rs.getLong("id_balance"));

        return balance;
    }
}
