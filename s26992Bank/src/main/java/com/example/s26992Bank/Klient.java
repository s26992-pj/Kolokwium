package com.example.s26992Bank;

public class Klient {
    int identyfikator;
    int Saldo;

    public Klient(int identyfikator, int saldo) {
        this.identyfikator = identyfikator;
        Saldo = saldo;
    }

    public int getIdentyfikator() {
        return identyfikator;
    }

    public void setIdentyfikator(int identyfikator) {
        this.identyfikator = identyfikator;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int saldo) {
        Saldo = saldo;
    }


    @Override
    public String toString() {
        return "Klient{" +
                "identyfikator=" + identyfikator +
                ", Saldo=" + Saldo +
                '}';
    }
}
