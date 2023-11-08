package org.example.domainservice;

import io.jexxa.addend.applicationcore.InfrastructureService;
import org.example.domain.VerifizierungsCodeVerschickt;
import org.example.domain.EmailAdresse;

public interface VerifizierungsCodeSender {
    void send(VerifizierungsCodeVerschickt verifizierungsCodeVerschickt);
}
