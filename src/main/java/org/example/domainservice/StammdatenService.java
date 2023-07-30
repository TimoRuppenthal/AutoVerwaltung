package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.Auto;
import org.example.domain.AutoRepository;
import org.example.domain.AutoDaten;
import org.example.domain.Fahrzeugidentifikationsnummer;

import java.util.List;

@DomainService
public class StammdatenService {

    private final AutoRepository autoRepository;

    public StammdatenService(AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }

    public void initStammdaten(){

        final Auto Porsche = new Auto(new AutoDaten(10, 5, "Porsche"), new Fahrzeugidentifikationsnummer(123));
        final Auto Bugatti = new Auto(new AutoDaten(22, 5, "Bugatti"), new Fahrzeugidentifikationsnummer(234));

        List<Auto> alleAutos = autoRepository.getAll();
        if(!alleAutos.contains(Porsche)){
            autoRepository.add(Porsche);
        }
        if(!alleAutos.contains(Bugatti)){
            autoRepository.add(Bugatti);
        }
        autoRepository
                .getAll()
                .forEach( element -> System.out.println(element.getMarke()));
    }
}
