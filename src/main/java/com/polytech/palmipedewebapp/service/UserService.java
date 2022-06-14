package com.polytech.palmipedewebapp.service;

import com.polytech.palmipedewebapp.entities.User;
import com.polytech.palmipedewebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    //Attention, l'objet user contient le hash du password, il ne faut donc pas qu'il sorte du back.
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

    public long createUser(String username, String password) {
        if (repository.checkUsernameAvailable(username)) {
            return repository.createUser(username, password);
        } else {
            throw new IllegalArgumentException("username already used");
        }
    }

    public String grantRole(long id_user, String role){
        if(checkRoleExist(role)){
            repository.grantRole(id_user,role);
            return role;
        }else{
            throw new IllegalArgumentException("role doesn't exist");
        }
    }

    public String grantRole(String username , String role){
        if(checkRoleExist(role)){
            repository.grantRole(username,role);
            return role;
        }else{
            throw new IllegalArgumentException("role doesn't exist");
        }
    }

    public int deleteUser(String username){
        return repository.deleteUserById(username);
    }

    public boolean checkRoleExist(String role){
        List<String> roles = Arrays.asList("ADMIN", "TECHNICIEN","USER");
        return roles.contains(role);
    }

}
