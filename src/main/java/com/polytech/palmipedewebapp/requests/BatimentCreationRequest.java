package com.polytech.palmipedewebapp.requests;

public class BatimentCreationRequest {

    private String name;
    private Long idEspece;

    public Long getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(Long idEspece) {
        this.idEspece = idEspece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
