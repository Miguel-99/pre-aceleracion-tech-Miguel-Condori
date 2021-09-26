package com.example.demo.controllers;

import com.example.demo.dto.MovieSerieBasicDTO;
import com.example.demo.dto.MovieSerieDTO;
import com.example.demo.models.MovieSerie;
import com.example.demo.services.MovieSerieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/movies")
@CrossOrigin("*")
public class MovieSerieController {

    @Autowired
    private MovieSerieService movieSerieService;

    @GetMapping
    public ResponseEntity<List<MovieSerieBasicDTO>> getAll(){
        List<MovieSerieBasicDTO> movieSeries = movieSerieService.findAll();
        if (movieSeries.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(movieSeries);
    }

    @GetMapping(path = "/details")
    public ResponseEntity<List<MovieSerieDTO>> getAllDetailed(){
        List<MovieSerieDTO> movieSeries = movieSerieService.findAllDetailed();
        if (movieSeries.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(movieSeries);
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<MovieSerie>> getByName(@RequestParam String name){
        log.info("name = {}", name);
        return ResponseEntity.status(HttpStatus.OK).body(movieSerieService.findByName(name));
    }

    @GetMapping(params = "genre")
    public ResponseEntity<List<MovieSerie>> getByGenre(@RequestParam Long genre){
        log.info("genre = {}", genre);
        return ResponseEntity.status(HttpStatus.OK).body(movieSerieService.findByGenre(genre));
    }

    @GetMapping(params = "order")
    public ResponseEntity<List<MovieSerie>> getByFechaCreacion(@RequestParam String order){
        log.info("order = {}", order);
        return ResponseEntity.status(HttpStatus.OK).body(movieSerieService.findByCreationDate(order.toUpperCase()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<MovieSerie>> getOne(@PathVariable Long id){
        Optional<MovieSerie> movieSerie = movieSerieService.getMovieSerie(id);

        if (movieSerie.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(movieSerie);
    }

    @PostMapping
    public ResponseEntity<MovieSerie> create(@RequestBody MovieSerie movieSerieDTO){
        MovieSerie movieSerie = movieSerieService.createMovieSerie(movieSerieDTO);
        return ResponseEntity.ok(movieSerie);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MovieSerie> update(@PathVariable Long id, @RequestBody MovieSerie movieSerie){
        if (movieSerie != null)
            return ResponseEntity.status(HttpStatus.OK).body(movieSerieService.updateMovieSerie(id, movieSerie));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MovieSerie> delete(@PathVariable Long id){
        Boolean movieSerieExists = movieSerieService.deleteMovieSerie(id);
        if (movieSerieExists) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
