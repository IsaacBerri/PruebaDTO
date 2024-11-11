package com.nodo.demo.Contracts;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDTO {

    @NotEmpty(message = "El nombre es obligatorio")
    private String nombre;

    @NotEmpty(message = "El nombre del trabajo es obligatorio")
    private String nombreDeTrabajo;
}
