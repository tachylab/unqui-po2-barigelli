package ar.edu.unq.po2.tp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaTest {
    Persona persona;

    @BeforeEach
    public void setUp() {
        persona = new Persona("Franco", "Barigelli", LocalDate.of(2005, 4, 1));
    }

    @Test
    public void getNombreTest() {
        assertEquals("Franco", persona.nombre);
    }

    @Test
    public void getApellidoTest() {
        assertEquals("Barigelli", persona.apellido);
    }

    @Test
    public void getFechaNacimientoTest() {
        assertEquals(LocalDate.of(2005, 4, 1), persona.fechaNacimiento);
    }

    @Test
    public void edadTest() {
        assertEquals(21, persona.edad());
    }

    @Test
    public void menorQueTest() {
        Persona persona2 = new Persona("Emilce", "Casco", LocalDate.of(1980, 12, 31));
        assertTrue(persona.menorQue(persona2));
    }

}
