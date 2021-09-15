package com.example.demo.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDTO {

    private String imagen;
    private String nombre;
    private int edad;
    private float peso;
    private String historia;
}
