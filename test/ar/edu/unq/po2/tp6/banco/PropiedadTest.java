package ar.edu.unq.po2.tp6.banco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PropiedadTest {

    private Propiedad propiedad;

    @BeforeEach
    public void setUp() {
        propiedad = new Propiedad("Casa", "Calle Falsa 123", 100000);
    }

    @Test
    public void valorFiscalTest() {
        assertEquals(100000, propiedad.valorFiscal());
    }

}
