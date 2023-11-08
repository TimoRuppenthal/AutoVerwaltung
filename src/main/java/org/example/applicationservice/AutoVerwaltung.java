package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.*;
import org.example.domainservice.VerifizierungsCodeSender;
import java.util.List;

@ApplicationService
public class AutoVerwaltung {
    private final AutoRepository autoRepository;
    private final RegistrierungsDatenRepository registrierungsDatenRepository;

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
    public AutoVerwaltung (AutoRepository autoRepository, RegistrierungsDatenRepository registrierungsDatenRepository){
        this.autoRepository = autoRepository;
        this.registrierungsDatenRepository = registrierungsDatenRepository;
    }
    public void registriere(EmailAdresse emailAdresse, AutoDaten autoDaten){registrierungsDatenRepository.add(new RegistrierungsDaten(emailAdresse, autoDaten));
    }
    public void verifiziere(EmailAdresse emailAdresse, VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {RegistrierungsDaten registrierungsDaten = registrierungsDatenRepository.get(emailAdresse).orElseThrow();
        add(emailAdresse, registrierungsDaten.getAutoDaten());
        registrierungsDatenRepository.remove(emailAdresse);
    }
    public  void aktualisiereAutoDaten(EmailAdresse emailAdresse, AutoDaten autoDaten){
        Auto auto = autoRepository.get(emailAdresse).orElseThrow();
        auto.setAutoDaten(autoDaten);
        autoRepository.update(auto);
    }
}