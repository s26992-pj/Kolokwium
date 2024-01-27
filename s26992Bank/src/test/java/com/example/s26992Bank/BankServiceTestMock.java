package com.example.s26992Bank;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankServiceTestMock {
    @Mock
    private TranzakcjaStorage tranzakcjaStorage;

    @InjectMocks
    private BankService bankService;

    @Test
    void shouldDoSomething() {
        when(tranzakcjaStorage.getTranzakcjaList())
                .thenReturn(List.of(new Tranzakcja(new Klient(1,123), 15)));
        String result = bankService.TranzakcjaPlacing(1,100);
        assertThat(result).isEqualTo(tranzakcjaStorage.getTranzakcjaList().contains(new Tranzakcja(new Klient(1,123), 15)));
    }
}
