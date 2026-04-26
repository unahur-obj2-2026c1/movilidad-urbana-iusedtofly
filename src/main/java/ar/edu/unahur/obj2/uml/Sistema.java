package ar.edu.unahur.obj2.uml;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Vehiculo> vehiculos;
    private List<Usuario> usuarios;
    private List<Alquiler> alquileres;

    public Sistema() { //constructor , inicializamos las tres listas Vacías
        this.vehiculos = new ArrayList<>();
        this.usuarios = new ArrayList <>();
        this.alquileres = new ArrayList <>();
    }

    //****** Metodos de registro de vehiculos/ usuarios/alquileres *****
    public void registrarVehiculo (Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo); //polimorfismo acá, el vehic. puede ser bici o monopatín 
    }
    public void registrarUsuario (Usuario usuario) {
        this.usuarios.add(usuario);
    }
    //registrar Alquiler
    public Alquiler alquilar (Usuario usuario, Vehiculo vehiculo, String fechaInicio, String fechaFin ) { //es un método que va a devolver un un objeto del tipo Alquiler por eso "public Alquiler alquilar ""
        //Verificando que no esté alquilado el Vehiculo
        if (!vehiculo.estaDisponible()) { //!not
            //si el vehiculo NO está disponible, devolvemos una excepción
            throw new RuntimeException ("El vehiculo no está disponible para su alquiler");
        }

        Alquiler alquiler = new Alquiler (fechaInicio, fechaFin, usuario, vehiculo); //creando el objeto Alquiler con los datos recibidos como parametros para el metodo
        vehiculo.cambiarDisponible(false); //el vehiculo de la lista del sistema pasa a estar no disponible
        this.alquileres.add(alquiler); //agregamos a a la lista del sistema el nuevo objeto alquiler originado en este metodo
        
        return alquiler; // debemos retornar porque así lo programamos
    }

    public List<Vehiculo> vehiculosDisponibles() {
        return this.vehiculos.stream().filter(vehiculo -> vehiculo.estaDisponible()).toList();
    }
    /* alternativa con lista nueva
    public List<Vehiculo> getVehiculosDisponibles() {

        // Creamos una lista vacía donde vamos a poner los disponibles.
        List<Vehiculo> disponibles = new ArrayList<>();

        // Recorremos todos los vehículos con un "for each".
        // "Vehiculo v" declara la variable temporal del loop.
        // En Wollok era: vehiculos.forEach { v => ... }
        for (Vehiculo v : this.vehiculos) {

            // Si el vehículo está disponible, lo agregamos a la lista.
            if (v.isDisponible()) {
                disponibles.add(v);
            }
        }
    
    */
    public List<Alquiler> obtenerAlquileres(){
        return this.alquileres;
    }


}