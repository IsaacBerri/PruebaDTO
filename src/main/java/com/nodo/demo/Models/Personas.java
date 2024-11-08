package com.nodo.demo.Models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Personas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Getter
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "TrabajoId")
    @Getter
    private Trabajo trabajo;
}
