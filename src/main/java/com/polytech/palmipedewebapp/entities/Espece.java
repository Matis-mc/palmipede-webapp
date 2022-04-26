package com.polytech.palmipedewebapp.entities;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Espece {

    @Id
    private Long idEspece;
    private String name;

    //paramètre de l'espece
    private Float poidMinimalOeuf;
    private Float poidMaximalOeuf;
    private Float poidMinimalPalmipede;
    private Float poidMaximalPalmipede;

    public Espece(String name, Float poidMinimalOeuf, Float poidMaximalOeuf, Float poidMinimalPalmipede,  Float poidMaximalPalmipede){
        this.name = name;
        this.poidMinimalOeuf = poidMinimalOeuf;
        this.poidMaximalOeuf = poidMaximalOeuf;
        this.poidMaximalPalmipede = poidMaximalPalmipede;
        this.poidMinimalPalmipede = poidMinimalPalmipede;
    }

    public Espece(String name, List<Long> idBatiments, Float poidMinimalOeuf, Float poidMaximalOeuf, Float poidMinimalPalmipede, Float poidMaximalPalmipede) {
        this.name = name;
        this.poidMinimalOeuf = poidMinimalOeuf;
        this.poidMaximalOeuf = poidMaximalOeuf;
        this.poidMinimalPalmipede = poidMinimalPalmipede;
        this.poidMaximalPalmipede = poidMaximalPalmipede;
    }

    public Espece() {

    }

    public void setIdEspece(Long idEspece) {
        this.idEspece = idEspece;
    }

    public Long getIdEspece() {
        return idEspece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Espece{" +
                "idEspece=" + idEspece +
                ", name='" + name + '\'' +
                ", poidMinimalOeuf=" + poidMinimalOeuf +
                ", poidMaximalOeuf=" + poidMaximalOeuf +
                ", poidMinimalPalmipede=" + poidMinimalPalmipede +
                ", poidMaximalPalmipede=" + poidMaximalPalmipede +
                '}';
    }
}
