package com.example.demo.repositories;

import com.example.demo.models.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Characters, Long> {
    Optional<Characters> findById(Long id);
    List<Characters> findAll();
    void deleteById(Long id);
    List<Characters> findByName(String name);
    List<Characters> findByAge(Integer age);
    List<Characters> findByMovieSeries_Id(Long id);

}