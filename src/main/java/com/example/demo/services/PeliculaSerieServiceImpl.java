package com.example.demo.services;

import com.example.demo.dto.builder.GeneroBuilder;
import com.example.demo.dto.builder.PeliculaSerieBuilder;
import com.example.demo.dto.builder.PersonajeBuilder;
import com.example.demo.models.Genero;
import com.example.demo.models.PeliculaSerie;
import com.example.demo.models.Personaje;
import com.example.demo.repositories.PeliculaSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PeliculaSerieServiceImpl implements PeliculaSerieService{

    @Autowired
    private PeliculaSerieRepository peliculaSerieRepository;

    @Override
    public Optional<PeliculaSerie> getPeliculaSerie(Long id) {
        return peliculaSerieRepository.findById(id);
    }

    @Override
    public PeliculaSerie createPeliculaSerie(PeliculaSerie peliculaSerie) {
        Optional<PeliculaSerie> pelicula_serieDB = peliculaSerieRepository.findByTitulo(peliculaSerie.getTitulo());
        if (pelicula_serieDB.isPresent()){
            return pelicula_serieDB.get();
        }
        return peliculaSerieRepository.save(peliculaSerie);
    }

    @Override
    public List<PeliculaSerie> findALl() {
        List<PeliculaSerie> peliculaSeries = peliculaSerieRepository.findAll();
        List<PeliculaSerie> peliculaSerieNoRecursivo = new ArrayList<>();


        for (PeliculaSerie ps : peliculaSeries) {
            PeliculaSerie auxPS = new PeliculaSerieBuilder().withPeliculaSerie(ps).build();
            Set<Personaje> listaPersonajesDTO = new HashSet<>();


            for (Personaje personaje: ps.getPersonajes()) {
                Personaje personajeSinPeliculas = new PersonajeBuilder().withPersonaje(personaje).build();
                listaPersonajesDTO.add(personajeSinPeliculas);
            }

            Set<Genero> listaGenerosDTO = new HashSet<>();
            for (Genero gen: ps.getGeneros()) {
                Genero generoSinPeliculas = new GeneroBuilder().withGenero(gen).build();
                listaGenerosDTO.add(generoSinPeliculas);
            }

            auxPS.setGeneros(listaGenerosDTO);
            auxPS.setPersonajes(listaPersonajesDTO);
            peliculaSerieNoRecursivo.add(auxPS);
        }

        return peliculaSerieNoRecursivo;
    }

    @Override
    public PeliculaSerie update(Long id, PeliculaSerie ps) {
        Optional<PeliculaSerie> peliculaSerie = peliculaSerieRepository.findById(id);
        if (peliculaSerie.isEmpty())
            return null;
        return peliculaSerieRepository.save(ps);
    }

    @Override
    public Boolean deletePeliculaSerie(Long id) {
        if (peliculaSerieRepository.existsById(id)){
            peliculaSerieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<PeliculaSerie> findByName (String name) {
        return peliculaSerieRepository.findByTituloContaining(name);
    }

    @Override
    public List<PeliculaSerie> findByGenero(Long id) {
        return peliculaSerieRepository.findByGeneros_Id(id);
    }

    @Override
    public List<PeliculaSerie> findByFechaCreacion(String order) {
        if (order.equals("ASC"))
            return peliculaSerieRepository.findByOrderByFechaCreacionAsc();
        return peliculaSerieRepository.findByOrderByFechaCreacionDesc();
    }


}
