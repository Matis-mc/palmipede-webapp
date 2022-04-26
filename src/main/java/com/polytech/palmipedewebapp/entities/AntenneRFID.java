package com.polytech.palmipedewebapp.entities;

import org.springframework.data.annotation.Id;

public class AntenneRFID {

    @Id
    private Long idAntenne;

    public Long getIdAntenne() {
        return idAntenne;
    }

}
