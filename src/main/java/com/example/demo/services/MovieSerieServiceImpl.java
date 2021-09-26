package com.example.demo.services;

import com.example.demo.dto.MovieSerieBasicDTO;
import com.example.demo.dto.MovieSerieDTO;
import com.example.demo.models.MovieSerie;
import com.example.demo.repositories.MovieSerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieSerieServiceImpl implements MovieSerieService {

    @Autowired
    private MovieSerieRepository movieSerieRepository;

    @Override
    public Optional<MovieSerie> getMovieSerie(Long id) {
        return movieSerieRepository.findById(id);
    }

    @Override
    public MovieSerie createMovieSerie(MovieSerie movieSerie) {
        Optional<MovieSerie> movieSerieOptional = movieSerieRepository.findByTitle(movieSerie.getTitle());
        if (movieSerieOptional.isPresent()){
            return movieSerieOptional.get();
        }
        return movieSerieRepository.save(movieSerie);
    }



    @Override
    public MovieSerie updateMovieSerie(Long id, MovieSerie movieSerie) {
        Optional<MovieSerie> movieSerieOptional = movieSerieRepository.findById(id);
        if (movieSerieOptional.isEmpty())
            return null;
        return movieSerieRepository.save(movieSerie);
    }

    @Override
    public Boolean deleteMovieSerie(Long id) {
        if (movieSerieRepository.existsById(id)){
            movieSerieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<MovieSerie> findByName (String name) {
        return movieSerieRepository.findByTitleContaining(name);
    }

    @Override
    public List<MovieSerie> findByGenre(Long id) {
        return movieSerieRepository.findByGenres_Id(id);
    }

    @Override
    public List<MovieSerie> findByCreationDate(String order) {
        if (order.equals("ASC"))
            return movieSerieRepository.findByOrderByCreationDateAsc();
        return movieSerieRepository.findByOrderByCreationDateDesc();
    }

    @Override
    public List<MovieSerieBasicDTO> findAll() {
        List<MovieSerie> movieSeries = movieSerieRepository.findAll();
        return movieSeries.stream().map(this::convertMovieSerieToMovieSerieBasicDTO).collect(Collectors.toList());
    }

    @Override
    public List<MovieSerieDTO> findAllDetailed() {
        List<MovieSerie> movieSeries = movieSerieRepository.findAll();
        return movieSeries.stream().map(this::convertMovieSerieToMovieSerieDTO).collect(Collectors.toList());
    }

    public MovieSerieDTO convertMovieSerieToMovieSerieDTO(MovieSerie movieSerie) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(movieSerie, MovieSerieDTO.class);
    }
    public MovieSerieBasicDTO convertMovieSerieToMovieSerieBasicDTO(MovieSerie movieSerie) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(movieSerie, MovieSerieBasicDTO.class);
    }

}
