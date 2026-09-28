package ar.edu.unq.po2.tp7;

public enum Valor {
    DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9), DIEZ(10), JACK(11), QUEEN(12), KING(13), ACE(14);

    private final int valorNumerico;

    Valor(int valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public int getValorNumerico() {
        return this.valorNumerico;
    }

    public boolean esMayorQue(Valor otroValor) {
        return this.valorNumerico > otroValor.getValorNumerico();
    }
}
