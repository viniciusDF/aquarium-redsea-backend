package com.redsea250.controller;

import com.redsea250.dto.ConfigDTO;
import com.redsea250.dto.StatusDTO;
import com.redsea250.service.ConfigService;
import com.redsea250.service.StatusService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/esp")
public class EspController {

    private final ConfigService configService;
    private final StatusService statusService;

    public EspController(ConfigService configService, StatusService statusService) {
        this.configService = configService;
        this.statusService = statusService;
    }

    // ESP busca configuração da luminária
    @GetMapping("/config")
    public ConfigDTO getConfig() {
        return configService.ultima();
    }

    // ESP envia status e temperaturas
    @PostMapping("/status")
    public StatusDTO receberStatus(@RequestBody StatusDTO status) {
        return statusService.salvar(status);
    }
}