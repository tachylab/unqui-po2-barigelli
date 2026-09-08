package ar.edu.unq.po2.tp4.trabajador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IngresoTest {

    private Ingreso ingreso;
    private Ingreso ingreso2;

    @BeforeEach
    public void setUpTest() {
        ingreso = new Ingreso("Agosto", "Sueldo", 100);
        ingreso2 = new Ingreso("Septiembre", "Sueldo", 200);
    }

    @Test
    public void constructorTest() {
        assertEquals("Agosto", ingreso.getMesPercepcion());
        assertEquals("Septiembre", ingreso2.getMesPercepcion());
        assertEquals("Sueldo", ingreso.getConcepto());
        assertEquals(100, ingreso.getMontoPercibido());
        assertEquals(200, ingreso2.getMontoPercibido());
    }

    @Test
    public void getMontoImponibleTest() {
        assertEquals(100, ingreso.getMontoImponible());
        assertEquals(200, ingreso2.getMontoImponible());
    }
}
