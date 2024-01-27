package com.example.s26992Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TranzakcjaStorage {
    private List<Tranzakcja> tranzakcjaList;

    public TranzakcjaStorage() {
        this.tranzakcjaList = new ArrayList<>();
    }
    public void addTranzakcja(Tranzakcja tranzakcja) {
        tranzakcjaList.add(tranzakcja);
    }

    public List<Tranzakcja> getTranzakcjaList() {
        return tranzakcjaList;
    }
    public void clearData() {
        tranzakcjaList.clear();
    }
}
