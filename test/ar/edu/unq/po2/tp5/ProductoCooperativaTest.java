package ar.edu.unq.po2.tp5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoCooperativaTest {

    public ProductoCooperativa arroz;

    @BeforeEach
    public void setUp() {
        arroz = new ProductoCooperativa(120);
    }

    @Test
    public void getPrecioTest() {
        assertEquals(108, arroz.getPrecio());
    }

}
