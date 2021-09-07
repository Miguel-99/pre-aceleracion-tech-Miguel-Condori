package com.example.demo.controllers;

import com.example.demo.models.Pelicula_Serie;
import com.example.demo.services.Pelicula_SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/movies")
@CrossOrigin("*")
public class Pelicula_SerieController {

    @Autowired
    Pelicula_SerieService pelicula_serieService;

    @GetMapping("")
    public ResponseEntity<List<Pelicula_Serie>> getAll(){
        List<Pelicula_Serie> peliculas_series = pelicula_serieService.findALl();
        if (peliculas_series.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(peliculas_series);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Pelicula_Serie>> getOne(@PathVariable Long id){
        Optional<Pelicula_Serie> pelicula_serie = pelicula_serieService.getPelicula_Serie(id);

        if (pelicula_serie == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(pelicula_serie);
    }

    @PostMapping
    public ResponseEntity<Pelicula_Serie> createPelicula_Serie(@RequestBody Pelicula_Serie pelicula_serieDTO){
        Pelicula_Serie pelicula_serie = pelicula_serieService.createPelicula_Serie(pelicula_serieDTO);
        return ResponseEntity.ok(pelicula_serie);
    }
}
