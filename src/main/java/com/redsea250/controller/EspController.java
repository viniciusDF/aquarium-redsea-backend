package com.redsea250.controller;

import com.redsea250.dto.StatusDTO;
import com.redsea250.model.Status;
import com.redsea250.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/esp")
@CrossOrigin(origins = "*") // Permite conexões externas de qualquer IP
public class EspController {

    @Autowired
    private StatusRepository statusRepository;

    @PostMapping("/telemetria")
    public ResponseEntity<String> receberTelemetria(@RequestBody StatusDTO dto) {
        try {
            // Mapeia os dados resumidos do DTO para a entidade de Banco de Dados
            Status novoStatus = new Status();
            novoStatus.setTemperaturaAgua(dto.gettAgua());
            novoStatus.setTemperaturaDissipador(dto.gettLed());
            novoStatus.setLedBranco(dto.getBranco());
            novoStatus.setLedAzul(dto.getAzul());
            novoStatus.setLedRoyal(dto.getRoyal());
            novoStatus.setFanPwm(dto.getFanPwm());
            novoStatus.setModoAutomatico(dto.getModoAuto());

            // Salva no banco de dados PostgreSQL / MySQL
            statusRepository.save(novoStatus);

            return ResponseEntity.ok("Dados do aquario salvos com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao processar dados: " + e.getMessage());
        }
    }
}