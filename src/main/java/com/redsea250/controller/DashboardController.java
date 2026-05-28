package com.redsea250.controller;

import com.redsea250.dto.DashboardResponse;
import com.redsea250.model.Configuracao;
import com.redsea250.model.Status;
import com.redsea250.repository.ConfiguracaoRepository;
import com.redsea250.repository.StatusRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final ConfiguracaoRepository configRepository;
    private final StatusRepository statusRepository;

    public DashboardController(ConfiguracaoRepository configRepository,
                               StatusRepository statusRepository) {
        this.configRepository = configRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping
    public DashboardResponse dashboard() {
        Configuracao config = configRepository.findTopByOrderByIdDesc();
        Status status = statusRepository.findTopByOrderByIdDesc();

        return new DashboardResponse(config, status);
    }
}
