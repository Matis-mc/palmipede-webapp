package com.polytech.palmipedewebapp.requests;

public class PalmipedeCreationRequest {

    private Long idEspece;
    private String tagRFID;
    private String nom_espece;

    public Long getIdEspece() {
        return idEspece;
    }

    public String getTagRFID() {
        return tagRFID;
    }

    public void setIdEspece(Long idEspece) {
        this.idEspece = idEspece;
    }

    public String getNom_espece() {
        return nom_espece;
    }

}
