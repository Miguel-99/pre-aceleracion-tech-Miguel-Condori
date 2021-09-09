package com.example.demo.repositories;

import com.example.demo.models.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
    Optional<Personaje> findById(Long id);
    List<Personaje> findAll();
    void deleteById(Long id);
    List<Personaje> findByNombre(String nombre);
    List<Personaje> findByEdad(Integer edad);
}