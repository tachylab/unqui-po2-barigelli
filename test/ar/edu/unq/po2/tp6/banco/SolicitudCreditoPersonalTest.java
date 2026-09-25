package ar.edu.unq.po2.tp6.banco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolicitudCreditoPersonalTest {

    private Persona clienteSolvente;
    private Persona clienteConPocosIngresos;

    @BeforeEach
    public void setUp() {
        clienteSolvente = new Persona(30, "Franco", "Barigelli", "Calle Falsa 123", 2000);     // 24000 anuales
        clienteConPocosIngresos = new Persona(25, "Ana", "Perez", "Calle Real 456", 1000);    // 12000 anuales
    }

    @Test
    public void montoSolicitadoTest() {
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(clienteSolvente, 12000, 12, 15000, 70);
        assertEquals(12000, solicitud.montoSolicitado());
    }

    @Test
    public void cuotaMensualTest() {
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(clienteSolvente, 12000, 24, 15000, 70);
        assertEquals(500, solicitud.cuotaMensual());
    }

    @Test
    public void esAceptableTest() {
        // Cuota: 12000 / 12 = 1000 <= 1400 (70% de 2000)
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(clienteSolvente, 12000, 12, 15000, 70);
        assertTrue(solicitud.esAceptable());
    }

    @Test
    public void esAceptableEnElLimiteDelPorcentajeCuotaTest() {
        // Cuota: 16800 / 12 = 1400
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(clienteSolvente, 16800, 12, 15000, 70);
        assertTrue(solicitud.esAceptable());
    }

    @Test
    public void esAceptableAlRepartirElMontoEnMasCuotasTest() {
        // Cuota: 24000 / 24 = 1000 <= 1400
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(clienteSolvente, 24000, 24, 15000, 70);
        assertTrue(solicitud.esAceptable());
    }

    @Test
    public void esAceptableEnElLimiteDelIngresoAnualTest() {
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(clienteSolvente, 12000, 12, 24000, 70);
        assertTrue(solicitud.esAceptable());
    }

    @Test
    public void esAceptableConUnMinimoIngresoAnualMenorTest() {
        // 12000 anuales >= 10000; cuota: 6000 / 12 = 500 <= 700 (70% de 1000)
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(clienteConPocosIngresos, 6000, 12, 10000, 70);
        assertTrue(solicitud.esAceptable());
    }

    @Test
    public void noEsAceptablePorIngresosAnualesInsuficientesTest() {
        // 12000 anuales < 15000
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(clienteConPocosIngresos, 6000, 12, 15000, 70);
        assertFalse(solicitud.esAceptable());
    }

    @Test
    public void noEsAceptablePorSuperarPorcentajeCuotaTest() {
        // Cuota: 24000 / 12 = 2000 > 1400
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(clienteSolvente, 24000, 12, 15000, 70);
        assertFalse(solicitud.esAceptable());
    }

}
