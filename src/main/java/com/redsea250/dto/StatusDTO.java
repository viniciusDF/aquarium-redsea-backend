package com.redsea250.dto;

import java.time.LocalDateTime;

public class StatusDTO {

    private Double tempAgua;
    private Double tempLed;

    private Integer branco;
    private Integer azul;
    private Integer royal;
    private Integer fan;

    private LocalDateTime dataHora;

    public Double getTempAgua() {
        return tempAgua;
    }

    public Double getTempLed() {
        return tempLed;
    }

    public Integer getBranco() {
        return branco;
    }

    public Integer getAzul() {
        return azul;
    }

    public Integer getRoyal() {
        return royal;
    }

    public Integer getFan() {
        return fan;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setTempAgua(Double tempAgua) {
        this.tempAgua = tempAgua;
    }

    public void setTempLed(Double tempLed) {
        this.tempLed = tempLed;
    }

    public void setBranco(Integer branco) {
        this.branco = branco;
    }

    public void setAzul(Integer azul) {
        this.azul = azul;
    }

    public void setRoyal(Integer royal) {
        this.royal = royal;
    }

    public void setFan(Integer fan) {
        this.fan = fan;
    }


    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

}
