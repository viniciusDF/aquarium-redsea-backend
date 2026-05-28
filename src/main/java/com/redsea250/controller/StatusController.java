package com.redsea250.controller;

import com.redsea250.dto.StatusDTO;
import com.redsea250.service.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final StatusService service;

    public StatusController(StatusService service) {
        this.service = service;
    }

    @GetMapping("/ultimo")
    public StatusDTO ultimo() {
        return service.ultimo();
    }

    @PostMapping
    public StatusDTO salvar(@RequestBody StatusDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("/ultimos")
    public List<StatusDTO> ultimos() {
        return service.ultimos();
    }
}
