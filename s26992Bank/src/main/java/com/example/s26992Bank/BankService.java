package com.example.s26992Bank;


import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BankService {
    private final KlientStorage klientStorage;

    private final TranzakcjaStorage tranzakcjaStorage;

    public BankService(KlientStorage klientStorage, TranzakcjaStorage tranzakcjaStorage) {
        this.klientStorage = klientStorage;
        this.tranzakcjaStorage = tranzakcjaStorage;
    }

    public String RejestracjaKlienta(int identyfikator, int saldo){
        Klient klient = new Klient(identyfikator,saldo);
        klientStorage.addKlient(klient);
        return "Klient Zarejestrowany";

    }

    public Klient findKlientById(int identyfikator) {
        Klient klient = null;
        for (Klient k : KlientStorage.getCustomerList()) {
            if (k.getIdentyfikator() == identyfikator) {
                klient = k;
            }
        }
        if (klient == null) {
            throw new NoSuchElementException();
        } else {
            return klient;
        }
    }

    public String TranzakcjaPlacing(int identyfikator,int saldo){
        Klient klient = findKlientById(identyfikator);
            if (klient.getSaldo() - saldo > 0) {
                Tranzakcja tranzakcja = new Tranzakcja(klient, saldo);
                klient.setSaldo(klient.getSaldo() - saldo);
                tranzakcja.setStatus(Status.ACCEPTED);
                tranzakcjaStorage.addTranzakcja(tranzakcja);
                return "Status :" + Status.ACCEPTED + tranzakcja.getKlient().getSaldo();
            }
            else{
                return "Status :" + Status.DECLINED;
            }
        }


    public String Wplata(int identyfikator,int saldo){
        Klient klient = findKlientById(identyfikator);
        if (KlientStorage.getCustomerList().contains(klient)) {
            Tranzakcja tranzakcja = new Tranzakcja(klient, saldo);
            klient.setSaldo(klient.getSaldo() + saldo);
            tranzakcja.setStatus(Status.ACCEPTED);
            tranzakcjaStorage.addTranzakcja(tranzakcja);
            return "Status :" + Status.ACCEPTED + tranzakcja.getKlient().getSaldo();
        }
        return "Status :" + Status.DECLINED;
    }
    public String Odczytaj(int identyfikator){
        Klient klient = findKlientById(identyfikator);
        return klient.toString();

    }
}
