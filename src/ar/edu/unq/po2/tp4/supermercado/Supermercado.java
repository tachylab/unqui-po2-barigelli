package ar.edu.unq.po2.tp4.supermercado;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    //Atributos
    private List <Producto> productos = new ArrayList<>();
    private String nombre;
    private String ubicacion;


    //Constructores
    public Supermercado(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }


    //Accessors
    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    //Métodos
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public int getCantidadDeProductos() {
        return productos.size();
    }

    public double getPrecioTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

}
