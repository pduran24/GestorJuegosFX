package org.example.gestorjuegosfx.data;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    /* Métodos de escritura */
    Optional<T> save(T t);
    Optional<T> update(T t);
    Optional<T> delete(T t);

    /* Métodos de lectura */
    List<T> findAll();
    Optional<T> findById(Integer id);



    //SELECT ... FROM tabla1 INNER JOIN tabla2 ON tabla1.columna = tabla2.columna
}
