package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;
@Aggregate
public class Auto {
    private final AutoDaten autoDaten;

    private final Fahrzeugidentifikationsnummer fahrzeugidentifikationsnummer;

    public Auto(AutoDaten autoDaten, Fahrzeugidentifikationsnummer fahrzeugidentifikationsnummer) {
        this.autoDaten = autoDaten;
        this.fahrzeugidentifikationsnummer = fahrzeugidentifikationsnummer;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(getFahrzeugidentifikationsnummer(), auto.getFahrzeugidentifikationsnummer());
    }

@SuppressWarnings("java:S106")
    public int getVerbrauch() {
        return autoDaten.verbrauch();
    }

    public int getSitzplätze() {
        return autoDaten.sitzplätze();
    }

    public String getMarke() {
        return autoDaten.marke();
    }
    @AggregateID
    public Fahrzeugidentifikationsnummer getFahrzeugidentifikationsnummer() { return fahrzeugidentifikationsnummer; }
}
