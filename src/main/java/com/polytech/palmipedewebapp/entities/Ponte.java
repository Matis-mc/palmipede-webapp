package com.polytech.palmipedewebapp.entities;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Date;

public class Ponte {

    @Id
    private Long idPonte;
    private LocalDate datePonte;
    private Long idPalmipede;
    private Long idNid;

    public Ponte(LocalDate datePonte, Long idPalmipede, Long idNid){
        this.datePonte = datePonte;
        this.idNid = idNid;
        this.idPalmipede = idPalmipede;
    }

    public Ponte() {
    }

    public void setIdPonte(Long idPonte) {
        this.idPonte = idPonte;
    }

    public Long getIdPonte() {
        return idPonte;
    }

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

    @Override
    public String toString() {
        return "Ponte{" +
                "idPonte=" + idPonte +
                ", datePonte=" + datePonte +
                ", idPalmipede=" + idPalmipede +
                ", idNid=" + idNid +
                '}';
    }
}
