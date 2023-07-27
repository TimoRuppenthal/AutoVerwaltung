package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.Auto;
import org.example.domain.AutoRepository;

import java.util.List;

@DomainService
public class StammdatenService {


    private static final Auto Porsche = new Auto(10, 5, "Porsche", 123);
    private static final Auto Bugatti = new Auto(22, 5, "Bugatti", 234);


    private final AutoRepository autoRepository;

    public StammdatenService(AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }

    public void initStammdaten(){
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
