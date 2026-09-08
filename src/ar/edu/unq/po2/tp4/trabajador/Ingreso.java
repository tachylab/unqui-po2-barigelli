package ar.edu.unq.po2.tp4.trabajador;

public class Ingreso {

    //Atributos
    protected String mesPercepcion;
    protected String concepto;
    protected double montoPercibido;

    //Constructores
    public Ingreso(String mesPercepcion, String concepto, double montoPercibido) {
        this.mesPercepcion = mesPercepcion;
        this.concepto = concepto;
        this.montoPercibido = montoPercibido;
    }

    //Accessors
    public String getMesPercepcion() {
        return mesPercepcion;
    }

    public String getConcepto() {
        return concepto;
    }

    public double getMontoPercibido() {
        return montoPercibido;
    }

    //Métodos
    public double getMontoImponible() {
        return montoPercibido;
    }
}
