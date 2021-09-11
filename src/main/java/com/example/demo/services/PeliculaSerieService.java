package com.example.demo.services;

import com.example.demo.models.PeliculaSerie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface PeliculaSerieService {
    Optional<PeliculaSerie> getPeliculaSerie(Long id);
    PeliculaSerie createPeliculaSerie(PeliculaSerie pelicula_serie);
    List<PeliculaSerie> findALl();
    PeliculaSerie update(Long id, PeliculaSerie ps);
    Boolean deletePeliculaSerie(Long id);
    List<PeliculaSerie> findByName(String name);
    List<PeliculaSerie> findByGenero(Long id);
    List<PeliculaSerie> findByFechaCreacion(String order);
}
