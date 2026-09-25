package ar.edu.unq.po2.tp6.banco;

public class SolicitudCreditoPersonal extends SolicitudCredito {

    //Atributos
    protected int minimoIngresoAnual;
    protected double maximoPorcentajeCuota;

    //Constructores
    public SolicitudCreditoPersonal(ICliente cliente, double montoSolicitado, int plazoMeses, int minimoIngresoAnual, double maximoPorcentajeCuota) {
        super(cliente, montoSolicitado, plazoMeses);
        this.minimoIngresoAnual = minimoIngresoAnual;
        this.maximoPorcentajeCuota = maximoPorcentajeCuota;
    }

    //Métodos
    @Override
    public boolean esAceptable() {
        return condicionIngresosAnuales() && condicionMaximoPorcentajeCuota();
    }

    private boolean condicionIngresosAnuales() {
        return cliente.sueldoNetoAnual() >= minimoIngresoAnual;
    }

    private boolean condicionMaximoPorcentajeCuota() {
        return cuotaMensual() <= (cliente.sueldoNetoMensual() * (maximoPorcentajeCuota / 100));
    }
}
