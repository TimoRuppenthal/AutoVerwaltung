package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RegistrierungsDatenTest {
    @Test
    void testErstelleVerifizierungsCode(){
        //Arrange
        var emailAdresse = new EmailAdresse("rpthl@gmail.com");
        var autoDaten = new AutoDaten(14, 4, "RenaultA5");
        var objectUnderTest = new RegistrierungsDaten(emailAdresse, autoDaten);
        var receivedDomainEvents = new ArrayList<VerifizierungsCodeVerschickt>();

        DomainEventPublisher.subscribe(VerifizierungsCodeVerschickt.class, receivedDomainEvents::add);

        //Act
        objectUnderTest.sendVerifizierungsCode();

        //Assert
        assertEquals(1, receivedDomainEvents.size());
        //Note: A UUID actually a 128 bit value (2 long). To represent 128 bit into hex string there will be 128/4=32 char (each char is 4bit long). In string format it also contains 4 (-) that's why the length is 36.
        assertEquals(36, receivedDomainEvents.get(0).verifizierungsCode().verifizierungsCode().length());
    }
}
