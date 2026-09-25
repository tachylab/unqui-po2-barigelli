package ar.edu.unq.po2.tp6.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    //Atributos
    List<ICliente> clientes = new ArrayList<>();
    List<SolicitudCredito> creditos = new ArrayList<>();

    //Métodos
    public void agregarCliente(ICliente cliente) {
        clientes.add(cliente);
    }

    public void solicitarCreditoDe(SolicitudCredito solicitudCredito) {
        creditos.add(solicitudCredito);
    }

    public double montoTotalPorCreditos() {
        return creditos.stream().
                filter(solicitudCredito -> solicitudCredito.esAceptable()).
                mapToDouble(solicitudCredito -> solicitudCredito.montoSolicitado()).
                sum();

    }
}
