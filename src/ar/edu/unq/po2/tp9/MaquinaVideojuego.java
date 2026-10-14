package ar.edu.unq.po2.tp9;

public class MaquinaVideojuego {

    //Atributos
    private EstadoVideojuego  estado;

    //Constructor
    public MaquinaVideojuego(EstadoVideojuego estado) {
        this.estado = estado;
    }


    //Métodos
    public void ingresarFicha() {
        estado.ingresarFicha(this);
    }

    public void presionarBotonInicio() {
        estado.presionarBotonInicio(this);
    }

    public void terminarJuego() {
        estado.terminarJuego(this);
    }

    public void cambiarEstado(EstadoVideojuego estado) {
        this.estado = estado;
    }
}
