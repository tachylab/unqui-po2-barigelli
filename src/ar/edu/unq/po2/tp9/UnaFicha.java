package ar.edu.unq.po2.tp9;

public class UnaFicha extends EstadoVideojuego {

    @Override
    public void ingresarFicha(MaquinaVideojuego maquina) {
        DosFichas nuevoEstado = new DosFichas();
        maquina.cambiarEstado(nuevoEstado);
    }

    @Override
    public void presionarBotonInicio(MaquinaVideojuego maquina) {
        Jugando nuevoEstado = new Jugando();
        maquina.cambiarEstado(nuevoEstado);
    }
}
