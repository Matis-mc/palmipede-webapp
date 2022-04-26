package com.polytech.palmipedewebapp.entities;

import org.springframework.data.annotation.Id;

public class Nid {

    @Id
    private Long idNid;
    private Long idBatiment;
    private Long idAntenne;
    private Long idBalance;

    public Nid(Long idBatiment, Long idAntenne, Long idBalance) {
        this.idBatiment = idBatiment;
        this.idAntenne = idAntenne;
        this.idBalance = idBalance;
    }

    public Nid(Long idBatiment) {
        this.idBatiment = idBatiment;
    }

    public Nid() {

    }

    public void setIdNid(Long idNid) {
        this.idNid = idNid;
    }

    public Long getIdNid() {
        return idNid;
    }

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

    @Override
    public String toString() {
        return "Nid{" +
                "idNid=" + idNid +
                ", idBatiment=" + idBatiment +
                ", idAntenne=" + idAntenne +
                ", idBalance=" + idBalance +
                '}';
    }
}
