package ar.edu.unq.po2.tp4.trabajador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrabajadorTest {
    private Trabajador trabajador;
    private Ingreso ingreso;
    private Ingreso ingreso2;
    private IngresoHorasExtra ingresoExtra;
    private IngresoHorasExtra ingresoExtra2;

    @BeforeEach
    public void setUp() {
        trabajador = new Trabajador();
        ingreso = new Ingreso("Agosto", "Sueldo", 100);
        ingreso2 = new Ingreso("Septiembre", "Sueldo", 200);
        ingresoExtra = new IngresoHorasExtra("Agosto", "Extra", 50, 5);
        ingresoExtra2 = new IngresoHorasExtra("Septiembre", "Extra", 80, 9);
        trabajador.agregarIngreso(ingreso);
        trabajador.agregarIngreso(ingreso2);
        trabajador.agregarIngreso(ingresoExtra);
        trabajador.agregarIngreso(ingresoExtra2);
    }

    @Test
    public void getTotalPercibidoTest() {
        assertEquals(430, trabajador.getTotalPercibido());
    }

    @Test
    public void getMontoImponibleTest() {
        assertEquals(300, trabajador.getMontoImponible());
    }

    @Test
    public void getImpuestoAPagar() {
        assertEquals(6, trabajador.getImpuestoAPagar());
    }


}
