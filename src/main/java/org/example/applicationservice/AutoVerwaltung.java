package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.*;
import java.util.List;

@ApplicationService
public class AutoVerwaltung {
    private final AutoRepository autoRepository;

    public void add(EmailAdresse emailAdresse, AutoDaten autoDaten){
        autoRepository.add(new Auto(autoDaten, emailAdresse));
    }
    @SuppressWarnings("unused")
    public void delete(EmailAdresse emailAdresse){
        autoRepository.remove(emailAdresse);
    }

    public List<EmailAdresse> get(){
        return autoRepository.getAll()
                .stream()
                .map(Auto::getEmailAdresse)
                .toList();
    }
    public AutoVerwaltung (AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }
    public void registriere(EmailAdresse emailAdresse, AutoDaten autoDaten){
    }
    public void verifiziere(EmailAdresse emailAdresse, VerifizierungsCode verifizierungsCode){
    }
}