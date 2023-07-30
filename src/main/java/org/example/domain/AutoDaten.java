package org.example.domain;

import io.jexxa.addend.applicationcore.ValueObject;

@ValueObject
public record AutoDaten(int verbrauch, int sitzplätze, String marke) {
}
