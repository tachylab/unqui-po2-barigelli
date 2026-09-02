package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.List;

public class Counter {
    List<Integer> numbers = new ArrayList<Integer>();

    public void addNumber(int number) {

        numbers.add(number);
    }

    public int getOddOccurrences() {
        int counter = 0;
        for (int number : numbers) {
            counter += number % 2;
        }
        return counter;
    }

    public int numeroConMayorDigitosPares(int[] numbers) {
        int mayor = 0;
        for (int numero : numbers) {
            mayor = mayorCantidadDigitosParesEntre(mayor, numero);
        }
        return mayor;
    }

    public int mayorCantidadDigitosParesEntre(int numero1, int numero2) {
        if (cantidadDigitosPares(numero1) > cantidadDigitosPares(numero2)) {
            return numero1;
        } else {
            return numero2;
        }
    }

    public int cantidadDigitosPares(int numero) {
        int contador = 0;
        while (numero != 0) {
            int cifra = numero % 10;
            numero /= 10;
            contador += unoSi(esPar(cifra));
        }
        return contador;
    }

    public int unoSi(boolean condicion) {
        if (condicion) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public boolean esPar(int numero) {
        return numero % 2 == 0 ;
    }

    public int multiploDeEntre0Y1000(int numero1, int numero2) {
        if (numero1 == 0 | numero2 == 0) {
            return -1;
        }
        int multiplo = 1000;
        while (!esMultiploDeYDe(multiplo, numero1, numero2) & multiplo != -1) {
            multiplo -= 1;
        }
        return multiplo;
    }

    public boolean esMultiploDeYDe(int multiplo, int numero1, int numero2) {
        return esMultiploDe(multiplo, numero1) & esMultiploDe(multiplo, numero2);
    }

    public boolean esMultiploDe(int multiplo, int numero) {
        if (multiplo == 0 || numero == 0) {
            return false;
        }
        return multiplo % numero == 0;
    }

}
