package ar.edu.unq.po2.tp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CounterTestCase {
    private Counter counter;
    /**
     * Crea un escenario de test básico, que consiste en un contador
     * con 10 enteros
     *
     * @throws Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        //Se crea el contador
        counter = new Counter();
        //Se agregan los numeros. Un solo par y nueve impares
        counter.addNumber(1);
        counter.addNumber(3);
        counter.addNumber(5);
        counter.addNumber(7);
        counter.addNumber(9);
        counter.addNumber(1);
        counter.addNumber(1);
        counter.addNumber(1);
        counter.addNumber(1);
        counter.addNumber(4);
    }

    /**
    * Verifica la cantidad de pares
    */
    @Test
    public void testEvenNumbers() {
        //Getting the even occurrences
        int amount = counter.getOddOccurrences();

        //I check the amount is the expected one
        assertEquals(9, amount);
    }

    /**
     * Verifica el número del arreglo con más cifras pares
     */
    @Test
    public void testNumeroConMayorDigitosPares() {
        //Creo un arreglo de números para testear
        int[] arregloNumeros = {12, 345, -24, 0, 7};

        //Obtener el mayor número del arreglo
        int mayor = counter.numeroConMayorDigitosPares(arregloNumeros);

        //Checar que lo hizo bien
        assertEquals(-24, mayor);

        //Instanciar en un caso de empate
        arregloNumeros = new int[]{1, 3, 7, 9};
        mayor = counter.numeroConMayorDigitosPares(arregloNumeros);

        //Ahora que hay empate, y por cómo están hechas las comparaciones, tiene que devolver 1
        assertEquals(9, mayor);

        //Verificar que pasa si hay un solo elemento en el arreglo
        arregloNumeros = new int[]{7};
        mayor = counter.numeroConMayorDigitosPares(arregloNumeros);

        //Como hay un solo elemento, me tiene que devolver dicho elemento
        assertEquals(7, mayor);

        //Verificación con ganador en los extremos
        arregloNumeros = new int[]{7, 4, 9, 46};
        mayor = counter.numeroConMayorDigitosPares(arregloNumeros);
        assertEquals(46, mayor);

        arregloNumeros[0] = 246;
        mayor = counter.numeroConMayorDigitosPares(arregloNumeros);
        assertEquals(246, mayor);
    }

    /**
     * Devuelve el mayor múltiplo entre 0 y 1000 de los dos números dados. En caso de no existir devuelve -1
     */

    @Test
    public void testMultiploDeEntre0Y1000() {
        //Caso normal
        assertEquals(996, counter.multiploDeEntre0Y1000(4,6));

        //Caso sin múltiplo
        assertEquals(-1, counter.multiploDeEntre0Y1000(700,900));

        //Otro caso normal
        assertEquals(1000, counter.multiploDeEntre0Y1000(5,10));

        //Numeros iguales
        assertEquals(1000, counter.multiploDeEntre0Y1000(50,50));

        assertEquals(924, counter.multiploDeEntre0Y1000(7,11));

        //Caso borde
        assertEquals(1000, counter.multiploDeEntre0Y1000(250,500));

        //Caso 0
        assertEquals(-1, counter.multiploDeEntre0Y1000(0,5));
    }


}