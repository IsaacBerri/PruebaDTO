package com.nodo.demo.Controllers;


import com.nodo.demo.Contracts.PersonaDTO;
import com.nodo.demo.Models.Personas;
import com.nodo.demo.Service.PersonaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    public List<PersonaDTO> findAll(){
        return personaService.findAll();
    }

    @GetMapping("/persona/{id}")
    public Optional<PersonaDTO> findById(@PathVariable int id){
        return personaService.findById(id);
    }

    @PostMapping("/personas")
    public String create(@RequestBody @Valid PersonaDTO personaDTO){
        personaService.create(personaDTO);
        return "Persona creada con exito";
    }

    @DeleteMapping("/persona/{id}")
    public String delete(@PathVariable int id){
        return personaService.delete(id);
    }
}
