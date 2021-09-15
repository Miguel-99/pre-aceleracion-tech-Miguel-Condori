package com.example.demo.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "personaje")
@Getter
@Setter
@NoArgsConstructor

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Personaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imagen;

    @Column
    private String nombre;

    @Column
    private int edad;

    @Column
    private float peso;

    @Column
    private String historia;

    public Personaje(String imagen, String nombre, int edad, float peso, String historia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
    }

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "personaje_pelicula_serie",
        joinColumns = @JoinColumn(name = "id_personaje"),
        inverseJoinColumns = @JoinColumn(name = "id_pelicula_serie"))
    private Set<PeliculaSerie> peliculasSeries;

}
