package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.Auto;
import org.example.domain.AutoRepository;
import org.example.domain.Fahrzeugidentifikationsnummer;
import org.example.domain.AutoDaten;

import java.util.List;

@ApplicationService
public class AutoVerwaltung {
    private final AutoRepository autoRepository;

    public void add(Fahrzeugidentifikationsnummer fahrzeugidentifikationsnummer, AutoDaten autoDaten){
        autoRepository.add(new Auto(autoDaten, fahrzeugidentifikationsnummer));
    }
    @SuppressWarnings("unused")
    public void delete(Fahrzeugidentifikationsnummer fahrzeugidentifikationsnummer){
        autoRepository.remove(fahrzeugidentifikationsnummer);
    }

    public List<Fahrzeugidentifikationsnummer> get(){
        return autoRepository.getAll()
                .stream()
                .map(Auto::getFahrzeugidentifikationsnummer)
                .toList();
    }
    public AutoVerwaltung (AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }
}