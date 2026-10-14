package ar.edu.unq.po2.tp9;

public class DosFichas extends EstadoVideojuego {

    @Override
    public void presionarBotonInicio(MaquinaVideojuego maquina) {
        Jugando nuevoEstado = new Jugando();
        maquina.cambiarEstado(nuevoEstado);
    }
}
