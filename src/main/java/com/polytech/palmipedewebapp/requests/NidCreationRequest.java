package com.polytech.palmipedewebapp.requests;

public class NidCreationRequest {

    private Long idBatiment;
    private Long idAntenne;
    private Long idBalance;

    public Long getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(Long idBatiment) {
        this.idBatiment = idBatiment;
    }

    public Long getIdAntenne() {

        return idAntenne;
    }

    public void setIdAntenne(Long idAntenne) {
        this.idAntenne = idAntenne;
    }

    public Long getIdBalance() {
        return idBalance;
    }

    public void setIdBalance(Long idBalance) {
        this.idBalance = idBalance;
    }
}
