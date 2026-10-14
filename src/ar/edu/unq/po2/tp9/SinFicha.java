package ar.edu.unq.po2.tp9;

public class SinFicha extends EstadoVideojuego {

    @Override
    public void ingresarFicha(MaquinaVideojuego maquina) {
        UnaFicha nuevoEstado = new UnaFicha();
        maquina.cambiarEstado(nuevoEstado);
    }

}
