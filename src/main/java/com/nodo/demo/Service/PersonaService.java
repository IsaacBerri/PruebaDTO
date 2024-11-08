package com.nodo.demo.Service;

import com.nodo.demo.Models.Personas;
import com.nodo.demo.Models.Trabajo;
import com.nodo.demo.Repositories.PersonaRepository;
import com.nodo.demo.Repositories.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private TrabajoRepository trabajoRepository;

    public void create(Personas persona){
        Optional<Trabajo> optionalTrabajo = trabajoRepository.findByNombreTrabajo(persona.getTrabajo().getNombreTrabajo());

        Trabajo trabajo;
        if (optionalTrabajo.isPresent()) {
            trabajo = optionalTrabajo.get();
        }else{
            trabajo = new Trabajo();
            trabajo.setNombreTrabajo(persona.getTrabajo().getNombreTrabajo());
            trabajo = trabajoRepository.save(trabajo);
        }

        Personas personas = new Personas();
        personas.setNombre(persona.getNombre());
        personas.setTrabajo(trabajo);

        personaRepository.save(personas);
        System.out.println("La persona ha sido creada");
    }

    public List<Personas> findAll(){
        return personaRepository.findAll();
    }


    public Optional<Personas> findById(int id) {
        return personaRepository.findById(id);
    }

    public String delete(int id){
        personaRepository.deleteById(id);
        return "La persona con ID: " + id + " ha sido eliminada";
    }
}
