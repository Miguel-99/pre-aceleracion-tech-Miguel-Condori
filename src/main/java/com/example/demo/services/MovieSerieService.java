package com.example.demo.services;

import com.example.demo.dto.MovieSerieBasicDTO;
import com.example.demo.dto.MovieSerieDTO;
import com.example.demo.models.MovieSerie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface MovieSerieService {
    Optional<MovieSerie> getMovieSerie(Long id);
    MovieSerie createMovieSerie(MovieSerie movieSerie);
    List<MovieSerieBasicDTO> findAll();
    List<MovieSerieDTO> findAllDetailed();
    MovieSerie updateMovieSerie(Long id, MovieSerie movieSerie);
    Boolean deleteMovieSerie(Long id);
    List<MovieSerie> findByName(String name);
    List<MovieSerie> findByGenre(Long id);
    List<MovieSerie> findByCreationDate(String order);
}
