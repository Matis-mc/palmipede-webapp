package com.polytech.palmipedewebapp.entities;

import org.springframework.data.annotation.Id;

public class Batiment {

    @Id
    private Long idBatiment;
    private String name;
    private Long idEspece;

    public Batiment(String name) {
        this.name = name;
    }

    public Batiment() {

    }

    public void setIdBatiment(Long idBatiment) {
        this.idBatiment = idBatiment;
    }

    public Long getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(Long idEspece) {
        this.idEspece = idEspece;
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
