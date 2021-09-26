package com.example.demo.dto;

import com.example.demo.models.Characters;
import com.example.demo.models.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieSerieDTO {
    private Long id;
    private String image;
    private String title;
    private Date creationDate;
    private Integer score;
    private Set<Characters> characters;
    private Set<Genre> genres;
}
