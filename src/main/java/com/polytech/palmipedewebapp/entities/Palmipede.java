package com.polytech.palmipedewebapp.entities;


import org.springframework.data.annotation.Id;

public class Palmipede {

    @Id
    private Long idPalmipede;
    private Long idEspece;
    private String tagRFID;

    public Palmipede(Long idEspece, String tag) {
        this.idEspece = idEspece;
        this.tagRFID = tag;
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

    public String getTagRFID() {
        return tagRFID;
    }

    public void setTagRFID(String tagRFID) {
        this.tagRFID = tagRFID;
    }

    @Override
    public String toString() {
        return "Palmipede{" +
                "idPalmipede=" + idPalmipede +
                ", idEspece=" + idEspece +
                '}';
    }
}
