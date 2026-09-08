package ar.edu.unq.po2.tp4.supermercado;

public class ProductoPrimeraNecesidad extends Producto {

    //Atributos
    private double descuento;


    //Constructores
    public ProductoPrimeraNecesidad(String nombre, double precio, double descuento) {
        super(nombre, precio);
        this.descuento = descuento;
    }

    public ProductoPrimeraNecesidad(String nombre, double precio, boolean esPrecioCuidado,  double descuento) {
        super(nombre, precio, esPrecioCuidado);
        this.descuento = descuento;
    }

    //Métodos
    @Override
    public double getPrecio() {
        return this.precio * this.calculoDescuento();
    }

    private double calculoDescuento() {
        return (100 - this.descuento) / 100;
    }

}
