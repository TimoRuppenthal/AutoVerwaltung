package org.example.domain;
import io.jexxa.addend.applicationcore.Repository;
import java.util.List;
@Repository
public interface RegistrierungsDatenRepository {
    List<RegistrierungsDaten> getAll();

    void remove(EmailAdresse eMailAdresse);

    void add(RegistrierungsDaten registrierungsDaten);

    RegistrierungsDaten get(EmailAdresse eMailAdresse);
}
