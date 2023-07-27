package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;

@Repository
public interface AutoRepository {
    List<Auto> getAll();

    void remove(Auto auto);

    void add(Auto auto);
}
