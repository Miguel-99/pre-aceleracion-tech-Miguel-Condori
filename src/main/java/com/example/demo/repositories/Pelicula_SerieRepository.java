package com.example.demo.repositories;

import com.example.demo.models.Pelicula_Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Pelicula_SerieRepository extends JpaRepository<Pelicula_Serie, Long> {
    Pelicula_Serie findByTitulo(String titulo);
    List<Pelicula_Serie> findAll();
    Optional<Pelicula_Serie> findById(Long id);

}