package ar.edu.unq.po2.tp9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MaquinaVideojuegoTest {

    MaquinaVideojuego maquina;
    EstadoVideojuego estado;

    @BeforeEach
    public void setUp() {
        //setup
        estado = mock(EstadoVideojuego.class);
        maquina = new MaquinaVideojuego(estado);
    }

    @Test
    public void ingresarFichaDelegaEnElEstado() {
        //exercise
        maquina.ingresarFicha();

        //verify
        verify(estado, times(1)).ingresarFicha(maquina);
    }

    @Test
    public void presionarBotonInicioDelegaEnElEstado() {
        //exercise
        maquina.presionarBotonInicio();

        //verify
        verify(estado, times(1)).presionarBotonInicio(maquina);
    }

    @Test
    public void terminarJuegoDelegaEnElEstado() {
        //exercise
        maquina.terminarJuego();

        //verify
        verify(estado, times(1)).terminarJuego(maquina);
    }

    @Test
    public void cambiarEstadoHaceQueSeDelegueEnElNuevoEstado() {
        //setup
        EstadoVideojuego nuevoEstado = mock(EstadoVideojuego.class);

        //exercise
        maquina.cambiarEstado(nuevoEstado);
        maquina.ingresarFicha();

        //verify
        verify(nuevoEstado, times(1)).ingresarFicha(maquina);
        verifyNoInteractions(estado);
    }

}
