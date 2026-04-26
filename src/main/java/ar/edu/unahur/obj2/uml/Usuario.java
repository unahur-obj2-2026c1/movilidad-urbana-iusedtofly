// Mismo paquete que todas las demás clases del proyecto.
package ar.edu.unahur.obj2.uml;

// Importamos ArrayList y List, que son clases de Java para manejar colecciones.
// En Wollok usabas [] o new List() sin necesidad de importar nada.
// En Java las colecciones viven en el paquete "java.util" y hay que importarlas.
import java.util.ArrayList;
import java.util.List;

// Usuario no hereda de nadie, así que no lleva "extends".
// En Java toda clase hereda implícitamente de "Object", pero no hace falta escribirlo.
public class Usuario {

    // Atributo para el nombre del usuario.
    private String nombre;

    // Atributo para guardar todos los alquileres que hizo este usuario.
    // "List<Alquiler>" es una lista que solo puede contener objetos de tipo Alquiler.
    // Los "<>" se llaman "genéricos" — indican el tipo de elemento que tiene la lista.
    // En Wollok era simplemente una lista sin declarar el tipo de sus elementos.
    private List<Alquiler> alquileres;

    // Constructor de Usuario.
    // Solo recibe el nombre. La lista de alquileres arranca vacía.
    public Usuario(String nombre) {
        this.nombre = nombre;

        // Inicializamos la lista vacía con ArrayList.
        // "List" es la interfaz (el tipo general).
        // "ArrayList" es la implementación concreta (cómo se guarda en memoria).
        // Por ahora pensalo como: ArrayList es la versión más común de lista en Java.
        this.alquileres = new ArrayList<>();
    }

    // Getter para leer el nombre desde afuera.
    public String getNombre() {
        return this.nombre;
    }

    // Getter para leer la lista de alquileres desde afuera.
    // Devuelve la lista completa.
    public List<Alquiler> getAlquileres() {
        return this.alquileres;
    }

    // Método para agregar un alquiler a la lista de este usuario.
    // Se va a llamar desde la clase Sistema cuando se registre un alquiler.
    // "void" porque no devuelve nada, solo modifica la lista.
    public void agregarAlquiler(Alquiler alquiler) {
        // "add()" es el método de ArrayList para agregar un elemento a la lista.
        // Equivale al "add()" de Wollok.
        this.alquileres.add(alquiler);
    }
}