package com.redsea250.repository;

import com.redsea250.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Long> {

    Status findTopByOrderByIdDesc();

    List<Status> findTop20ByOrderByDataHoraDesc();
}
