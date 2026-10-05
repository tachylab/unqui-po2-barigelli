package ar.edu.unq.po2.tp8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ShapeShifterCompositeTest {

    IShapeShifter hijo1;
    IShapeShifter hijo2;
    IShapeShifter hijo3;
    IShapeShifter otroShapeShifter;

    ShapeShifterComposite compuesto;

    @BeforeEach
    public void setUp() {
        //Setup
        hijo1 = mock(IShapeShifter.class);
        hijo2 = mock(IShapeShifter.class);
        hijo3 = mock(IShapeShifter.class);
        otroShapeShifter = mock(IShapeShifter.class);

        compuesto = new ShapeShifterComposite();
    }

    //Agrega los tres hijos al compuesto, respetando el órden hijo1, hijo2, hijo3
    private void agregarLosTresHijos() {
        compuesto.agregar(hijo1);
        compuesto.agregar(hijo2);
        compuesto.agregar(hijo3);
    }

    // ---------- values ----------

    @Test
    public void unCompuestoSinHijosNoTieneValores() {
        //Exercise
        List<Integer> resultado = compuesto.values();

        //Verify (Assert)
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void losValoresDeUnCompuestoSonLosDeSusHijosEnOrden() {
        //Stubbing de comportamientos esperados
        when(hijo1.values()).thenReturn(List.of(1));
        when(hijo2.values()).thenReturn(List.of(2, 3));
        when(hijo3.values()).thenReturn(List.of(4));
        agregarLosTresHijos();

        //Exercise
        List<Integer> resultado = compuesto.values();

        //Verify (Assert)
        assertEquals(List.of(1, 2, 3, 4), resultado);

        //Verify (InOrder)
        InOrder inOrder = inOrder(hijo1, hijo2, hijo3);

        //Se verifica que se le pidieron los valores a cada hijo, en órden
        inOrder.verify(hijo1).values();
        inOrder.verify(hijo2).values();
        inOrder.verify(hijo3).values();
    }

    @Test
    public void losValoresDeUnCompuestoConservanLosRepetidos() {
        //Stubbing de comportamientos esperados
        when(hijo1.values()).thenReturn(List.of(8));
        when(hijo2.values()).thenReturn(List.of(8));
        compuesto.agregar(hijo1);
        compuesto.agregar(hijo2);

        //Exercise
        List<Integer> resultado = compuesto.values();

        //Verify (Assert)
        assertEquals(List.of(8, 8), resultado);
    }

    @Test
    public void unHijoSinValoresNoAportaValoresAlCompuesto() {
        //Stubbing de comportamientos esperados
        when(hijo1.values()).thenReturn(List.of(1));
        when(hijo2.values()).thenReturn(List.of());
        when(hijo3.values()).thenReturn(List.of(4));
        agregarLosTresHijos();

        //Exercise
        List<Integer> resultado = compuesto.values();

        //Verify (Assert)
        assertEquals(List.of(1, 4), resultado);
    }

    // ---------- deepest ----------

    @Test
    public void laProfundidadDeUnCompuestoSinHijosEsUno() {
        //Exercise
        int resultado = compuesto.deepest();

        //Verify (Assert)
        assertEquals(1, resultado);
    }

    @Test
    public void laProfundidadDeUnCompuestoConHijosSinProfundidadEsUno() {
        //Stubbing de comportamientos esperados
        when(hijo1.deepest()).thenReturn(0);
        when(hijo2.deepest()).thenReturn(0);
        when(hijo3.deepest()).thenReturn(0);
        agregarLosTresHijos();

        //Exercise
        int resultado = compuesto.deepest();

        //Verify (Assert)
        assertEquals(1, resultado);
    }

    @Test
    public void laProfundidadDeUnCompuestoEsUnoMasQueLaDeSuHijoMasProfundo() {
        //Stubbing de comportamientos esperados
        when(hijo1.deepest()).thenReturn(0);
        when(hijo2.deepest()).thenReturn(4);
        when(hijo3.deepest()).thenReturn(2);
        agregarLosTresHijos();

        //Exercise
        int resultado = compuesto.deepest();

        //Verify (Assert)
        assertEquals(5, resultado);

        //Se verifica que se le consultó la profundidad a todos los hijos
        verify(hijo1).deepest();
        verify(hijo2).deepest();
        verify(hijo3).deepest();
    }

    // ---------- flat ----------

    @Test
    public void aplanarUnCompuestoDevuelveUnNuevoShapeShifter() {
        //Stubbing de comportamientos esperados
        when(hijo1.values()).thenReturn(List.of(1));
        compuesto.agregar(hijo1);

        //Exercise
        IShapeShifter resultado = compuesto.flat();

        //Verify (Assert)
        assertNotSame(compuesto, resultado);
    }

    @Test
    public void elAplanadoDeUnCompuestoTieneLosMismosValoresEnElMismoOrden() {
        //Stubbing de comportamientos esperados
        when(hijo1.values()).thenReturn(List.of(1));
        when(hijo2.values()).thenReturn(List.of(2, 3));
        when(hijo3.values()).thenReturn(List.of(4));
        agregarLosTresHijos();

        //Exercise
        IShapeShifter resultado = compuesto.flat();

        //Verify (Assert)
        assertEquals(List.of(1, 2, 3, 4), resultado.values());
    }

    @Test
    public void elAplanadoDeUnCompuestoTieneProfundidadUnoSinImportarLaDeSusHijos() {
        //Stubbing de comportamientos esperados
        when(hijo1.values()).thenReturn(List.of(1));
        when(hijo2.values()).thenReturn(List.of(2, 3));
        when(hijo1.deepest()).thenReturn(0);
        when(hijo2.deepest()).thenReturn(6);
        compuesto.agregar(hijo1);
        compuesto.agregar(hijo2);

        //Exercise
        IShapeShifter resultado = compuesto.flat();

        //Verify (Assert)
        assertEquals(1, resultado.deepest());
    }

    @Test
    public void aplanarUnCompuestoNoModificaAlCompuestoOriginal() {
        //Stubbing de comportamientos esperados
        when(hijo1.values()).thenReturn(List.of(1));
        when(hijo2.values()).thenReturn(List.of(2, 3));
        when(hijo1.deepest()).thenReturn(0);
        when(hijo2.deepest()).thenReturn(6);
        compuesto.agregar(hijo1);
        compuesto.agregar(hijo2);

        //Exercise
        compuesto.flat();

        //Verify (Assert)
        assertEquals(7, compuesto.deepest());
        assertEquals(List.of(1, 2, 3), compuesto.values());
    }

    @Test
    public void elAplanadoDeUnCompuestoSinHijosNoTieneValores() {
        //Exercise
        IShapeShifter resultado = compuesto.flat();

        //Verify (Assert)
        assertTrue(resultado.values().isEmpty());
    }

    // ---------- compose ----------

    @Test
    public void componerUnCompuestoDevuelveUnNuevoShapeShifter() {
        //Setup
        compuesto.agregar(hijo1);

        //Exercise
        IShapeShifter resultado = compuesto.compose(otroShapeShifter);

        //Verify (Assert)
        assertNotSame(compuesto, resultado);
        assertNotSame(otroShapeShifter, resultado);

        //Componer solo arma la estructura, no le pide nada a los ShapeShifter involucrados
        verifyNoInteractions(hijo1, otroShapeShifter);
    }

    @Test
    public void elCompuestoResultanteTieneLosValoresDelCompuestoYLuegoLosDelOtro() {
        //Stubbing de comportamientos esperados
        when(hijo1.values()).thenReturn(List.of(1));
        when(hijo2.values()).thenReturn(List.of(2, 3));
        when(otroShapeShifter.values()).thenReturn(List.of(7, 9));
        compuesto.agregar(hijo1);
        compuesto.agregar(hijo2);

        //Exercise
        List<Integer> resultado = compuesto.compose(otroShapeShifter).values();

        //Verify (Assert)
        assertEquals(List.of(1, 2, 3, 7, 9), resultado);

        //Verify (InOrder)
        InOrder inOrder = inOrder(hijo1, hijo2, otroShapeShifter);

        //Se verifica que la consulta se propagó por toda la estructura, en órden
        inOrder.verify(hijo1).values();
        inOrder.verify(hijo2).values();
        inOrder.verify(otroShapeShifter).values();
    }

    @Test
    public void elCompuestoResultanteEsUnNivelMasProfundoQueElCompuestoOriginal() {
        //Stubbing de comportamientos esperados
        when(hijo1.deepest()).thenReturn(2);
        when(otroShapeShifter.deepest()).thenReturn(0);
        compuesto.agregar(hijo1);

        //Exercise
        int resultado = compuesto.compose(otroShapeShifter).deepest();

        //Verify (Assert)
        //hijo1 (2) -> compuesto (3) -> compuesto resultante (4)
        assertEquals(4, resultado);
    }

    @Test
    public void elCompuestoResultanteEsUnNivelMasProfundoQueElOtroSiEsElMasProfundo() {
        //Stubbing de comportamientos esperados
        when(hijo1.deepest()).thenReturn(0);
        when(otroShapeShifter.deepest()).thenReturn(8);
        compuesto.agregar(hijo1);

        //Exercise
        int resultado = compuesto.compose(otroShapeShifter).deepest();

        //Verify (Assert)
        assertEquals(9, resultado);
    }

    @Test
    public void componerUnCompuestoNoModificaAlCompuestoOriginal() {
        //Stubbing de comportamientos esperados
        when(hijo1.values()).thenReturn(List.of(1));
        when(hijo1.deepest()).thenReturn(0);
        when(otroShapeShifter.values()).thenReturn(List.of(7, 9));
        when(otroShapeShifter.deepest()).thenReturn(8);
        compuesto.agregar(hijo1);

        //Exercise
        compuesto.compose(otroShapeShifter);

        //Verify (Assert)
        assertEquals(List.of(1), compuesto.values());
        assertEquals(1, compuesto.deepest());

        //El otro ShapeShifter no pasó a ser hijo del compuesto original
        verifyNoInteractions(otroShapeShifter);
    }
}
