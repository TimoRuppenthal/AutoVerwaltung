package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;
@Aggregate
public class Auto {
    private final int sitzplätze;
    private final String marke;
    private final int verbrauch;

    private final Fahrzeugidentifikationsnummer fahrzeugidentifikationsnummer;

    public Auto(int verbrauch, int sitzplätze, String marke, int fahrzeugidentifikationsnummer) {
        this.verbrauch = verbrauch;
        this.sitzplätze = sitzplätze;
        this.marke = marke;
        this.fahrzeugidentifikationsnummer = new Fahrzeugidentifikationsnummer(fahrzeugidentifikationsnummer);

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(getFahrzeugidentifikationsnummer(), auto.getFahrzeugidentifikationsnummer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(verbrauch, sitzplätze, marke, fahrzeugidentifikationsnummer);
    }
@SuppressWarnings("java:S106")
    public int getVerbrauch() {
        return verbrauch;
    }

    public int getSitzplätze() {
        return sitzplätze;
    }

    public String getMarke() {
        return marke;
    }
    @AggregateID
    public Fahrzeugidentifikationsnummer getFahrzeugidentifikationsnummer() { return fahrzeugidentifikationsnummer; }
}
