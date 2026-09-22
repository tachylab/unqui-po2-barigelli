package ar.edu.unq.po2.tp5;

public class Impuesto implements Facturable{
    //Atributos
    private double tasaServicio;

    //Constructores
    public Impuesto(double tasaServicio) {
        this.tasaServicio = tasaServicio;
    }

    //Métodos
    @Override
    public double montoAPagar() {
        return tasaServicio;
    }
}
