package ar.edu.unq.po2.tp6.clienteEmail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServidorAdminPopTest {

    public ServidorAdminPop servidor;
    public Correo correo;

    @BeforeEach
    public void setUp() {
        servidor = new ServidorAdminPop();
        servidor.registrarUsuario("franco", "1234");
        correo = new Correo("Hola", "franco", "Que tal");
    }

    @Test
    public void conectarConUsuarioValidoTest() {
        assertDoesNotThrow(() -> servidor.conectar("franco", "1234"));
    }

    @Test
    public void conectarConPassIncorrectaTest() {
        assertThrows(IllegalArgumentException.class, () -> servidor.conectar("franco", "0000"));
    }

    @Test
    public void conectarConUsuarioInexistenteTest() {
        assertThrows(IllegalArgumentException.class, () -> servidor.conectar("nadie", "1234"));
    }

    @Test
    public void recibirNuevosTest() {
        servidor.enviar(correo);
        assertEquals(1, servidor.recibirNuevos("franco", "1234").size());
    }

    @Test
    public void recibirNuevosVaciaElBuzonTest() {
        servidor.enviar(correo);
        servidor.recibirNuevos("franco", "1234");
        assertEquals(0, servidor.recibirNuevos("franco", "1234").size());
    }

    @Test
    public void recibirNuevosConPassIncorrectaTest() {
        assertThrows(IllegalArgumentException.class, () -> servidor.recibirNuevos("franco", "0000"));
    }

}
