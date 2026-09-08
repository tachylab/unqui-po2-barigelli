package ar.edu.unq.po2.tp4.trabajador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IngresoHorasExtraTest {
    private IngresoHorasExtra ingresoExtra;
    private IngresoHorasExtra ingresoExtra2;

    @BeforeEach
    public void setUp() {
        ingresoExtra = new IngresoHorasExtra("Agosto", "Extra", 50, 5);
        ingresoExtra2 = new IngresoHorasExtra("Septiembre", "Extra", 80, 9);
    }

    @Test
    public void getHorasExtraTest() {
        assertEquals(5, ingresoExtra.getHorasExtra());
        assertEquals(9, ingresoExtra2.getHorasExtra());
    }

    @Test
    public void getMontoImponibleTest() {
        assertEquals(0, ingresoExtra2.getMontoImponible());
        assertEquals(0, ingresoExtra2.getMontoImponible());
    }

}
