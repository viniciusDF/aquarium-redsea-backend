package com.redsea250.repository;

import com.redsea250.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    // Aqui herda métodos prontos como .save(), .findAll(), etc.
}