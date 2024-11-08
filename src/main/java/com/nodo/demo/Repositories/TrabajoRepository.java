package com.nodo.demo.Repositories;

import com.nodo.demo.Models.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
    Optional<Trabajo> findByNombreTrabajo(String nombreTrabajo);
}
