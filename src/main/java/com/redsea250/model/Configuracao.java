package com.redsea250.model;


import jakarta.persistence.*;

@Entity
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean modoAuto;

    private Integer branco;
    private Integer azul;
    private Integer royal;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public Boolean getModoAuto() {
        return modoAuto;
    }

    public void setModoAuto(Boolean modoAuto) {
        this.modoAuto = modoAuto;
    }

    public Integer getBranco() {
        return branco;
    }

    public void setBranco(Integer branco) {
        this.branco = branco;
    }

    public Integer getAzul() {
        return azul;
    }

    public void setAzul(Integer azul) {
        this.azul = azul;
    }

    public Integer getRoyal() {
        return royal;
    }

    public void setRoyal(Integer royal) {
        this.royal = royal;
    }
}
