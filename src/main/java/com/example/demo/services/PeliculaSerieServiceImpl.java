package com.example.demo.services;

import com.example.demo.models.PeliculaSerie;
import com.example.demo.repositories.PeliculaSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        PeliculaSerie pelicula_serieDB = peliculaSerieRepository.findByTitulo(peliculaSerie.getTitulo());
        if (pelicula_serieDB != null){
            return pelicula_serieDB;
        }
        return peliculaSerieRepository.save(peliculaSerie);
    }

    @Override
    public List<PeliculaSerie> findALl() {
        List<PeliculaSerie> peliculaSerie = peliculaSerieRepository.findAll();
        return peliculaSerie;
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

}
