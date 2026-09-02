package ar.edu.unq.po2.tp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EquipoDeTrabajoTest {
    EquipoDeTrabajo equipoDeTrabajo;
    Persona persona1;
    Persona persona2;
    Persona persona3;
    Persona persona4;
    Persona persona5;
    @BeforeEach
    public void setUp() {
        equipoDeTrabajo = new EquipoDeTrabajo("Suweb");
        persona1 = new Persona("Leonardo", "Barigelli", LocalDate.of(1980, 2, 3));
        persona2 = new Persona("Franco", "Barigelli", LocalDate.of(2005, 4, 1));
        persona3 = new Persona("Emilce", "Casco", LocalDate.of(1980, 12, 31));
        persona4 = new Persona("Alan", "Appio", LocalDate.of(2006, 12, 18));
        persona5 = new Persona("Aime", "Caricatto", LocalDate.of(2006, 11, 20));
        equipoDeTrabajo.addIntegrante(persona1);
        equipoDeTrabajo.addIntegrante(persona2);
        equipoDeTrabajo.addIntegrante(persona3);
        equipoDeTrabajo.addIntegrante(persona4);
        equipoDeTrabajo.addIntegrante(persona5);
    }

    @Test
    public void getNombreTest() {
        assertEquals("Suweb", equipoDeTrabajo.getNombre());
    }

    @Test
    public void setNombreTest() {
        equipoDeTrabajo.setNombre("Java");
        assertEquals("Java", equipoDeTrabajo.getNombre());
    }

    @Test
    public void edadTotalIntegrantesTest() {
        assertEquals(150, equipoDeTrabajo.edadTotalIntegrantes());
    }

    @Test
    public void promedioEdadIntegrantesTest() {
        assertEquals(30, equipoDeTrabajo.promedioEdadIntegrantes());
    }
}
