package ar.edu.unq.po2.tp5;

public class ProductoCooperativa extends Producto{

    private int descuento = 10;

    public ProductoCooperativa(double precio) {
        super(precio);
    }

    @Override
    public double getPrecio() {
        return precio - calcularDescuento();
    }

    private double calcularDescuento() {
        return (precio * descuento) / 100;
    }
}
