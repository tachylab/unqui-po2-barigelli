package ar.edu.unq.po2.tp6.banco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolicitudCreditoHipotecarioTest {

    private Persona clienteJoven;
    private Persona clienteMayor;
    private Propiedad propiedad;

    @BeforeEach
    public void setUp() {
        clienteJoven = new Persona(30, "Franco", "Barigelli", "Calle Falsa 123", 100000);   // cuota máxima: 50000
        clienteMayor = new Persona(60, "Ana", "Perez", "Calle Real 456", 100000);
        propiedad = new Propiedad("Casa", "Calle Falsa 123", 1000000);                      // monto máximo: 700000
    }

    @Test
    public void montoSolicitadoTest() {
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(clienteJoven, 600000, 120, 50, 70, 65, propiedad);
        assertEquals(600000, solicitud.montoSolicitado());
    }

    @Test
    public void cuotaMensualTest() {
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(clienteJoven, 600000, 120, 50, 70, 65, propiedad);
        assertEquals(5000, solicitud.cuotaMensual());
    }

    @Test
    public void esAceptableTest() {
        // Cuota: 5000; monto: 600000 <= 700000; edad al finalizar: 40
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(clienteJoven, 600000, 120, 50, 70, 65, propiedad);
        assertTrue(solicitud.esAceptable());
    }

    @Test
    public void esAceptableEnLosLimitesTest() {
        // Monto: 700000 (70% del valor fiscal); edad al finalizar: 30 + 35 años = 65
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(clienteJoven, 700000, 420, 50, 70, 65, propiedad);
        assertTrue(solicitud.esAceptable());
    }

    @Test
    public void noEsAceptablePorSuperarPorcentajeCuotaTest() {
        // Cuota: 600000 / 10 = 60000 > 50000
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(clienteJoven, 600000, 10, 50, 70, 65, propiedad);
        assertFalse(solicitud.esAceptable());
    }

    @Test
    public void noEsAceptablePorSuperarPorcentajeValorFiscalTest() {
        // Monto: 800000 > 700000, aunque la cuota (6666,67) esté dentro del límite
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(clienteJoven, 800000, 120, 50, 70, 65, propiedad);
        assertFalse(solicitud.esAceptable());
    }

    @Test
    public void noEsAceptablePorSuperarEdadMaximaTest() {
        // Edad al finalizar: 60 + 10 años = 70
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(clienteMayor, 600000, 120, 50, 70, 65, propiedad);
        assertFalse(solicitud.esAceptable());
    }

    @Test
    public void noEsAceptablePorSuperarEdadMaximaPorMesesTest() {
        // Edad al finalizar: 30 años + 425 meses = 65 años y 5 meses
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(clienteJoven, 600000, 425, 50, 70, 65, propiedad);
        assertFalse(solicitud.esAceptable());
    }

}
