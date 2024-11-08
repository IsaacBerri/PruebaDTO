package com.nodo.demo.Controllers;


import com.nodo.demo.Models.Personas;
import com.nodo.demo.Service.PersonaService;
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
    public List<Personas> findAll(){
        return personaService.findAll();
    }

    @GetMapping("/persona/{id}")
    public Optional<Personas> findById(@PathVariable int id){
        return personaService.findById(id);
    }

    @PostMapping("/personas")
    public String create(@RequestBody Personas persona){
        personaService.create(persona);
       return "Persona creada con exito";
    }

    @DeleteMapping("/persona/{id}")
    public String delete(@PathVariable int id){
        return personaService.delete(id);
    }
}
