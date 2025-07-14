package com.thourie.flightservice.daos;

import java.util.List;
import java.util.Optional;

public interface Dao<ENTITY, ID> {

    List<ENTITY> findAll();
    Optional<ENTITY> findById(ID id);
    boolean delete(ID id);
    ENTITY save(ENTITY entity);
    void update(ENTITY entity);
}
