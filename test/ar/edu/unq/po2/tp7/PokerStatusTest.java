package ar.edu.unq.po2.tp7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PokerStatusTest {

    Carta c1;
    Carta c2;
    Carta c3;
    Carta c4;
    Carta c5;

    PokerStatus pokerStatus;

    @BeforeEach
    public void setUp() {
        //Setup
        c1 = mock(Carta.class);
        c2 = mock(Carta.class);
        c3 = mock(Carta.class);
        c4 = mock(Carta.class);
        c5 = mock(Carta.class);

        pokerStatus = new PokerStatus();
    }


    @Test
    public void verificarTestSiHayPoker() {
        //Stubbing de comportamientos esperados
        when(c1.getValor()).thenReturn(Valor.ACE);
        when(c2.getValor()).thenReturn(Valor.ACE);
        when(c3.getValor()).thenReturn(Valor.ACE);
        when(c4.getValor()).thenReturn(Valor.ACE);
        when(c5.getValor()).thenReturn(Valor.KING);

        //Exercise
        Jugada resultado = pokerStatus.verificar(c1, c2, c3, c4, c5);

        //Verify (Assert)
        assertEquals(TipoDeJugada.POQUER, resultado.getTipo());

        //Verify (InOrder)
        InOrder inOrder = inOrder(c1, c2, c3, c4, c5);

        //Se verifica si se llamaron en órden a sus valores
        inOrder.verify(c1).getValor();
        inOrder.verify(c2).getValor();
        inOrder.verify(c3).getValor();
        inOrder.verify(c4).getValor();
        inOrder.verify(c5).getValor();

        //Cómo es un Póquer, jamás se consultó el palo de las cartas
        verify(c1, never()).getPalo();

    }

    @Test
    public void verificarTestSiHayColor() {
        //Stubbing de comportamientos esperados
        when(c1.getPalo()).thenReturn(Palo.CORAZONES);
        when(c2.getPalo()).thenReturn(Palo.CORAZONES);
        when(c3.getPalo()).thenReturn(Palo.CORAZONES);
        when(c4.getPalo()).thenReturn(Palo.CORAZONES);
        when(c5.getPalo()).thenReturn(Palo.CORAZONES);

        when(c1.getValor()).thenReturn(Valor.DOS);
        when(c2.getValor()).thenReturn(Valor.CUATRO);
        when(c3.getValor()).thenReturn(Valor.SEIS);
        when(c4.getValor()).thenReturn(Valor.OCHO);
        when(c5.getValor()).thenReturn(Valor.KING);

        //Exercise
        Jugada resultado = pokerStatus.verificar(c1, c2, c3, c4, c5);

        //Verify (Assert)
        assertEquals(TipoDeJugada.COLOR, resultado.getTipo());

        //Verify (InOrder)
        InOrder inOrder = inOrder(c1, c2, c3, c4, c5);

        //Se verifica si se llamaron en órden a sus valores
        inOrder.verify(c1).getValor();
        inOrder.verify(c2).getValor();
        inOrder.verify(c3).getValor();
        inOrder.verify(c4).getValor();
        inOrder.verify(c5).getValor();

        //Cómo no es ni Póquer ni Trio, se pide el Palo de dichas cartas
        inOrder.verify(c1).getPalo();
        inOrder.verify(c2).getPalo();
        inOrder.verify(c3).getPalo();
        inOrder.verify(c4).getPalo();
        inOrder.verify(c5).getPalo();
    }

    @Test
    public void verificarTestSiHayTrio() {
        //Stubbing de comportamientos esperados
        when(c1.getValor()).thenReturn(Valor.JACK);
        when(c2.getValor()).thenReturn(Valor.JACK);
        when(c3.getValor()).thenReturn(Valor.JACK);
        when(c4.getValor()).thenReturn(Valor.QUEEN);
        when(c5.getValor()).thenReturn(Valor.KING);

        //Exercise
        Jugada resultado = pokerStatus.verificar(c1, c2 , c3, c4, c5);

        //Verify (Assert)
        assertEquals(TipoDeJugada.TRIO, resultado.getTipo());

        //Verify (InOrder)
        InOrder inOrder = inOrder(c1, c2, c3, c4, c5);

        //Se verifica si se llamaron en órden a sus valores
        inOrder.verify(c1).getValor();
        inOrder.verify(c2).getValor();
        inOrder.verify(c3).getValor();
        inOrder.verify(c4).getValor();
        inOrder.verify(c5).getValor();

        //Cómo es un Trio, jamás se consultó el palo de las cartas
        verify(c1, never()).getPalo();
    }

    @Test
    public void verificarTestSiNoHayNada() {
        //Stubbing de los comportamientos esperados
        when(c1.getValor()).thenReturn(Valor.JACK);
        when(c2.getValor()).thenReturn(Valor.QUEEN);
        when(c3.getValor()).thenReturn(Valor.KING);
        when(c4.getValor()).thenReturn(Valor.DIEZ);
        when(c5.getValor()).thenReturn(Valor.DOS);

        when(c1.getPalo()).thenReturn(Palo.PICAS);
        when(c2.getPalo()).thenReturn(Palo.PICAS);
        when(c3.getPalo()).thenReturn(Palo.DIAMANTES);
        when(c4.getPalo()).thenReturn(Palo.TREBOLES);
        when(c5.getPalo()).thenReturn(Palo.CORAZONES);

        //Exercise
        Jugada resultado = pokerStatus.verificar(c1, c2, c3, c4, c5);

        //Verify (Assert)
        assertEquals(TipoDeJugada.NADA, resultado.getTipo());

        //Verify (InOrder)
        InOrder inOrder = inOrder(c1, c2, c3, c4, c5);

        //Se verifica si se llamaron en órden a sus valores
        inOrder.verify(c1).getValor();
        inOrder.verify(c2).getValor();
        inOrder.verify(c3).getValor();
        inOrder.verify(c4).getValor();
        inOrder.verify(c5).getValor();

        //Cómo no es ni Póquer ni Trio, se pide el Palo de dichas cartas
        inOrder.verify(c1).getPalo();
        inOrder.verify(c2).getPalo();
        inOrder.verify(c3).getPalo();
        inOrder.verify(c4).getPalo();
        inOrder.verify(c5).getPalo();
    }

    @Test
    public void testPoquerLeGanaAColor() {
        Jugada poquerDeDoses = new Jugada(TipoDeJugada.POQUER, Valor.DOS);
        Jugada colorAlAs = new Jugada(TipoDeJugada.COLOR, Valor.ACE);

        assertTrue(poquerDeDoses.leGanaA(colorAlAs));
    }

    @Test
    public void testDesempateEntreTriosGanaElDeMayorValor() {
        Jugada trioDeReyes = new Jugada(TipoDeJugada.TRIO, Valor.KING);
        Jugada trioDeOchos = new Jugada(TipoDeJugada.TRIO, Valor.OCHO);

        assertTrue(trioDeReyes.leGanaA(trioDeOchos));
        assertFalse(trioDeOchos.leGanaA(trioDeReyes)); }
}
