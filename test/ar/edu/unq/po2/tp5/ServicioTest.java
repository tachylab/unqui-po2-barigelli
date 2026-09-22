package ar.edu.unq.po2.tp5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServicioTest {

    public Servicio agua;

    @BeforeEach
    public void setUp() {
        agua = new Servicio(10, 10);
    }

    @Test
    public void montoAPagar() {
        assertEquals(100, agua.montoAPagar());
    }
}
