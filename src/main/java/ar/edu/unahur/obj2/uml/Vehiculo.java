package ar.edu.unahur.obj2.uml;

public abstract class Vehiculo { //clase abstracta
    
    private boolean disponible; //atributo que indica si el vehiculo está disponible

    public Vehiculo (boolean disponible){       //contructor de la clase, recibe parametro booleano que indica su disponibilidad
        this.disponible = disponible;           //this.disponible se refiere al atributo de la clase ; disponible es el parametro del constructor ; asigna el parametro al atributo
    }

    public boolean estaDisponible(){            //getter
        return this.disponible;
    }
    public void cambiarDisponible(boolean disponible){ //setter
        this.disponible = disponible;
    }
    // por convención: Atributos en private ; metodos que se necesitan usar desde afuera Public
}



