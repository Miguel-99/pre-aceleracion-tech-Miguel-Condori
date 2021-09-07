package com.example.demo.services;

import com.example.demo.models.Pelicula_Serie;
import com.example.demo.models.Personaje;
import com.example.demo.repositories.Pelicula_SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Pelicula_SerieServiceImpl implements Pelicula_SerieService{

    @Autowired
    private Pelicula_SerieRepository pelicula_serieRepository;

    @Override
    public Optional<Pelicula_Serie> getPelicula_Serie(Long id) {
        Optional<Pelicula_Serie> pelicula_serie = pelicula_serieRepository.findById(id);
        return pelicula_serie;
    }

    @Override
    public Pelicula_Serie createPelicula_Serie(Pelicula_Serie pelicula_serie) {
        Pelicula_Serie pelicula_serieDB = pelicula_serieRepository.findByTitulo(pelicula_serie.getTitulo());
        if (pelicula_serieDB != null){
            return pelicula_serieDB;
        }
        return pelicula_serieRepository.save(pelicula_serie);
    }

    @Override
    public List<Pelicula_Serie> findALl() {
        List<Pelicula_Serie> pelicula_serie = pelicula_serieRepository.findAll();
        return pelicula_serie;
    }

    @Override
    public Pelicula_Serie update(Long id, Pelicula_Serie ps) {
        Optional<Pelicula_Serie> pelicula_Serie = pelicula_serieRepository.findById(id);
        if (!pelicula_Serie.isPresent())
            return null;
        return pelicula_serieRepository.save(ps);
    }

    @Override
    public Boolean deletePelicula_Serie(Long id) {
        if (pelicula_serieRepository.existsById(id)){
            pelicula_serieRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
