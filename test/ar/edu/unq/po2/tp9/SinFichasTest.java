package ar.edu.unq.po2.tp9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SinFichasTest {

    SinFicha estado;
    MaquinaVideojuego maquina;

    @BeforeEach
    public void setUp() {
        //setup
        estado = new SinFicha();
        maquina = mock(MaquinaVideojuego.class);
    }

    @Test
    public void insertarFichaTest() {
        //exercise
        estado.ingresarFicha(maquina);

        //verify
        verify(maquina, times(1)).cambiarEstado(any(UnaFicha.class));
    }

    @Test
    public void presionarBotonInicio() {
        //exercise
        estado.presionarBotonInicio(maquina);

        //verify
        verify(maquina, never()).cambiarEstado(any());
    }


    @Test
    public void terminarJuego() {
        //exercise
        estado.terminarJuego(maquina);

        //verify
        verify(maquina, never()).cambiarEstado(any());
    }

}
