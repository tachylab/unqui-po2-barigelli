package ar.edu.unq.po2.tp6.banco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Persona cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Persona(30, "Franco", "Barigelli", "Calle Falsa 123", 2000);
    }

    @Test
    public void edadTest() {
        assertEquals(30, cliente.edad());
    }

    @Test
    public void nombreTest() {
        assertEquals("Franco", cliente.nombre());
    }

    @Test
    public void apellidoTest() {
        assertEquals("Barigelli", cliente.apellido());
    }

    @Test
    public void direccionTest() {
        assertEquals("Calle Falsa 123", cliente.direccion());
    }

    @Test
    public void sueldoNetoMensualTest() {
        assertEquals(2000, cliente.sueldoNetoMensual());
    }

    @Test
    public void sueldoNetoAnualTest() {
        assertEquals(24000, cliente.sueldoNetoAnual());
    }

}
