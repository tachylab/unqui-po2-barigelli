package ar.edu.unq.po2.tp4.supermercado;

public class Producto {

    //Atributos
    protected String  nombre;
    protected double  precio;
    protected boolean esPrecioCuidado;


    //Constructores
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.esPrecioCuidado = false;
    }

    public Producto(String nombre, double precio, boolean esPrecioCuidado) {
        this.nombre = nombre;
        this.precio = precio;
        this.esPrecioCuidado = esPrecioCuidado;
    }


    //Accessors
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean esPrecioCuidado() {
        return esPrecioCuidado;
    }

    //Métodos
    public void aumentarPrecio(double cantidad) {
        this.precio += cantidad;
    }
}
