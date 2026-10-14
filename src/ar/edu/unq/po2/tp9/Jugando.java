package ar.edu.unq.po2.tp9;

public class Jugando extends EstadoVideojuego {

    @Override
    public void terminarJuego(MaquinaVideojuego maquina) {
        SinFicha nuevoEstado = new SinFicha();
        maquina.cambiarEstado(nuevoEstado);
    }
}
