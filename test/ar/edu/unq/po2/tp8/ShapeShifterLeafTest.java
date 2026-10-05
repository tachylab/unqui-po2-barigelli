package ar.edu.unq.po2.tp8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ShapeShifterLeafTest {

    IShapeShifter otroShapeShifter;

    ShapeShifterLeaf hoja;

    @BeforeEach
    public void setUp() {
        //Setup
        otroShapeShifter = mock(IShapeShifter.class);

        hoja = new ShapeShifterLeaf(5);
    }

    @Test
    public void laProfundidadDeUnaHojaEsCero() {
        //Exercise
        int resultado = hoja.deepest();

        //Verify (Assert)
        assertEquals(0, resultado);
    }

    @Test
    public void losValoresDeUnaHojaSonSoloSuValor() {
        //Exercise
        List<Integer> resultado = hoja.values();

        //Verify (Assert)
        assertEquals(List.of(5), resultado);
    }

    @Test
    public void aplanarUnaHojaDevuelveLaMismaHoja() {
        //Exercise
        IShapeShifter resultado = hoja.flat();

        //Verify (Assert)
        assertSame(hoja, resultado);
    }

    @Test
    public void componerUnaHojaDevuelveUnNuevoShapeShifter() {
        //Exercise
        IShapeShifter resultado = hoja.compose(otroShapeShifter);

        //Verify (Assert)
        assertNotSame(hoja, resultado);
        assertNotSame(otroShapeShifter, resultado);

        //Componer solo arma la estructura, no le pide nada al otro ShapeShifter
        verifyNoInteractions(otroShapeShifter);
    }

    @Test
    public void componerUnaHojaNoModificaALaHoja() {
        //Exercise
        hoja.compose(otroShapeShifter);

        //Verify (Assert)
        assertEquals(0, hoja.deepest());
        assertEquals(List.of(5), hoja.values());
        assertSame(hoja, hoja.flat());
    }

    @Test
    public void elCompuestoDeUnaHojaTieneLosValoresDeLaHojaYLuegoLosDelOtro() {
        //Stubbing de comportamientos esperados
        when(otroShapeShifter.values()).thenReturn(List.of(7, 9));

        //Exercise
        List<Integer> resultado = hoja.compose(otroShapeShifter).values();

        //Verify (Assert)
        assertEquals(List.of(5, 7, 9), resultado);

        //Se verifica que el compuesto delegó en el otro ShapeShifter
        verify(otroShapeShifter).values();
    }

    @Test
    public void elCompuestoDeUnaHojaConUnShapeShifterSinProfundidadTieneProfundidadUno() {
        //Stubbing de comportamientos esperados
        when(otroShapeShifter.deepest()).thenReturn(0);

        //Exercise
        int resultado = hoja.compose(otroShapeShifter).deepest();

        //Verify (Assert)
        assertEquals(1, resultado);
    }

    @Test
    public void elCompuestoDeUnaHojaEsUnNivelMasProfundoQueElOtroShapeShifter() {
        //Stubbing de comportamientos esperados
        when(otroShapeShifter.deepest()).thenReturn(3);

        //Exercise
        int resultado = hoja.compose(otroShapeShifter).deepest();

        //Verify (Assert)
        assertEquals(4, resultado);

        //Se verifica que el compuesto delegó en el otro ShapeShifter
        verify(otroShapeShifter).deepest();
    }
}
