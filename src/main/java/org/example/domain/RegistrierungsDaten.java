package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.UUID;

import static org.example.domain.DomainEventPublisher.publish;

@Aggregate
public class RegistrierungsDaten {
    private final AutoDaten autoDaten;
    private final EmailAdresse emailAdresse;
    private final VerifizierungsCode verifizierungsCode;

    public RegistrierungsDaten(EmailAdresse emailAdresse, AutoDaten autoDaten) {
        this.emailAdresse = emailAdresse;
        this.autoDaten = autoDaten;
        this.verifizierungsCode = new VerifizierungsCode(UUID.randomUUID().toString());
    }

    public VerifizierungsCode getVerifizierungsCode() {
        return verifizierungsCode;
    }

    public AutoDaten getAutoDaten() {
        return autoDaten;
    }
    public void verifiziere(VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {
        if (this.verifizierungsCode != verifizierungsCode) {
            throw new UngueltigerVerifizierungsCode();
        }
    }

    public void sendVerifizierungsCode(){
        publish(new VerifizierungsCodeVerschickt(verifizierungsCode));
    }
    @AggregateID
    public EmailAdresse getEmailAdresse() {
        return emailAdresse;
    }
}
