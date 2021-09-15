package com.example.demo.dto.builder;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.models.Personaje;

public class PersonajeBuilder {

    private String imagen;
    private String nombre;
    private int edad;
    private float peso;
    private String historia;

    public PersonajeBuilder withPersonaje(Personaje personaje) {
        this.imagen = personaje.getImagen();
        this.nombre = personaje.getNombre();
        this.edad = personaje.getEdad();
        this.peso = personaje.getPeso();
        this.historia = personaje.getHistoria();
        return this;
    }

    public PersonajeBuilder withPersonajeDTO(PersonajeDTO personajeDTO) {
        this.imagen = personajeDTO.getImagen();
        this.nombre = personajeDTO.getNombre();
        this.edad = personajeDTO.getEdad();
        this.peso = personajeDTO.getPeso();
        this.historia = personajeDTO.getHistoria();
        return this;
    }

    public Personaje build(){
        return new Personaje(imagen, nombre, edad, peso, historia);
    }
}
