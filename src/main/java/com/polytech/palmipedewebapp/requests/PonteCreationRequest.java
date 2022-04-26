package com.polytech.palmipedewebapp.requests;

import java.time.LocalDate;
import java.util.Date;

public class PonteCreationRequest {

    private LocalDate datePonte;
    private Long idPalmipede;
    private Long idNid;

    public LocalDate getDatePonte() {
        return datePonte;
    }

    public void setDatePonte(LocalDate datePonte) {
        this.datePonte = datePonte;
    }

    public Long getIdPalmipede() {
        return idPalmipede;
    }

    public void setIdPalmipede(Long idPalmipede) {
        this.idPalmipede = idPalmipede;
    }

    public Long getIdNid() {
        return idNid;
    }

    public void setIdNid(Long idNid) {
        this.idNid = idNid;
    }
}
