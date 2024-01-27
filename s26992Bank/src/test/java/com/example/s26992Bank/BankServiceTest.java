package com.example.s26992Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankServiceTest {


    @Autowired
    private BankService bankService;

    @Autowired
    private KlientStorage klientStorage;

    @Autowired
    private TranzakcjaStorage tranzakcjaStorage;



    @BeforeEach
    void clearData() {
        klientStorage.clearData();
        tranzakcjaStorage.clearData();
    }

    @Test
    void rejestracjaKlienta() {
        //Before
            Klient klient = new Klient(1,123);
            klientStorage.addKlient(klient);
        //When
            String result = bankService.RejestracjaKlienta(1, 1234);
        //then
            assertThat(result).isEqualTo("Klient Zarejestrowany");

    }

    @Test
    void findKlientById() {
        //Before
        Klient klient = new Klient(1,123);
        klientStorage.addKlient(klient);
        //When
        Klient result = bankService.findKlientById(1);
        //then
        assertThat(result).isEqualTo(klient);

    }

    @Test
    void tranzakcjaPlacing() {
        //Before
        Klient klient = new Klient(1,123);
        klientStorage.addKlient(klient);


        //When
        String result = bankService.TranzakcjaPlacing(1,100);
        //then
        assertThat(result).isEqualTo("Status :" + Status.ACCEPTED + klient.getSaldo());
    }

    @Test
    void wplata() {
        //Before
        Klient klient = new Klient(1,123);
        klientStorage.addKlient(klient);


        //When
        String result = bankService.TranzakcjaPlacing(1,100);
        //then
        assertThat(result).isEqualTo("Status :" + Status.ACCEPTED + klient.getSaldo());
    }

    @Test
    void odczytaj() {
        Klient klient = new Klient(1,123);
        klientStorage.addKlient(klient);
        //When
        String result = bankService.Odczytaj(1);
        //then
        assertThat(result).isEqualTo(klient.toString());
    }
}