package org.example.infrastructure.drivenadapter.persistence;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.Auto;
import org.example.domain.AutoRepository;

import java.util.List;
import java.util.Properties;
import org.example.domain.Fahrzeugidentifikationsnummer;

@DrivenAdapter
public class AutoRepositoryImpl implements AutoRepository {

    private final IRepository<Auto, Fahrzeugidentifikationsnummer> repository;

    public AutoRepositoryImpl(Properties properties){
        this.repository = RepositoryManager.getRepository(Auto.class, Auto::getFahrzeugidentifikationsnummer, properties);
    }
    public List<Auto> getAll(){
        return repository.get();
    }

    public void remove (Auto auto) {
        repository.remove(auto.getFahrzeugidentifikationsnummer());
    }
    public void add (Auto auto){
        repository.add(auto);
    }

}
