package com.polytech.palmipedewebapp.requests;

import java.sql.Date;
import java.time.LocalDate;

public class PonteCreationRequest {

    private Date datePonte;
    private Long idPalmipede;
    private Long idNid;

    public Date getDatePonte() {
        return datePonte;
    }

    public void setDatePonte(Date datePonte) {
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
