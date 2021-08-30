package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personaje")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private byte peso;

    @Column(name = "historia")
    private String historia;

    //relacion con serie/pelicula
}
