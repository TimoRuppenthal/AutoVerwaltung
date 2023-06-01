package org.example;

public class Auto {
    private final String verbrauch;
    private final String sitzplätze;
    private final String marke;

    public Auto(String verbrauch, String sitzplätze, String marke) {
        this.verbrauch = verbrauch;
        this.sitzplätze = sitzplätze;
        this.marke = marke;
    }
@SuppressWarnings("java:S106")
    public String getVerbrauch() {
        return verbrauch;
    }

    public String getSitzplätze() {
        return sitzplätze;
    }

    public String getMarke() {
        return marke;
    }
}
