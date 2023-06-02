package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;

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
        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                // Bind a REST adapter to expose parts of the application
                .bind(RESTfulRPCAdapter.class).to(autoVerwaltung)               // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())  // Get stats: http://localhost:7501/BoundedContext/isRunning

                // Run your application until Ctrl-C is pressed
                .run();
    }
}