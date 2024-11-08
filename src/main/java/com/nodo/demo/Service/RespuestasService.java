package com.nodo.demo.Service;

import com.nodo.demo.Models.RespuestasMongo;
import com.nodo.demo.Repositories.RespuestasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestasService {

    @Autowired
    private RespuestasRepository respuestasRepository;

    public List<RespuestasMongo> find(){
        return respuestasRepository.findAll();
    }

    public RespuestasMongo create(RespuestasMongo respuesta){
        return respuestasRepository.save(respuesta);
    }
}
