package ar.edu.unahur.obj2.uml;

import java.time.LocalDate;

public class Alquiler {

    private String fechaInicio;

    private String fechaFin;

    private Usuario usuario;

    private Vehiculo vehiculo;
    // El tipo es "Vehiculo" (la clase abstracta) y no Bicicleta o Monopatin.
    // Es polimorfismo: no importa qué tipo concreto sea,
    // alcanza con saber que es un Vehiculo.

    public Alquiler (String fechaInicio, String fechaFin, Usuario usuario, Vehiculo vehiculo){
        this.fechaInicio= fechaInicio;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
        this.vehiculo= vehiculo;
    }

    // Getter para leer la fecha de inicio.
    public String getFechaInicio() {
        return this.fechaInicio;
    }

    // Getter para leer la fecha de fin.
    public String getFechaFin() {
        return this.fechaFin;
    }

    // Getter para leer el usuario del alquiler.
    public Usuario getUsuario() {
        return this.usuario;
    }

    // Getter para leer el vehículo del alquiler.
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
}
 
}
