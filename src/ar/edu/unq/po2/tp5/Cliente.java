package ar.edu.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Facturable {
    //Atributos
    private List<Producto> productos = new ArrayList<>();

    //Métodos
    @Override
    public double montoAPagar() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public void añadirProducto(Producto producto) {
        productos.add(producto);
    }

}
