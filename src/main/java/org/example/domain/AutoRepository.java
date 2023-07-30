package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;

@Repository
public interface AutoRepository {
    List<Auto> getAll();

    void remove(Fahrzeugidentifikationsnummer fahrzeugidentifikationsnummer);

    void add(Auto auto);
}
