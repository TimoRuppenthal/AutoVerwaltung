package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;
@Aggregate
public class Auto {
    private AutoDaten autoDaten;

    private final EmailAdresse emailAdresse;

    public Auto(AutoDaten autoDaten, EmailAdresse emailAdresse) {
        this.autoDaten = autoDaten;
        this.emailAdresse = emailAdresse;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(getEmailAdresse(), auto.getEmailAdresse());
    }

@SuppressWarnings("java:S106")
    public int getVerbrauch() {
        return autoDaten.verbrauch();
    }

    public int getSitzplaetze() {
        return autoDaten.sitzplaetze();
    }

    public String getMarke() {
        return autoDaten.marke();
    }
    @AggregateID
    public EmailAdresse getEmailAdresse() { return emailAdresse; }
    public void setAutoDaten(AutoDaten autoDaten){
        this.autoDaten = autoDaten;
    }
}
