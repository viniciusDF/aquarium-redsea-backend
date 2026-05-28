package com.redsea250.dto;

import com.redsea250.model.Configuracao;
import com.redsea250.model.Status;

public class DashboardResponse {

    private Configuracao configuracao;
    private Status status;

    public DashboardResponse(Configuracao configuracao, Status status) {
        this.configuracao = configuracao;
        this.status = status;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public Status getStatus() {
        return status;
    }
}
