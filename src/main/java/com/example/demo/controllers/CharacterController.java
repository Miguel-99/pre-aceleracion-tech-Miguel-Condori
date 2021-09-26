package com.example.demo.controllers;

import com.example.demo.dto.CharacterBasicDTO;
import com.example.demo.dto.CharacterDTO;
import com.example.demo.models.Characters;
import com.example.demo.services.CharacterService;
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
@RequestMapping(path = "api/v1/characters")
@CrossOrigin("*")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping()
    public ResponseEntity<List<CharacterBasicDTO>> getAll(){
        List<CharacterBasicDTO> characters = characterService.findAll();
        if ( characters.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(characters);
    }
    @GetMapping(params = "name")
    public ResponseEntity<List<Characters>> getByName(@RequestParam String name){
        log.info("name = {}", name);
        return ResponseEntity.status(HttpStatus.OK).body(characterService.findByName(name));
    }

    @GetMapping(params = "age")
    public ResponseEntity<List<Characters>> getByAge(@RequestParam Integer age){
        log.info("age = {}", age);
        return ResponseEntity.status(HttpStatus.OK).body(characterService.findByAge(age));
    }

    @GetMapping(params = "movie")
    public ResponseEntity<List<Characters>> getByMovie(@RequestParam(name = "movie") Long idMovie){
        log.info("movie id = {}", idMovie);
        return ResponseEntity.status(HttpStatus.OK).body(characterService.findByMovieSerie(idMovie));
    }

    @GetMapping(path = "/details")
    public ResponseEntity<List<CharacterDTO>> getAllDetailed(){
        List<CharacterDTO> characters = characterService.findAllDetailed();
        if ( characters.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(characters);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Characters>> getOne(@PathVariable Long id){
        Optional<Characters> character = characterService.getCharacter(id);
        if (character.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(character);
    }

    @PostMapping
    public ResponseEntity<Characters> create(@RequestBody Characters charactersDTO){
        Characters characters = characterService.createCharacter(charactersDTO);
        return ResponseEntity.ok(characters);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Characters> update(@PathVariable Long id, @RequestBody Characters character){
        log.info("character = {}", character);
        if (character != null)
            return ResponseEntity.status(HttpStatus.OK).body(characterService.updateCharacter(id, character));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Characters> delete(@PathVariable Long id){
        Boolean characterExists = characterService.deleteCharacter(id);
        if (characterExists) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
