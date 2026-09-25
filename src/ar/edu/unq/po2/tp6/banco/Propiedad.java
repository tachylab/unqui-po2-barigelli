package ar.edu.unq.po2.tp6.banco;

public class Propiedad implements IPropiedad {

    //Atributo
    private String descripcion;
    private String direccion;
    private double valorFiscal;

    //Constructor
    public Propiedad(String descripcion, String direccion, double valorFiscal) {
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.valorFiscal = valorFiscal;
    }

    //Métodos
    @Override
    public double valorFiscal() {
        return valorFiscal;
    }

}
