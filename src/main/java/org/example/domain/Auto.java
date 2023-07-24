package org.example.domain;

import java.util.Objects;

public class Auto {
    private final int sitzplätze;
    private final String marke;
    private final int verbrauch;

    private final int fahrzeugidentifikationsnummer;

    public Auto(int verbrauch, int sitzplätze, String marke, int fahrzeugidentifikationsnummer) {
        this.verbrauch = verbrauch;
        this.sitzplätze = sitzplätze;
        this.marke = marke;
        this.fahrzeugidentifikationsnummer = fahrzeugidentifikationsnummer;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(verbrauch, auto.verbrauch) && Objects.equals(sitzplätze, auto.sitzplätze) && Objects.equals(marke, auto.marke) && Objects.equals(fahrzeugidentifikationsnummer, auto.fahrzeugidentifikationsnummer);
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

    public int getFahrzeugidentifikationsnummer() { return fahrzeugidentifikationsnummer; }
}
