package com.redsea250.dto;

public class StatusDTO {

    private Double tAgua;
    private Double tLed;
    private Integer branco;
    private Integer azul;
    private Integer royal;
    private Integer fanPwm;
    private Boolean modoAuto;

    // Getters e Setters
    public Double gettAgua() { return tAgua; }
    public void settAgua(Double tAgua) { this.tAgua = tAgua; }

    public Double gettLed() { return tLed; }
    public void settLed(Double tLed) { this.tLed = tLed; }

    public Integer getBranco() { return branco; }
    public void setBranco(Integer branco) { this.branco = branco; }

    public Integer getAzul() { return azul; }
    public void setAzul(Integer azul) { this.azul = azul; }

    public Integer getRoyal() { return royal; }
    public void setRoyal(Integer royal) { this.royal = royal; }

    public Integer getFanPwm() { return fanPwm; }
    public void setFanPwm(Integer fanPwm) { this.fanPwm = fanPwm; }

    public Boolean getModoAuto() { return modoAuto; }
    public void setModoAuto(Boolean modoAuto) { this.modoAuto = modoAuto; }
}