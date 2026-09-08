package ar.edu.unq.po2.tp4.trabajador;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {

    //Atributos
    private List<Ingreso> ingresos = new ArrayList<>();
    private double impuestoAlTrabajador = 2;


    //Métodos
    public void agregarIngreso(Ingreso ingreso){
        ingresos.add(ingreso);
    }

    public double getTotalPercibido() {
        return ingresos.stream().mapToDouble(Ingreso::getMontoPercibido).sum();
    }

    public double getMontoImponible() {
        return ingresos.stream().mapToDouble(Ingreso::getMontoImponible).sum();
    }

    public double getImpuestoAPagar() {
        return getMontoImponible() * calcularImpuestoAlTrabajador();
    }

    public double calcularImpuestoAlTrabajador() {
        return impuestoAlTrabajador / 100;
    }
}
