package ar.edu.unq.po2.tp6.banco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BancoTest {

    private Banco banco;
    private Persona cliente;
    private Propiedad propiedad;
    private SolicitudCreditoPersonal personalAceptable;
    private SolicitudCreditoPersonal personalNoAceptable;
    private SolicitudCreditoHipotecario hipotecarioAceptable;
    private SolicitudCreditoHipotecario hipotecarioNoAceptable;

    @BeforeEach
    public void setUp() {
        banco = new Banco();
        cliente = new Persona(30, "Franco", "Barigelli", "Calle Falsa 123", 100000);
        propiedad = new Propiedad("Casa", "Calle Falsa 123", 1000000);

        personalAceptable = new SolicitudCreditoPersonal(cliente, 12000, 12, 15000, 70);            // cuota: 1000
        personalNoAceptable = new SolicitudCreditoPersonal(cliente, 1200000, 12, 15000, 70);        // cuota: 100000 > 70000
        hipotecarioAceptable = new SolicitudCreditoHipotecario(cliente, 600000, 120, 50, 70, 65, propiedad);
        hipotecarioNoAceptable = new SolicitudCreditoHipotecario(cliente, 600000, 480, 50, 70, 65, propiedad);  // termina a los 70
    }

    @Test
    public void agregarClienteTest() {
        banco.agregarCliente(cliente);
        assertEquals(1, banco.clientes.size());
        assertTrue(banco.clientes.contains(cliente));
    }

    @Test
    public void solicitarCreditoDeTest() {
        banco.solicitarCreditoDe(personalAceptable);
        banco.solicitarCreditoDe(hipotecarioNoAceptable);
        assertEquals(2, banco.creditos.size());
    }

    @Test
    public void montoTotalPorCreditosSinSolicitudesTest() {
        assertEquals(0, banco.montoTotalPorCreditos());
    }

    @Test
    public void montoTotalPorCreditosSoloSumaAceptablesTest() {
        banco.solicitarCreditoDe(personalAceptable);
        banco.solicitarCreditoDe(personalNoAceptable);
        banco.solicitarCreditoDe(hipotecarioAceptable);
        banco.solicitarCreditoDe(hipotecarioNoAceptable);
        assertEquals(612000, banco.montoTotalPorCreditos());
    }

    @Test
    public void montoTotalPorCreditosSinAceptablesTest() {
        banco.solicitarCreditoDe(personalNoAceptable);
        banco.solicitarCreditoDe(hipotecarioNoAceptable);
        assertEquals(0, banco.montoTotalPorCreditos());
    }

}
