package com.example.demo.services;

import com.example.demo.models.Pelicula_Serie;
import com.example.demo.models.Personaje;
import com.example.demo.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public Optional<Personaje> getPersonaje(Long id) {
        Optional<Personaje> personaje = personajeRepository.findById(id);
        return personaje;
    }

    @Override
    public Personaje createPersonaje(Personaje personaje) {

        Personaje personajeDB = personajeRepository.findByNombre(personaje.getNombre());
        if (personajeDB != null){
            return personajeDB;
        }
        return personajeRepository.save(personaje);
    }

    @Override
    public List<Personaje> findAll() {
        List<Personaje> personajes = personajeRepository.findAll();
        return personajes;
    }

    @Override
    public Boolean deletePersonaje(Long id) {
        if (personajeRepository.existsById(id)){
            personajeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Personaje update(Long id, Personaje p) {
        Optional<Personaje> personaje = personajeRepository.findById(id);
        if (!personaje.isPresent())
            return null;
        return personajeRepository.save(p);
    }
}
