package com.polytech.palmipedewebapp.requests;

public class PalmipedeCreationRequest {

    private Long idEspece;
    private String tagRFID;

    public Long getIdEspece() {
        return idEspece;
    }

    public String getTagRFID() {
        return tagRFID;
    }

    public void setIdEspece(Long idEspece) {
        this.idEspece = idEspece;
    }
}
