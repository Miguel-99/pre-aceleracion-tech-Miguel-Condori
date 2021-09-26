package com.example.demo.dto;


import com.example.demo.models.MovieSerie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    private Long id;
    private String image;
    private String name;
    private int age;
    private float weight;
    private String history;
    private Set<MovieSerie> movieSeries;
}
