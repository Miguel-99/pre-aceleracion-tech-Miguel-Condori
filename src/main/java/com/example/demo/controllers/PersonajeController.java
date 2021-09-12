package com.example.demo.controllers;

import com.example.demo.models.Personaje;
import com.example.demo.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/characters")
@CrossOrigin("*")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping(params = "name")
    public ResponseEntity<List<Personaje>> getByName(@RequestParam String name){
        System.out.println(name);
        return ResponseEntity.status(HttpStatus.OK).body(personajeService.findByNombre(name));
    }

    @GetMapping(params = "age")
    public ResponseEntity<List<Personaje>> getByAge(@RequestParam int age){
        System.out.println(age);
        return ResponseEntity.status(HttpStatus.OK).body(personajeService.findByEdad(age));
    }

    @GetMapping(params = "movie")
    public ResponseEntity<List<Personaje>> getByMovie(@RequestParam(name = "movie") Long idMovie){
        System.out.println(idMovie);
        return ResponseEntity.status(HttpStatus.OK).body(personajeService.findByPeliculaSerie(idMovie));
    }

    @GetMapping
    public ResponseEntity<List<Personaje>> getAll(){
        List<Personaje> personajes = personajeService.findAll();
        if ( personajes.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(personajes);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Personaje>> getOne(@PathVariable Long id){
        Optional<Personaje> personaje = personajeService.getPersonaje(id);
        if (personaje.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(personaje);
    }

    @PostMapping
    public ResponseEntity<Personaje> create(@RequestBody Personaje personajeDTO){
        Personaje personaje = personajeService.createPersonaje(personajeDTO);
        return ResponseEntity.ok(personaje);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Personaje> update(@PathVariable Long id, @RequestBody Personaje p){
        System.out.println(id);
        if (p != null)
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.update(id, p));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Personaje> delete(@PathVariable Long id){
        Boolean personaje = personajeService.deletePersonaje(id);
        if (personaje) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
