package com.nodo.demo.Repositories;

import com.nodo.demo.Models.RespuestasMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestasRepository extends MongoRepository<RespuestasMongo, String> {
}
