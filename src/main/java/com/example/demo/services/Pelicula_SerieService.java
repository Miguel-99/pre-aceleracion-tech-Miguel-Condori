package com.example.demo.services;

import com.example.demo.models.Pelicula_Serie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface Pelicula_SerieService {
    Optional<Pelicula_Serie> getPelicula_Serie(Long id);
    Pelicula_Serie createPelicula_Serie(Pelicula_Serie pelicula_serie);
    List<Pelicula_Serie> findALl();

    Pelicula_Serie update(Long id, Pelicula_Serie ps);

    Boolean deletePelicula_Serie(Long id);
}
