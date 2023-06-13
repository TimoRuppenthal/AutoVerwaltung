package org.example;

public class Auto {
    private final int sitzplätze;
    private final String marke;
    private final int verbrauch;

    public Auto(int verbrauch, int sitzplätze, String marke) {
        this.verbrauch = verbrauch;
        this.sitzplätze = sitzplätze;
        this.marke = marke;

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
