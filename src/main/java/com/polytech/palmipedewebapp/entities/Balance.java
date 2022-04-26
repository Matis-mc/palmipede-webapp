package com.polytech.palmipedewebapp.entities;

import org.springframework.data.annotation.Id;

public class Balance {

    @Id
    private Long idbalance;

    public void setIdbalance(Long idbalance) {
        this.idbalance = idbalance;
    }

    public Long getIdbalance() {
        return idbalance;
    }
}
