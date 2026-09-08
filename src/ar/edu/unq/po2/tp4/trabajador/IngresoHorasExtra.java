package ar.edu.unq.po2.tp4.trabajador;

public class IngresoHorasExtra extends Ingreso {

    //Atributos
    private int horasExtra;

    //Constructores
    public IngresoHorasExtra(String mesPercepcion, String concepto, double montoPercibido, int horasExtra) {
        super(mesPercepcion, concepto, montoPercibido);
        this.horasExtra = horasExtra;
    }

    //Accessors
    public int getHorasExtra() {
        return horasExtra;
    }

    //Métodos
    @Override
    public double getMontoImponible() {
        return 0;
    }
}
