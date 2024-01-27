package com.example.s26992Bank;

public class Tranzakcja {
    private Klient klient;
    private int saldo;
    private Status status;

    public Tranzakcja(Klient klient, int saldo) {
        this.klient = klient;
        this.saldo = saldo;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;

    }

    public int getSaldo() {
        return saldo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
