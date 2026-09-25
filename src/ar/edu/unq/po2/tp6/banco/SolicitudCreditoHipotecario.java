package ar.edu.unq.po2.tp6.banco;

public class SolicitudCreditoHipotecario extends SolicitudCredito {

    //Atributos
    protected double maximoPorcentajeCuota;
    protected double maximoPorcentajeValorFiscal;
    protected int maximaEdad;
    protected IPropiedad propiedad;

    //Constructores
    public SolicitudCreditoHipotecario(ICliente cliente, double montoSolicitado, int plazoMeses, double  maximoPorcentajeCuota, double maximoPorcentajeValorFiscal, int maximaEdad,  IPropiedad propiedad) {
        super(cliente, montoSolicitado, plazoMeses);
        this.maximoPorcentajeCuota = maximoPorcentajeCuota;
        this.maximoPorcentajeValorFiscal = maximoPorcentajeValorFiscal;
        this.maximaEdad = maximaEdad;
        this.propiedad = propiedad;
    }


    //Métodos
    @Override
    public boolean esAceptable() {
        return condicionPorcentajeCuota() && condicionPorcentajeValorFiscal() && condicionMaximaEdad();
    }

    private boolean condicionPorcentajeCuota() {
        return cuotaMensual() <= (cliente.sueldoNetoMensual() * (maximoPorcentajeCuota / 100));
    }

    private boolean condicionPorcentajeValorFiscal() {
        return montoSolicitado <= (propiedad.valorFiscal() * (maximoPorcentajeValorFiscal / 100));
    }

    private boolean condicionMaximaEdad() {
        int edadEnMesesActual = cliente.edad() * 12;
        int edadEnMesesAlFinalizar = edadEnMesesActual + this.plazoMeses;
        int edadMaximaEnMeses = maximaEdad * 12;

        return edadEnMesesAlFinalizar <= edadMaximaEnMeses;
    }

}
