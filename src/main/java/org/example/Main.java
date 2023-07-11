package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.domain.Auto;
import org.example.domain.AutoRepository;
import org.example.domain.AutoVerwaltung;
import org.example.infrastructure.drivenadapter.persistence.AutoRepositoryImpl;

import java.util.List;

public class Main {
    public String AutoVerwaltung() {
        return "AutoVerwaltung";
    }

    @SuppressWarnings("java:S106")// Okay da Demoprojekt
    public static void main(String[] args) {
        AutoRepository autoRepository = new AutoRepositoryImpl();
        AutoVerwaltung autoVerwaltung = new AutoVerwaltung(autoRepository);
        Auto porsche =new Auto(10,5,"Porsche");
        Auto bugatti =new Auto(22,5,"Bugatti");
        autoVerwaltung.add(porsche);
        autoVerwaltung.add(bugatti);
        autoVerwaltung.delete(bugatti);

        List<Auto> alleAutos = autoVerwaltung.get();
        alleAutos.forEach( element -> System.out.println("marke: " + element.getMarke()));
        alleAutos.forEach( element -> System.out.println("verbrauch in Liter/100Km: " + element.getVerbrauch()));
        alleAutos.forEach( element -> System.out.println("sitzplätze: " + element.getSitzplätze()));
        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                // Bind a REST adapter to expose parts of the application
                .bind(RESTfulRPCAdapter.class).to(autoVerwaltung)               // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(Main.class)
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())  // Get stats: http://localhost:7501/BoundedContext/isRunning

                // Run your application until Ctrl-C is pressed
                .run();
    }
}