package ar.edu.unq.po2.tp7;

public enum TipoDeJugada {

    POQUER(4),
    COLOR(3),
    TRIO(2),
    NADA(1);

    private final int jerarquia;

    TipoDeJugada(int jerarquia) {
        this.jerarquia = jerarquia;
    }

    public int getJerarquia() {
        return this.jerarquia;
    }

}
