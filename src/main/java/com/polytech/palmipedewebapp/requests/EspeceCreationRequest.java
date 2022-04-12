package com.polytech.palmipedewebapp.requests;

import java.util.List;

public class EspeceCreationRequest {


    private String name;
    private List<Long> idBatiments;

    //paramètre de l'espece
    private Float poidMinimalOeuf;
    private Float poidMaximalOeuf;
    private Float poidMinimalPalmipede;
    private Float poidMaximalPalmipede;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getIdBatiments() {
        return idBatiments;
    }

    public void setIdBatiments(List<Long> idBatiments) {
        this.idBatiments = idBatiments;
    }

    public Float getPoidMinimalOeuf() {
        return poidMinimalOeuf;
    }

    public void setPoidMinimalOeuf(Float poidMinimalOeuf) {
        this.poidMinimalOeuf = poidMinimalOeuf;
    }

    public Float getPoidMaximalOeuf() {
        return poidMaximalOeuf;
    }

    public void setPoidMaximalOeuf(Float poidMaximalOeuf) {
        this.poidMaximalOeuf = poidMaximalOeuf;
    }

    public Float getPoidMinimalPalmipede() {
        return poidMinimalPalmipede;
    }

    public void setPoidMinimalPalmipede(Float poidMinimalPalmipede) {
        this.poidMinimalPalmipede = poidMinimalPalmipede;
    }

    public Float getPoidMaximalPalmipede() {
        return poidMaximalPalmipede;
    }

    public void setPoidMaximalPalmipede(Float poidMaximalPalmipede) {
        this.poidMaximalPalmipede = poidMaximalPalmipede;
    }

}
