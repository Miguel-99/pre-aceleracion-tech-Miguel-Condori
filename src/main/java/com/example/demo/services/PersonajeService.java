package com.example.demo.services;

import com.example.demo.model.Personaje;
import org.springframework.stereotype.Service;

@Service
public interface IPersonaje {
    Personaje getPersonaje(Long id);
    Personaje createPersonaje(Personaje personaje); //recibe dto

}
