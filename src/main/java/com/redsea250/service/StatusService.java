package com.redsea250.service;

import com.redsea250.dto.StatusDTO;
import com.redsea250.model.Status;
import com.redsea250.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository repository;

    public StatusService(StatusRepository repository) {
        this.repository = repository;
    }

    public StatusDTO ultimo() {
        Status entity = repository.findTopByOrderByIdDesc();
        return entity != null ? toDTO(entity) : null;
    }

    public StatusDTO salvar(StatusDTO dto) {
        Status entity = toEntity(dto);
        Status salvo = repository.save(entity);
        return toDTO(salvo);
    }

    private StatusDTO toDTO(Status entity) {
        StatusDTO dto = new StatusDTO();
        dto.setTempAgua(entity.getTempAgua());
        dto.setTempLed(entity.getTempLed());
        dto.setBranco(entity.getBranco());
        dto.setAzul(entity.getAzul());
        dto.setRoyal(entity.getRoyal());
        dto.setFan(entity.getFan());
        dto.setDataHora(entity.getDataHora());
        return dto;
    }

    private Status toEntity(StatusDTO dto) {
        Status entity = new Status();
        entity.setTempAgua(dto.getTempAgua());
        entity.setTempLed(dto.getTempLed());
        entity.setBranco(dto.getBranco());
        entity.setAzul(dto.getAzul());
        entity.setRoyal(dto.getRoyal());
        entity.setFan(dto.getFan());
        return entity;
    }

    public List<StatusDTO> ultimos() {

        return repository
                .findTop20ByOrderByDataHoraDesc()
                .stream()
                .map(this::toDTO)
                .toList();
    }
}
