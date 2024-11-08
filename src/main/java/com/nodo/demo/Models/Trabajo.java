package com.nodo.demo.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@JsonSerialize
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Getter
    private String nombreTrabajo;

    public Trabajo() {}

    public Trabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
    }
}
