package testes;
import dog.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogHostTest {

    private DogHost dh1;

    @BeforeEach
    void setUp() {
        dh1 = new DogHost(3, 500, "dh1");

        dh1.adicionaDog("Julie", "André", 100);
        dh1.adicionaDog("Toto", "Maty", 100);
    }

    @Test
    void consultaHospedagemValidaMaiorQZero() {
        Dog d1 = new Dog("Julie", "André", 100);
        assertEquals(120.0, dh1.consultaValorHospedagem(d1, 3));
    }

    @Test
    void consultaHospedagemValidaZero() {
        Dog d1 = new Dog("Julie", "André", 100);
        assertEquals(0.0, dh1.consultaValorHospedagem(d1, 0));
    }

    @Test
    void consultaHospedagemInvalida() {
        Dog d1 = new Dog("Neca", "André", 100);
        try {
            dh1.consultaValorHospedagem(d1, 0);
            fail("Deve lançar exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("IllegalArgumentException", e.getMessage());
        }
    }

    @Test
    void adicionarCachorrosDemais() {
        dh1.adicionaDog("duda", "sara", 100);
        assertFalse(dh1.adicionaDog("sara", "duda", 100), "Host só permiete 3 cachorros");
    }

    @Test
    void adicionarCachorrosRacaoExcedente() {
        assertFalse(dh1.adicionaDog("sara", "duda", 500), "Host só permiete 3 cachorros");
    }
}