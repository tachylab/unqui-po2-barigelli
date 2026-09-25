package ar.edu.unq.po2.tp6.banco;

public abstract class SolicitudCredito {

    //Atributos
    protected ICliente cliente;
    protected double montoSolicitado;
    protected int plazoMeses;

    //Constructores
    public SolicitudCredito(ICliente cliente,  double montoSolicitado, int plazoMeses) {
        this.cliente = cliente;
        this.montoSolicitado = montoSolicitado;
        this.plazoMeses = plazoMeses;
    }

    //Métodos
    public abstract boolean esAceptable();

    public double montoSolicitado() {
        return montoSolicitado;
    }

    public double cuotaMensual() {return montoSolicitado / plazoMeses;}
}
