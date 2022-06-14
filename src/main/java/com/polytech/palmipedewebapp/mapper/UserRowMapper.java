package com.polytech.palmipedewebapp.mapper;

import com.polytech.palmipedewebapp.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRowMapper implements RowMapper<Optional<User>> {
    @Override
    public Optional<User> mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();

        user.setUserId(rs.getInt("id_user"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setDateCreation(rs.getDate("date_creation"));
        user.setDateSuppression(rs.getDate("date_suppression"));
        user.setRole(rs.getString("role"));
        user.setLocked(rs.getBoolean("is_locked"));

        return Optional.of(user);
    }
}
