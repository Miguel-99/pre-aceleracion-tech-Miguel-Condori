package com.example.demo.services;

import com.example.demo.models.Personaje;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonajeService {
    Optional<Personaje> getPersonaje(Long id);
    Personaje createPersonaje(Personaje personaje); //recibe dto
    List<Personaje> findAll();
    Boolean deletePersonaje(Long id);
    Personaje update(Long id, Personaje p);
    List<Personaje> findByNombre(String nombre);
    List<Personaje> findByEdad(Integer edad);
    List<Personaje> findByPeliculaSerie(Long id);
}
