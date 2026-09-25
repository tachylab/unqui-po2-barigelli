package ar.edu.unq.po2.tp6.banco;

public class Persona implements ICliente {
    //Atributos
    private int edad;
    private String nombre;
    private String apellido;
    private String direccion;
    private double sueldoNetoMensual;

    //Constructor
    public Persona(int edad, String  nombre, String apellido, String direccion, double sueldoMensual) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.sueldoNetoMensual = sueldoMensual;
    }

    //Accessors
    public int edad() {
        return edad;
    }

    public String nombre() {
        return nombre;
    }

    public String apellido() {
        return apellido;
    }

    public String direccion() {
        return direccion;
    }

    public double sueldoNetoMensual() {
        return sueldoNetoMensual;
    }

    public double sueldoNetoAnual() {
        return sueldoNetoMensual * 12;
    }
}
