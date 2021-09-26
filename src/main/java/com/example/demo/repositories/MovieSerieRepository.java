package com.example.demo.repositories;

import com.example.demo.models.MovieSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieSerieRepository extends JpaRepository<MovieSerie, Long> {
    List<MovieSerie> findAll();
    Optional<MovieSerie> findById(Long id);
    Optional<MovieSerie> findByTitle(String title);
    List<MovieSerie> findByGenres_Id(Long id);
    List<MovieSerie> findByOrderByCreationDateAsc();
    List<MovieSerie> findByOrderByCreationDateDesc();
    List<MovieSerie> findByTitleContaining(String title);

}