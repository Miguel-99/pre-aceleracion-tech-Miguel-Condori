package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pelicula_serie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pelicula_Serie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imagen;

    @Column
    private String titulo;

    @Column
    private Date fecha_creacion;

    @Column
    private int calificacion;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @ManyToMany(mappedBy = "peliculas_series")
//    private Set<Personaje> personajes;
//
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "pelicula_serie_genero",
//        joinColumns = @JoinColumn(name = "id_pelicula_serie"),
//        inverseJoinColumns = @JoinColumn(name = "id_genero"))
//    private Set<Genero> generos;
}
