package ar.edu.unq.po2.tp5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    public Cliente cliente;
    public Producto leche;
    public ProductoCooperativa arroz;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
        leche = new Producto(100);
        arroz = new ProductoCooperativa(120);
        cliente.añadirProducto(leche);
        cliente.añadirProducto(arroz);
    }

    @Test
    public void pasarClientePorCajaTest() {
        assertEquals(208, cliente.montoAPagar());
    }
}
