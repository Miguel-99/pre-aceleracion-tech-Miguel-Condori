package com.example.demo.dto.builder;

import com.example.demo.dto.GeneroDTO;
import com.example.demo.models.Genero;

public class GeneroBuilder {

    private String nombre;
    private String imagen;

    public GeneroBuilder withGenero(Genero genero) {
        this.nombre = genero.getNombre();
        this.imagen = genero.getImagen();
        return this;
    }

    public GeneroBuilder withGeneroDTO(GeneroDTO generoDTO) {
        this.nombre = generoDTO.getNombre();
        this.imagen = generoDTO.getImagen();
        return this;
    }

    public Genero build() {
        return new Genero(nombre,imagen);
    }
}
