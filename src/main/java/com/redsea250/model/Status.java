package com.redsea250.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double tempAgua;
    private Double tempLed;

    private Integer branco;
    private Integer azul;
    private Integer royal;
    private Integer fan;

    private LocalDateTime dataHora;

    @PrePersist
    public void prePersist() {
        this.dataHora = LocalDateTime.now();
    }

    // Getters e Setters

    public Long getId() { return id; }

    public Double getTempAgua() { return tempAgua; }

    public void setTempAgua(Double tempAgua) { this.tempAgua = tempAgua; }

    public Double getTempLed() { return tempLed; }

    public void setTempLed(Double tempLed) { this.tempLed = tempLed; }

    public Integer getBranco() { return branco; }

    public void setBranco(Integer branco) { this.branco = branco; }

    public Integer getAzul() { return azul; }

    public void setAzul(Integer azul) { this.azul = azul; }

    public Integer getRoyal() { return royal; }

    public void setRoyal(Integer royal) { this.royal = royal; }

    public Integer getFan() { return fan; }

    public void setFan(Integer fan) { this.fan = fan; }

    public LocalDateTime getDataHora() { return dataHora; }
}
