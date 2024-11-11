package com.nodo.demo.Service;

import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.jpa.repository.JpaRepository;

@Service
public class GenericEntityService {
    public static  <T> T findOrCreate(
            JpaRepository<T, Integer> repository,
            Function<T, Boolean> existsPredicate,
            T entity
    ) {

        Optional<T> existingEntity = repository.findAll().stream()
                .filter(existsPredicate::apply)
                .findFirst();


        return existingEntity.orElseGet(() -> repository.save(entity));
    }
}
