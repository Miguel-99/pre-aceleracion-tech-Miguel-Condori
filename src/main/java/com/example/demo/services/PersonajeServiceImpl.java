package com.example.demo.services;

import com.example.demo.models.Personaje;
import com.example.demo.repositories.PeliculaSerieRepository;
import com.example.demo.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    private PeliculaSerieRepository peliculaSerieRepository;

    @Override
    public Optional<Personaje> getPersonaje(Long id) {
        Optional<Personaje> personaje = personajeRepository.findById(id);
        return personaje;
    }

    @Override
    public Personaje createPersonaje(Personaje personaje) {
        if (personaje == null){
            return null;
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
        if (personaje.isEmpty())
            return null;
        return personajeRepository.save(p);
    }

    @Override
    public List<Personaje> findByNombre(String nombre) {
        return personajeRepository.findByNombre(nombre);
    }

    @Override
    public List<Personaje> findByEdad(Integer edad) {
        return personajeRepository.findByEdad(edad);
    }

    @Override
    public List<Personaje> findByPeliculaSerie(Long id) {
        return personajeRepository.findByPeliculasSeries_Id(id);
    }


//    @Override
//    public List<Personaje> findByFiltro(String nombre, Integer edad){
//        if (nombre != null)
//            return personajeRepository.findByNombre(nombre);
//        if (edad != null)
//            return personajeRepository.findByEdad(edad);
//        return personajeRepository.findAll();
//    }
}
