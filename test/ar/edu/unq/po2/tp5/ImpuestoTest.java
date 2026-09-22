package ar.edu.unq.po2.tp5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImpuestoTest {

    public Impuesto IVA;

    @BeforeEach
    public void setUp() {
        IVA = new Impuesto(20);
    }

    @Test
    public void montoAPagar() {
        assertEquals(20, IVA.montoAPagar());
    }
}
