package com.redsea250.controller;

import com.redsea250.dto.ConfigDTO;
import com.redsea250.service.ConfigService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/config")
public class ConfiguracaoController {

    private final ConfigService service;

    public ConfiguracaoController(ConfigService service) {
        this.service = service;
    }

    @GetMapping
    public List<ConfigDTO> listar() {
        return service.listar();
    }

    @GetMapping("/ultima")
    public ConfigDTO ultima() {
        return service.ultima();
    }

    @PostMapping
    public ConfigDTO salvar(@RequestBody @Valid ConfigDTO dto) {
        return service.salvar(dto);
    }
}
