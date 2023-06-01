package org.example;

import java.util.ArrayList;
import java.util.List;

public class AutoVerwaltung {
    private final List<Auto> autoList = new ArrayList<>();

    public void add(Auto auto){
        autoList.add(auto);
    }
    public void delete(Auto auto){
        autoList.remove(auto);
    }
    public List<Auto> get() {
        return autoList;
    }
}
