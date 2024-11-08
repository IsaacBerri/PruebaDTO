package com.nodo.demo.Controllers;

import com.nodo.demo.Models.RespuestasMongo;
import com.nodo.demo.Service.RespuestasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RespuestaController {

    @Autowired
    private RespuestasService respuestasService;

    @GetMapping("/respuestas")
    public List<RespuestasMongo> find(){
        try{
            return respuestasService.find();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/respuestas")
    public String create(@RequestBody RespuestasMongo respuesta){
        respuestasService.create(respuesta);
        return "El registro se creo exitosamente";
    }
}
