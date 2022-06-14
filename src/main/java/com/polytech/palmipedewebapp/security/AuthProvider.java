package com.polytech.palmipedewebapp.security;

import com.polytech.palmipedewebapp.exception.UserNotFoundException;
import com.polytech.palmipedewebapp.entities.User;
import com.polytech.palmipedewebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthProvider {

    @Autowired
    private UserRepository repository;

    public boolean isAuth(String username, String hashPassword) throws UserNotFoundException {

        User user = repository.findUserWithName(username).orElseThrow(()-> new UserNotFoundException("L'utilisateur n'existe pas"));
        if(user.isLocked()){
            return false;
        }
        if(user.getPassword().equals(hashPassword)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isAuthWithRole(String username, String hashPassword, String role) throws UserNotFoundException {

        User user = repository.findUserWithName(username).orElseThrow(()-> new UserNotFoundException("L'utilisateur n'existe pas"));
        if(user.isLocked()){
            return false;
        }
        if(user.getPassword().equals(hashPassword) ){
            switch( user.getRole()){
                case "USER":
                    if(role.equals("USER")){
                        return true;
                    }else{
                        return false;
                    }

                case "TECHNICIEN":
                    if(role.equals("USER") || role.equals("TECHNICIEN")){
                        return true;
                    }else{
                        return false;
                    }

                case "ADMIN":
                    if(role.equals("USER") || role.equals("TECHNICIEN") || role.equals("ADMIN")){
                        return true;
                    }else{
                        return false;
                    }

                default :
                    return false;

            }
        }else{
            return false;
        }
    }


}
