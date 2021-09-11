package com.example.demo.controllers;

import com.example.demo.models.PeliculaSerie;
import com.example.demo.services.PeliculaSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/movies")
@CrossOrigin("*")
public class PeliculaSerieController {

    @Autowired
    private PeliculaSerieService peliculaSerieService;

    @GetMapping()
    public ResponseEntity<List<PeliculaSerie>> getAll(){
        List<PeliculaSerie> peliculas_series = peliculaSerieService.findALl();
        if (peliculas_series.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(peliculas_series);
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<PeliculaSerie>> getByName(@RequestParam String name){
        System.out.println(name);
        return ResponseEntity.status(HttpStatus.OK).body(peliculaSerieService.findByName(name));
    }

    @GetMapping(params = "genre")
    public ResponseEntity<List<PeliculaSerie>> getByGenre(@RequestParam Long genre){
        System.out.println(genre);
        return ResponseEntity.status(HttpStatus.OK).body(peliculaSerieService.findByGenero(genre));
    }

    @GetMapping(params = "order")
    public ResponseEntity<List<PeliculaSerie>> getByFechaCreacion(@RequestParam String order){
        System.out.println(order);
        return ResponseEntity.status(HttpStatus.OK).body(peliculaSerieService.findByFechaCreacion(order.toUpperCase()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<PeliculaSerie>> getOne(@PathVariable Long id){
        Optional<PeliculaSerie> pelicula_serie = peliculaSerieService.getPeliculaSerie(id);

        if (pelicula_serie.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(pelicula_serie);
    }

    @PostMapping
    public ResponseEntity<PeliculaSerie> createPelicula_Serie(@RequestBody PeliculaSerie pelicula_serieDTO){
        PeliculaSerie pelicula_serie = peliculaSerieService.createPeliculaSerie(pelicula_serieDTO);
        return ResponseEntity.ok(pelicula_serie);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PeliculaSerie> update(@PathVariable Long id, @RequestBody PeliculaSerie ps){
        if (ps != null)
            return ResponseEntity.status(HttpStatus.OK).body(peliculaSerieService.update(id, ps));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PeliculaSerie> delete(@PathVariable Long id){
        Boolean pelicula_Serie = peliculaSerieService.deletePeliculaSerie(id);
        if (pelicula_Serie) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
