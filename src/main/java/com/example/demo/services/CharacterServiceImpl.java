package com.example.demo.services;

import com.example.demo.dto.CharacterBasicDTO;
import com.example.demo.dto.CharacterDTO;
import com.example.demo.models.Characters;
import com.example.demo.repositories.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;



    @Override
    public Optional<Characters> getCharacter(Long id) {
        return characterRepository.findById(id);
    }

    @Override
    public Characters createCharacter(Characters character) {
        if (character == null){
            return null;
        }
        return characterRepository.save(character);
    }

    @Override
    public List<CharacterBasicDTO> findAll() {
        List<Characters> characters = characterRepository.findAll();
        return characters.stream().map(this::convertCharacterToCharacterBasicDTO).collect(Collectors.toList());
    }

    @Override
    public List<CharacterDTO> findAllDetailed() {
        List<Characters> characters = characterRepository.findAll();
        return characters.stream().map(this::convertCharacterToCharacterDTO).collect(Collectors.toList());

    }

    public CharacterDTO convertCharacterToCharacterDTO(Characters character){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(character, CharacterDTO.class);
    }
    public CharacterBasicDTO convertCharacterToCharacterBasicDTO(Characters character) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(character, CharacterBasicDTO.class);
    }

    @Override
    public Boolean deleteCharacter(Long id) {
        if (characterRepository.existsById(id)){
            characterRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Characters updateCharacter(Long id, Characters p) {
        Optional<Characters> character = characterRepository.findById(id);
        if (character.isEmpty())
            return null;
        return characterRepository.save(p);
    }

    @Override
    public List<Characters> findByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public List<Characters> findByAge(Integer age) {
        return characterRepository.findByAge(age);
    }

    @Override
    public List<Characters> findByMovieSerie(Long id) {
        return characterRepository.findByMovieSeries_Id(id);
    }


//    @Override
//    public List<Characters> findByFiltro(String nombre, Integer edad){
//        if (nombre != null)
//            return characterRepository.findByName(nombre);
//        if (edad != null)
//            return characterRepository.findByAge(edad);
//        return characterRepository.findAllDetailed();
//    }
}
