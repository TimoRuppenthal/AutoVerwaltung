package org.example.infrastructure.drivenadapter.persistence;

import org.example.domain.Auto;
import org.example.domain.AutoRepository;

import java.util.ArrayList;
import java.util.List;
public class AutoRepositoryImpl implements AutoRepository {
    private final List<Auto> autoList = new ArrayList<>();

    public List<Auto> getAll(){
        return autoList;
    }

    public void remove (Auto auto){
        autoList.remove(auto);
    }
    public void add (Auto auto){
        autoList.add(auto);
    }

}
