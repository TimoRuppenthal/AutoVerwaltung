package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.domain.Auto;
import org.example.domain.AutoRepository;
import org.example.domain.AutoVerwaltung;
import org.example.domainservice.StammdatenService;
import java.util.Properties;
import org.example.infrastructure.drivenadapter.persistence.AutoRepositoryImpl;

public class Main {

    @SuppressWarnings("java:S106")// Okay da Demoprojekt
    public static void main(String[] args) {
        AutoRepository autoRepository = new AutoRepositoryImpl(new Properties());
        AutoVerwaltung autoVerwaltung = new AutoVerwaltung(autoRepository);

        StammdatenService stammdatenService = new StammdatenService(autoRepository);
        stammdatenService.initStammdaten();

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