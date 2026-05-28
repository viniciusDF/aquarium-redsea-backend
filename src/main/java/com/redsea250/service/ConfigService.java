package com.redsea250.service;


import com.redsea250.dto.ConfigDTO;
import com.redsea250.model.Configuracao;
import com.redsea250.repository.ConfiguracaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {

    private final ConfiguracaoRepository repository;

    public ConfigService(ConfiguracaoRepository repository) {
        this.repository = repository;
    }

    public List<ConfigDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public ConfigDTO ultima() {
        Configuracao entity = repository.findTopByOrderByIdDesc();
        return entity != null ? toDTO(entity) : null;
    }

    public ConfigDTO salvar(ConfigDTO dto) {
        Configuracao entity = toEntity(dto);
        Configuracao salva = repository.save(entity);
        return toDTO(salva);
    }

    private ConfigDTO toDTO(Configuracao entity) {
        ConfigDTO dto = new ConfigDTO();
        dto.setBranco(entity.getBranco());
        dto.setAzul(entity.getAzul());
        dto.setRoyal(entity.getRoyal());
        dto.setModoAuto(entity.getModoAuto());
        return dto;
    }

    private Configuracao toEntity(ConfigDTO dto) {
        Configuracao entity = new Configuracao();
        entity.setBranco(dto.getBranco());
        entity.setAzul(dto.getAzul());
        entity.setRoyal(dto.getRoyal());
        entity.setModoAuto(dto.getModoAuto());
        return entity;
    }
}
