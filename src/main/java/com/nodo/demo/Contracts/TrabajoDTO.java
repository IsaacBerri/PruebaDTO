package com.nodo.demo.Contracts;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class TrabajoDTO {
    @NotEmpty(message = "El nombre del trabajo es obligatorio")
    private String nombre;
}
