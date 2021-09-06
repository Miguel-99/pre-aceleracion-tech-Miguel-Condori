package com.example.demo.services;

import com.example.demo.model.Personaje;
import com.example.demo.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
