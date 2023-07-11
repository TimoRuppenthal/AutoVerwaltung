package org.example.domain;

import java.util.List;

public interface AutoRepository {
    List<Auto> getAll();

    void remove(Auto auto);

    void add(Auto auto);
}
