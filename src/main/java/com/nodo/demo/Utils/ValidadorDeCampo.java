package com.nodo.demo.Utils;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public class ValidadorDeCampo {

    public static <T> T validateOrCreate(
            JpaRepository<T, Long> repository,
            Optional<T> optionalEntity,
            Supplier<T> entitySupplier) {

        if (optionalEntity.isPresent()) {
            return optionalEntity.get();
        } else {
            T entity = entitySupplier.get();
            return repository.save(entity);
        }
    }
}
