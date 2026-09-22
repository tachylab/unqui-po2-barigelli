package ar.edu.unq.po2.tp5;

public class Servicio implements Facturable{
    //Atributos
    private double costoUnidad;
    private int unidades;

    //Constructores
    public Servicio(double costoUnidad, int unidades) {
        this.costoUnidad = costoUnidad;
        this.unidades = unidades;
    }

    @Override
    public double montoAPagar() {
        return costoUnidad * unidades;
    }
}
