package com.polytech.palmipedewebapp.entities;

public class Batiment {

    private Long idBatiment;
    private String name;

    public Batiment(String name) {
        this.name = name;
    }

    public Long getIdBatiment() {
        return idBatiment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
