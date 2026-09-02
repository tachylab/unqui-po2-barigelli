package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.List;

public class Multioperador {

    private List<Integer> numeros = new ArrayList<Integer>();

    public void addNumero(int numero) {
        numeros.add(numero);
    }

    public int sumaArreglos() {
        int sumatoria = 0;
        for (int numero : numeros) {
            sumatoria += numero;
        }
        return sumatoria;
    }

    public int restaArreglos() {
        int restaTotal = 0;
        for (int numero : numeros) {
            restaTotal -= numero;
        }
        return restaTotal;
    }

    public int productoArreglos() {
        int productoTotal = 1;
        for (int numero : numeros) {
            productoTotal = productoTotal * numero;
        }
        return productoTotal;
    }

    public void vaciarLista() {
        numeros.clear();
    }
}
