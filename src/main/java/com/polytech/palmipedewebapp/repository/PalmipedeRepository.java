package com.polytech.palmipedewebapp.repository;


import com.polytech.palmipedewebapp.entities.Batiment;
import com.polytech.palmipedewebapp.entities.Espece;
import com.polytech.palmipedewebapp.entities.Palmipede;
import com.polytech.palmipedewebapp.entities.Ponte;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PalmipedeRepository {

    //====================================== Palmipede ================================================//
    public List<Palmipede> getPalmipede(){
        return null;
    }

    public Palmipede getPalmipedeById(Long id){
        return null;
    }

    //====================================== Ponte ================================================//

    public List<Ponte> getAllPonte(){
        return null;
    }

    public List<Ponte> getPonteByDay(Date date){
        return null;
    }

    public List<Ponte> getPonteByBatiment(Long idBatiment){
        return null;
    }

    //====================================== Espece ================================================//

    public List<Espece> getEspece(){
        return null;
    }

    //====================================== Batiment ================================================//

    public List<Batiment> getBatiment(){
        return null;
    }


}
