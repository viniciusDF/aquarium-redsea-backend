package com.redsea250.dto;

import jakarta.validation.constraints.*;


public class ConfigDTO {

    @NotNull
    @Min(0)
    @Max(255)
    private Integer branco;

    @NotNull
    @Min(0)
    @Max(255)
    private Integer azul;

    @NotNull
    @Min(0)
    @Max(255)
    private Integer royal;

    @NotNull
    private Boolean modoAuto;

    // getters e setters

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

    public Boolean getModoAuto() {
        return modoAuto;
    }

    public void setModoAuto(Boolean modoAuto) {
        this.modoAuto = modoAuto;
    }
}
