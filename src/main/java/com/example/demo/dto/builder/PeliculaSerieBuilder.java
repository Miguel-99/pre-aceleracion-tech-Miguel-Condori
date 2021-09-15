package com.example.demo.dto.builder;

import com.example.demo.dto.GeneroDTO;
import com.example.demo.dto.PeliculaSerieDTO;
import com.example.demo.dto.PersonajeDTO;
import com.example.demo.models.PeliculaSerie;

import java.util.Date;
import java.util.Set;

public class PeliculaSerieBuilder {

    private String imagen;
    private String titulo;
    private Date fechaCreacion;
    private int calificacion;
    private Set<PersonajeDTO> personajes;
    private Set<GeneroDTO> generos;

    public PeliculaSerieBuilder withPeliculaSerie(PeliculaSerie ps) {
        this.imagen = ps.getImagen();
        this.titulo = ps.getTitulo();
        this.fechaCreacion = ps.getFechaCreacion();
        this.calificacion = ps.getCalificacion();
        return this;
    }

    public PeliculaSerieBuilder withPeliculaSerieDTO(PeliculaSerieDTO peliculaSerieDTO) {
        this.imagen = peliculaSerieDTO.getImagen();
        this.titulo = peliculaSerieDTO.getTitulo();
        this.fechaCreacion = peliculaSerieDTO.getFechaCreacion();
        this.calificacion = peliculaSerieDTO.getCalificacion();
        this.personajes = peliculaSerieDTO.getPersonajes();
        this.generos = peliculaSerieDTO.getGeneros();
        return this;
    }

    public PeliculaSerie build(){
        return new PeliculaSerie(imagen, titulo, fechaCreacion, calificacion);
    }
    public PeliculaSerieDTO buildDTO(){
        return new PeliculaSerieDTO(imagen, titulo, fechaCreacion, calificacion, personajes, generos);
    }
}
