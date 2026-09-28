package ar.edu.unq.po2.tp7;

public class Jugada {

    private final TipoDeJugada tipo;
    private final Valor valorDesempate; // Carta fuerte del Póquer, Trío, o la más alta en Color/Nada
    public Jugada(TipoDeJugada tipo, Valor valorDesempate) {
        this.tipo = tipo;
        this.valorDesempate = valorDesempate;
    }

    public TipoDeJugada getTipo() {
        return this.tipo;
    }

    public Valor getValorDesempate() {
        return this.valorDesempate;
    }

    /*
     *
     * Compara esta jugada contra otra.
     * Retorna true si esta jugada es superior según la jerarquía o el valor de desempate.
     */

    public boolean leGanaA(Jugada otra) {
        // 1\. Si son jugadas de distinto tipo, desempata la jerarquía del tipo
        if (this.tipo != otra.getTipo()) {
            return this.tipo.getJerarquia() > otra.getTipo().getJerarquia();
        }
        // 2\. Si son del mismo tipo, desempata el valor numérico de la carta representativa
        return this.valorDesempate.getValorNumerico() > otra.getValorDesempate().getValorNumerico();
    }

}
