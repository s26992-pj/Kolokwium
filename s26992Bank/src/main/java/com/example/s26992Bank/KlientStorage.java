package com.example.s26992Bank;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KlientStorage {
    private static List<Klient> KlientList;

    public KlientStorage() {
        this.KlientList = new ArrayList<>();
    }
    public void addKlient(Klient klient) {
        KlientList.add(klient);
    }

    public static List<Klient> getCustomerList() {
        return KlientList;
    }
    public void clearData() {
        KlientList.clear();
    }
}
