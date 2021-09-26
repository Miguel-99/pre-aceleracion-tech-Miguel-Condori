package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor

public class Characters implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String image;

    @Column(nullable = false, length = 50)
    private String name;

    @Column
    private Integer age;

    @Column
    private Float weight;

    @Column
    private String history;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "character_movie_serie",
        joinColumns = @JoinColumn(name = "fk_character"),
        inverseJoinColumns = @JoinColumn(name = "fk_movie_serie"))
    private Set<MovieSerie> movieSeries;

}
