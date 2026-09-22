package ar.edu.unq.po2.tp5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    public Producto leche;

    @BeforeEach
    public void setUp() {
        leche = new Producto(100);
    }

    @Test
    public void getPrecioTest() {
        assertEquals(100, leche.getPrecio());
    }
}
