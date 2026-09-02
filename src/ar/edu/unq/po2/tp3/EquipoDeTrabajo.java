package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.List;

public class EquipoDeTrabajo {
    //Atributos
    String nombre;
    List<Persona> integrantes = new ArrayList<>();

    //Constructores
    public EquipoDeTrabajo(String nombre) {
        this.nombre = nombre;
    }

    //Accessors
    public String  getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Otros métodos

    public void addIntegrante(Persona integrante) {
        integrantes.add(integrante);
    }

    public int promedioEdadIntegrantes() {
        return edadTotalIntegrantes() /integrantes.size();
    }

    public int edadTotalIntegrantes() {
        int sumaTotal = 0;
        for (Persona persona : integrantes) {
            sumaTotal += persona.edad();
        }
        return sumaTotal;
    }
}
