package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.Auto;
import org.example.domain.AutoRepository;
import org.example.domain.Fahrzeugidentifikationsnummer;

import java.util.List;

@ApplicationService
public class AutoVerwaltung {
    private final AutoRepository autoRepository;

    public void add(Auto auto){
        autoRepository.add(auto);
    }
    @SuppressWarnings("unused")
    public void delete(Auto auto){
        autoRepository.remove(auto);
    }

    public List<Fahrzeugidentifikationsnummer> get(){
        return autoRepository.getAll().stream().map(Auto::getFahrzeugidentifikationsnummer).toList();
    }
    public AutoVerwaltung (AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }
}