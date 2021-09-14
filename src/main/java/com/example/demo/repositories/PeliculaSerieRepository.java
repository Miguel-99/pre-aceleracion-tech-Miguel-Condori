package com.example.demo.repositories;

import com.example.demo.models.PeliculaSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Long> {
    List<PeliculaSerie> findAll();
    Optional<PeliculaSerie> findById(Long id);
    Optional<PeliculaSerie> findByTitulo(String titulo);
    List<PeliculaSerie> findByGeneros_Id(Long id);
    List<PeliculaSerie> findByOrderByFechaCreacionAsc();
    List<PeliculaSerie> findByOrderByFechaCreacionDesc();
    List<PeliculaSerie> findByTituloContaining(String titulo);

}