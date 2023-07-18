package org.example.domainservice;

import org.example.domain.Auto;
import org.example.domain.AutoRepository;

import java.util.List;

public class StammdatenService {
    private final AutoRepository autoRepository;

    public StammdatenService(AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }

    public void initStammdaten(){
        List<Auto> alleAutos = autoRepository.getAll();
        if(!alleAutos.contains(new Auto(10, 5, "Porsche"))){
            autoRepository.add(new Auto(10, 5, "Porsche"));
        }
        if(!alleAutos.contains(new Auto(22, 5, "Bugatti"))){
            autoRepository.add(new Auto(22, 5, "Bugatti"));
        }
        autoRepository
                .getAll()
                .forEach( element -> System.out.println(element.getMarke()));
    }
}
