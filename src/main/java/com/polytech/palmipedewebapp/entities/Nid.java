package com.polytech.palmipedewebapp.entities;

public class Nid {

    private Float idNid;
    private Float idBatiment;
    private Float idAntenne;
    private Float idBalance;

    public Nid(Float idBatiment, Float idAntenne, Float idBalance) {
        this.idBatiment = idBatiment;
        this.idAntenne = idAntenne;
        this.idBalance = idBalance;
    }

    public Nid(Float idBatiment) {
        this.idBatiment = idBatiment;
    }

    public Float getIdNid() {
        return idNid;
    }

    public Float getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(Float idBatiment) {
        this.idBatiment = idBatiment;
    }

    public Float getIdAntenne() {
        return idAntenne;
    }

    public void setIdAntenne(Float idAntenne) {
        this.idAntenne = idAntenne;
    }

    public Float getIdBalance() {
        return idBalance;
    }

    public void setIdBalance(Float idBalance) {
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
