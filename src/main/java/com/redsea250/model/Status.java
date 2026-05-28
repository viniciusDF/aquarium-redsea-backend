package com.redsea250.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_status_aquario")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;
    private Double temperaturaAgua;
    private Double temperaturaDissipador;
    private Integer ledBranco;
    private Integer ledAzul;
    private Integer ledRoyal;
    private Integer fanPwm;
    private Boolean modoAutomatico;

    // Construtor padrão exigido pelo JPA
    public Status() {}

    // Executa automaticamente antes de salvar no banco
    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public Double getTemperaturaAgua() { return temperaturaAgua; }
    public void setTemperaturaAgua(Double temperaturaAgua) { this.temperaturaAgua = temperaturaAgua; }

    public Double getTemperaturaDissipador() { return temperaturaDissipador; }
    public void setTemperaturaDissipador(Double temperaturaDissipador) { this.temperaturaDissipador = temperaturaDissipador; }

    public Integer getLedBranco() { return ledBranco; }
    public void setLedBranco(Integer ledBranco) { this.ledBranco = ledBranco; }

    public Integer getLedAzul() { return ledAzul; }
    public void setLedAzul(Integer ledAzul) { this.ledAzul = ledAzul; }

    public Integer getLedRoyal() { return ledRoyal; }
    public void setLedRoyal(Integer ledRoyal) { this.ledRoyal = ledRoyal; }

    public Integer getFanPwm() { return fanPwm; }
    public void setFanPwm(Integer fanPwm) { this.fanPwm = fanPwm; }

    public Boolean getModoAutomatico() { return modoAutomatico; }
    public void setModoAutomatico(Boolean modoAutomatico) { this.modoAutomatico = modoAutomatico; }
}