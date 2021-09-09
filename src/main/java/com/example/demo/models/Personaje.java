package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personaje")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Personaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "peso")
    private float peso;

    @Column(name = "historia")
    private String historia;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "personaje_pelicula_serie",
//        joinColumns = @JoinColumn(name = "id_personaje"),
//        inverseJoinColumns = @JoinColumn(name = "id_pelicula_serie"))
//    private Set<PeliculaSerie> peliculas_series;

}
