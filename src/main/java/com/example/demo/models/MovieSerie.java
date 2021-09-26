package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
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
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "movie_serie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieSerie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String image;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column
    private Integer score;

    @JsonIgnore
    @ManyToMany(mappedBy = "movieSeries")
    private Set<Characters> characters;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "movie_serie_genre",
        joinColumns = @JoinColumn(name = "fk_movie_serie"),
        inverseJoinColumns = @JoinColumn(name = "fk_genre"))
    private Set<Genre> genres;
}
