package org.example;

import java.util.List;

public class Main {
    @SuppressWarnings("java:S106")// Okay da Demoprojekt
    public static void main(String[] args) {
        AutoVerwaltung autoVerwaltung = new AutoVerwaltung();
        Auto porsche =new Auto("10l/100km","5 Sitzplätze","Porsche");
        Auto bugatti =new Auto("22l/100km","5 Sitzplätze","Bugatti");
        autoVerwaltung.add(porsche);
        autoVerwaltung.add(bugatti);
        autoVerwaltung.delete(bugatti);

        List<Auto> alleAutos = autoVerwaltung.get();
        alleAutos.forEach( element -> System.out.println(element.getMarke()));
        alleAutos.forEach( element -> System.out.println(element.getVerbrauch()));
        alleAutos.forEach( element -> System.out.println(element.getSitzplätze()));
    }
}