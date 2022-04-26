package com.polytech.palmipedewebapp.entities;


import org.springframework.data.annotation.Id;

public class Palmipede {

    @Id
    private Long idPalmipede;
    private Long idEspece;

    public Palmipede(Long idEspece) {
        this.idEspece = idEspece;
    }

    public Palmipede() {

    }


    public Long getIdPalmipede() {
        return idPalmipede;
    }

    public void setIdPalmipede(Long idPalmipede) {
        this.idPalmipede = idPalmipede;
    }

    public Long getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(Long idEspece) {
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
