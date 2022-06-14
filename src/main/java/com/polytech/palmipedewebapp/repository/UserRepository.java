package com.polytech.palmipedewebapp.repository;

import com.polytech.palmipedewebapp.entities.User;
import com.polytech.palmipedewebapp.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Optional;

@Repository
public class UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Optional<User> findUserWithName(String username){
        return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE username  = ?", new Object[]{username}, new UserRowMapper());
    }

    public long createUser(String username, String password){
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO USER(username, password, role, date_creation, date_suppression, is_locked ) VALUES(?, ?, 'USER', now(), null, FALSE )", new String[]{"id_espece"});
            ps.setString(1, username);
            ps.setString(2, password );
            return ps;
        }, keyHolder );

        return keyHolder.getKey().longValue();
    }

    public int grantRole(long id_user, String role){
        return jdbcTemplate.update("UPDATE USER SET role = ? WHERE id_user = ?;",role, id_user);
    }

    public int grantRole(String username, String role){
        return jdbcTemplate.update("UPDATE USER SET role = ? WHERE username = ?;",role, username);
    }

    public int deleteUserById(String username){
        return jdbcTemplate.update("UPDATE USER SET date_suppression = now(), is_locked = TRUE WHERE username = ?;", new Object[]{username});
    }

    public boolean checkUsernameAvailable(String username){
        Integer nbRow = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USER WHERE username = ?", new Object[]{username}, Integer.class);
        if(nbRow==0){
            return true;
        }else{
            return false;
        }
    }

}
