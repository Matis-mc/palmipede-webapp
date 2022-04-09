package com.polytech.palmipedewebapp.entities;

public class Palmipede {

    private Float idPalmipede;
    private Float idEspece;

    public Palmipede(Float idEspece) {
        this.idEspece = idEspece;
    }

    public Float getIdPalmipede() {
        return idPalmipede;
    }

    public Float getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(Float idEspece) {
        this.idEspece = idEspece;
    }

    @Override
    public String toString() {
        return "Palmipede{" +
                "idPalmipede=" + idPalmipede +
                ", idEspece=" + idEspece +
                '}';
    }
}
