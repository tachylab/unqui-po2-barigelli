package ar.edu.unq.po2.tp7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerStatus {

    //Métodos
    public Jugada verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {

        List<Carta> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

        //Sacamos el valor de las cartas
        List<Valor> valores = cartas.stream()
                                     .map(Carta::getValor)
                                     .toList();


        //Verificamos si las cartas puede dar un Póquer o un Trio
        Valor valorPoquer = obtenerValorRepetido(valores, 4);
        if (valorPoquer != null) {
            return new Jugada(TipoDeJugada.POQUER, valorPoquer);
        }

        Valor valorTrio = obtenerValorRepetido(valores, 3);
        if (valorTrio != null) {
            return new Jugada(TipoDeJugada.TRIO, valorTrio);
        }

        //Sacamos el palo de las cartas
        List<Palo> palos = cartas.stream()
                .map(Carta::getPalo)
                .toList();

        if (this.hayColor(palos)) {
            Valor cartaMasAlta = obtenerCartaMasAlta(valores);
            return new Jugada(TipoDeJugada.COLOR, cartaMasAlta);
        }

        Valor cartaMasAlta = obtenerCartaMasAlta(valores);
        return new Jugada(TipoDeJugada.NADA, cartaMasAlta);
    }

    public boolean hayColor(List<Palo> palos) {
        return palos.stream().distinct().count() == 1;
    }

    private Valor obtenerValorRepetido(List<Valor> valores, int frecuenciaBuscada) {
        return valores.stream()
                      .filter(v -> Collections.frequency(valores, v) == frecuenciaBuscada)
                      .findFirst()
                      .orElse(null);
    }

    private Valor obtenerCartaMasAlta(List<Valor> valores) {
        return valores.stream()
                      .max((v1, v2) -> Integer.compare(v1.getValorNumerico(), v2.getValorNumerico()))
                      .orElse(Valor.DOS);
    }

}
