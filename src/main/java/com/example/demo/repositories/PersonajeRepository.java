package com.example.demo.repositories;

import com.example.demo.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
}