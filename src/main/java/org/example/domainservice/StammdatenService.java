package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.*;

import java.util.List;

@DomainService
public class StammdatenService {

    private final AutoRepository autoRepository;

    public StammdatenService(AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }

    public void initStammdaten(){

        final Auto porsche = new Auto(new AutoDaten(10, 5, "Porsche"), new EmailAdresse("ruppenthal.timo@gmail.com"));
        final Auto bugatti = new Auto(new AutoDaten(22, 5, "Bugatti"), new EmailAdresse("planta.jeremie@gmail.com"));

        List<Auto> alleAutos = autoRepository.getAll();
        if(!alleAutos.contains(porsche)){
            autoRepository.add(porsche);
        }
        if(!alleAutos.contains(bugatti)){
            autoRepository.add(bugatti);
        }
        autoRepository
                .getAll()
                .forEach( element -> System.out.println(element.getMarke()));
    }
}
