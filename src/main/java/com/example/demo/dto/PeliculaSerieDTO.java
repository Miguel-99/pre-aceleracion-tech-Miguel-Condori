package com.example.demo.dto;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaSerieDTO {

    private String imagen;
    private String titulo;
    private Date fechaCreacion;
    private int calificacion;

    private Set<PersonajeDTO> personajes;
    private Set<GeneroDTO> generos;

}
