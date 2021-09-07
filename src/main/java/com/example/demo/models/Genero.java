package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "genero")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String imagen;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @ManyToMany(mappedBy = "generos")
//    private Set<Pelicula_Serie> peliculas_series;
}
