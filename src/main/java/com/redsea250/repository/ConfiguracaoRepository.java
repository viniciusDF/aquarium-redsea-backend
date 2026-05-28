package com.redsea250.repository;


import com.redsea250.model.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {
    Configuracao findTopByOrderByIdDesc();
}
