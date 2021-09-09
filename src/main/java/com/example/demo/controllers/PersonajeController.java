package com.example.demo.controllers;

import com.example.demo.models.Personaje;
import com.example.demo.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/characters")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping()
    public ResponseEntity<List<Personaje>> getByName(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age){
        return ResponseEntity.status(HttpStatus.OK).body(personajeService.findByFiltro(name, age));
    }

//    @GetMapping
//    public ResponseEntity<List<Personaje>> getAll(){
//        List<Personaje> personajes = personajeService.findAll();
//        if ( personajes.isEmpty())
//            return ResponseEntity.notFound().build();
//        return ResponseEntity.status(HttpStatus.OK).body(personajes);
//    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Personaje>> getOne(@PathVariable Long id){
        Optional<Personaje> personaje = personajeService.getPersonaje(id);
        if (!personaje.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(personaje);
    }



    @PostMapping
    public ResponseEntity<Personaje> createPersonaje(@RequestBody Personaje personajeDTO){
        Personaje personaje = personajeService.createPersonaje(personajeDTO);
        return ResponseEntity.ok(personaje);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Personaje> update(@PathVariable Long id, @RequestBody Personaje p){
        if (p != null)
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.update(id, p));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Personaje> deletePersonaje(@PathVariable Long id){
        Boolean personaje = personajeService.deletePersonaje(id);
        if (personaje) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
