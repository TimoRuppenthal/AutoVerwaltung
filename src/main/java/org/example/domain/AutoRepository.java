package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoRepository {
    List<Auto> getAll();

    void remove(EmailAdresse emailAdresse);

    void add(Auto auto);
    Optional<Auto> get(EmailAdresse emailAdresse);

    void update(Auto auto);
}
