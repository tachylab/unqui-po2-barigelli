package ar.edu.unq.po2.tp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultioperadorTest {
    private Multioperador multioperador;
    /**
     * Da una serie de números para la ArrayList
     */
    @BeforeEach
    public void setUp() {
        multioperador = new Multioperador();
        multioperador.addNumero(5);
        multioperador.addNumero(3);
        multioperador.addNumero(-2);
        multioperador.addNumero(4);
    }


    @Test
    public void sumaArreglosTest() {
        //Prueba normal
        assertEquals(10, multioperador.sumaArreglos());

        //Test lista vacia
        multioperador.vaciarLista();
        assertEquals(0, multioperador.sumaArreglos());

        //Un solo elemento
        multioperador.addNumero(7);
        assertEquals(7, multioperador.sumaArreglos());

        //Con solo negativos
        multioperador.vaciarLista();
        multioperador.addNumero(-3);
        multioperador.addNumero(-5);
        multioperador.addNumero(-2);
        assertEquals(-10, multioperador.sumaArreglos());
    }

    @Test
    public void restaArreglosTest() {
        //Prueba normal
        assertEquals(-10, multioperador.restaArreglos());

        //Test lista vacia
        multioperador.vaciarLista();
        assertEquals(0, multioperador.restaArreglos());

        //Un solo elemento
        multioperador.addNumero(7);
        assertEquals(-7, multioperador.restaArreglos());

        //Con solo negativos
        multioperador.vaciarLista();
        multioperador.addNumero(-3);
        multioperador.addNumero(-5);
        multioperador.addNumero(-2);
        assertEquals(10, multioperador.restaArreglos());
    }

    @Test
    public void productoArreglosTest() {
        //Prueba normal
        assertEquals(-120, multioperador.productoArreglos());

        //Test lista vacia
        multioperador.vaciarLista();
        assertEquals(1, multioperador.productoArreglos());

        //Un solo elemento
        multioperador.addNumero(7);
        assertEquals(7, multioperador.productoArreglos());

        //Con cero
        multioperador.addNumero(0);
        assertEquals(0, multioperador.productoArreglos());

        //Con solo negativos
        multioperador.vaciarLista();
        multioperador.addNumero(-3);
        multioperador.addNumero(-5);
        multioperador.addNumero(-2);
        assertEquals(-30, multioperador.productoArreglos());
    }
}
