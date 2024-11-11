package com.nodo.demo.Service;

import com.nodo.demo.Contracts.PersonaDTO;
import com.nodo.demo.Models.Personas;
import com.nodo.demo.Models.Trabajo;
import com.nodo.demo.Repositories.PersonaRepository;
import com.nodo.demo.Repositories.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private TrabajoRepository trabajoRepository;

    public void create(PersonaDTO personaDTO){

        Trabajo trabajo = new Trabajo();
        trabajo.setNombreTrabajo(personaDTO.getNombreDeTrabajo());
                trabajo = GenericEntityService.findOrCreate(trabajoRepository,
                existingTrabajo -> existingTrabajo.getNombreTrabajo().equals(personaDTO.getNombreDeTrabajo()),
                trabajo);

        Personas personas = new Personas();
        personas.setNombre(personaDTO.getNombre());
        personas.setTrabajo(trabajo);

        personaRepository.save(personas);
        System.out.println("La persona ha sido creada");
    }

    public List<PersonaDTO> findAll(){
        return personaRepository.findAll().stream().map(persona -> {
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setNombre(persona.getNombre());
            personaDTO.setNombreDeTrabajo(persona.getTrabajo().getNombreTrabajo());
            return personaDTO;
        }).collect(Collectors.toList());
    }


    public Optional<PersonaDTO> findById(int id) {
        Optional<Personas> persona = personaRepository.findById(id);
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombre(persona.get().getNombre());
        personaDTO.setNombreDeTrabajo(persona.get().getTrabajo().getNombreTrabajo());
        return Optional.of(personaDTO);
    }

    public String delete(int id){
        personaRepository.deleteById(id);
        return "La persona con ID: " + id + " ha sido eliminada";
    }
}
