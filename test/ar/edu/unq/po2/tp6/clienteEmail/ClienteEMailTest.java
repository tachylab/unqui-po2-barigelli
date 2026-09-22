package ar.edu.unq.po2.tp6.clienteEmail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteEMailTest {

    public ServidorAdminPop servidor;
    public ClienteEMail franco;
    public ClienteEMail ana;

    @BeforeEach
    public void setUp() {
        servidor = new ServidorAdminPop();
        servidor.registrarUsuario("franco", "1234");
        servidor.registrarUsuario("ana", "abcd");
        franco = new ClienteEMail(servidor, "franco", "1234");
        ana = new ClienteEMail(servidor, "ana", "abcd");
    }

    @Test
    public void crearClienteConPassIncorrectaTest() {
        assertThrows(IllegalArgumentException.class, () -> new ClienteEMail(servidor, "franco", "0000"));
    }

    @Test
    public void enviarYRecibirCorreoTest() {
        franco.enviarCorreo("Hola", "ana", "Que tal");
        ana.recibirNuevos();
        assertEquals(1, ana.contarInbox());
    }

    @Test
    public void borrarCorreoTest() {
        franco.enviarCorreo("Hola", "ana", "Que tal");
        ana.recibirNuevos();
        Correo correo = ana.inbox.get(0);
        ana.borrarCorreo(correo);
        assertEquals(0, ana.contarInbox());
        assertEquals(1, ana.contarBorrados());
    }

    @Test
    public void eliminarBorradoTest() {
        franco.enviarCorreo("Hola", "ana", "Que tal");
        ana.recibirNuevos();
        Correo correo = ana.inbox.get(0);
        ana.borrarCorreo(correo);
        ana.eliminarBorrado(correo);
        assertEquals(0, ana.contarBorrados());
    }

}
