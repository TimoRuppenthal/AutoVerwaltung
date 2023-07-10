package org.example.domain;

import java.util.Objects;

public class Auto {
    private final int sitzplätze;
    private final String marke;
    private final int verbrauch;

    public Auto(int verbrauch, int sitzplätze, String marke) {
        this.verbrauch = verbrauch;
        this.sitzplätze = sitzplätze;
        this.marke = marke;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(verbrauch, auto.verbrauch) && Objects.equals(sitzplätze, auto.sitzplätze) && Objects.equals(marke, auto.marke);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verbrauch, sitzplätze, marke);
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
}
