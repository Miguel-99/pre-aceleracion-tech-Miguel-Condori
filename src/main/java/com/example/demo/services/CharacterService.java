package com.example.demo.services;

import com.example.demo.dto.CharacterBasicDTO;
import com.example.demo.dto.CharacterDTO;
import com.example.demo.models.Characters;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CharacterService {
    Optional<Characters> getCharacter(Long id);
    Characters createCharacter(Characters character);
    List<CharacterBasicDTO> findAll();
    List<CharacterDTO> findAllDetailed();
    Boolean deleteCharacter(Long id);
    Characters updateCharacter(Long id, Characters character);
    List<Characters> findByName(String name);
    List<Characters> findByAge(Integer age);
    List<Characters> findByMovieSerie(Long id);
}
