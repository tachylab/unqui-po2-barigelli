package ar.edu.unq.po2.tp7;

public class Carta {

    private final Valor valor;
    private final Palo palo;

    public Carta(Valor valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public Valor getValor() {
        return valor;
    }

    public Palo getPalo() {
        return palo;
    }

    public boolean esSuperiorA(Carta otraCarta) {
        return this.valor.esMayorQue(otraCarta.getValor());
    }

    public boolean mismoPalo(Carta otraCarta) {
        return this.palo ==  otraCarta.getPalo();
    }
}
