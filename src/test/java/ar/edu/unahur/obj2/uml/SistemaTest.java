// Mismo paquete que las clases del proyecto.
// Aunque está en src/test, el paquete es el mismo para poder acceder a las clases.
package ar.edu.unahur.obj2.uml;

// Importamos las herramientas de JUnit 5 que vamos a usar.
// "@Test" marca un método como test ejecutable.
import org.junit.jupiter.api.Test;
// "@BeforeEach" marca un método que se ejecuta ANTES de cada test.
import org.junit.jupiter.api.BeforeEach;
// "assertEquals" verifica que dos valores sean iguales.
import static org.junit.jupiter.api.Assertions.assertEquals;
// "assertTrue" verifica que una condición sea verdadera.
import static org.junit.jupiter.api.Assertions.assertTrue;
// "assertFalse" verifica que una condición sea falsa.
import static org.junit.jupiter.api.Assertions.assertFalse;
// "assertThrows" verifica que un método lance una excepción.
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

// Clase de test. Por convención se llama igual que la clase que testea + "Test".
public class SistemaTest {

    // Declaramos los objetos que vamos a usar en los tests.
    // Los declaramos acá arriba para que sean accesibles desde todos los métodos.
    // Todavía no los inicializamos, eso lo hace el @BeforeEach.
    private Sistema sistema;
    private Usuario usuario;
    private Bicicleta bicicleta;
    private Monopatin monopatin;

    // Este método se ejecuta ANTES de cada test individual.
    // Su función es preparar un estado limpio para cada test.
    // Así cada test arranca desde cero, sin que los resultados
    // de un test afecten a los demás.
    // En Wollok esto era el fixture.
    @BeforeEach
    void setUp() {
        // Creamos una instancia fresca del sistema antes de cada test.
        sistema = new Sistema();

        // Creamos un usuario de prueba.
        usuario = new Usuario("Ana");

        // Creamos una bicicleta disponible de rodado 26.
        bicicleta = new Bicicleta(26, true);

        // Creamos un monopatin disponible de marca "Xiaomi".
        monopatin = new Monopatin("Xiaomi", true);

        // Registramos todo en el sistema.
        sistema.registrarUsuario(usuario);
        sistema.registrarVehiculo(bicicleta);
        sistema.registrarVehiculo(monopatin);
    }

    // ─── TESTS DE VEHÍCULOS ──────────────────────────────────────

    // Cada método anotado con @Test es un test independiente.
    // El nombre debe describir claramente qué está verificando.
    @Test
    void unaBicicletaRecienCreadaTieneElRodadoCorrecto() {
        // "assertEquals(esperado, obtenido)"
        // Verifica que el rodado de la bicicleta sea 26.
        // Si no coinciden, el test falla y JUnit te avisa.
        assertEquals(26, bicicleta.esRodado());
    }

    @Test
    void unMonopatinRecienCreadoTieneLaMarcaCorrecta() {
        assertEquals("Xiaomi", monopatin.esMarca());
    }

    // ─── TESTS DE DISPONIBILIDAD ─────────────────────────────────

    @Test
    void elSistemaMuestraLosDosVehiculosCuandoAmbosEstanDisponibles() {
        // Verificamos que la lista de disponibles tenga exactamente 2 elementos.
        // "size()" devuelve la cantidad de elementos de una lista.
        assertEquals(2, sistema.vehiculosDisponibles().size());
    }

    @Test
    void elSistemaMuestraUnVehiculoMenosDespuesDeUnAlquiler() {
        // Alquilamos la bicicleta.
        sistema.alquilar(
            usuario,
            bicicleta,
            "2024-01-01",
            "2024-01-07"
        );

        // Después del alquiler solo debe quedar 1 vehículo disponible.
        assertEquals(1, sistema.vehiculosDisponibles().size());
    }

    @Test
    void laBicicletaNoEstaDisponibleDespuesDeAlquilarla() {
        sistema.alquilar(
            usuario,
            bicicleta,
            /*LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 7)*/
            "2024-01-01",
            "2024-01-07"
        );

        // "assertFalse" verifica que la condición sea falsa.
        // La bicicleta ya no debe estar disponible.
        assertFalse(bicicleta.estaDisponible());
    }

    // ─── TESTS DE ALQUILER ───────────────────────────────────────

    @Test
    void elAlquilerSeRegistraEnElSistema() {
        sistema.alquilar(
            usuario,
            bicicleta,
            /*LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 7)*/
            "2024-01-01",
            "2024-01-07"    
        );

        // Verificamos que el sistema tenga exactamente 1 alquiler registrado.
        assertEquals(1, sistema.obtenerAlquileres().size());
    }

    @Test
    void elAlquilerSeRegistraEnElUsuario() {
        sistema.alquilar(
            usuario,
            bicicleta,
            /*LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 7)*/
            "2024-01-01",
            "2024-01-07"    
        );

        // Verificamos que el usuario tenga exactamente 1 alquiler en su historial.
        assertEquals(1, usuario.getAlquileres().size());
    }

    @Test
    void noSePuedeAlquilarUnVehiculoNoDisponible() {
        // Alquilamos la bicicleta por primera vez.
        sistema.alquilar(
            usuario,
            bicicleta,
            /*LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 7)*/
            "2024-01-01",
            "2024-01-07"        
        );

        // "assertThrows" verifica que al ejecutar el código del segundo parámetro
        // se lance una excepción del tipo indicado en el primer parámetro.
        // "() ->" es una lambda: le pasamos el código a ejecutar sin ejecutarlo todavía,
        // para que assertThrows lo ejecute él y capture la excepción.
        assertThrows(RuntimeException.class, () -> {
            sistema.alquilar(
                usuario,
                bicicleta,
                /*LocalDate.of(2024, 2, 1),
                LocalDate.of(2024, 2, 7)*/
                "2024-02-01",
                "2024-02-07"
            );
        });
    }
    //agregando covertura para jacoco
    @Test
void elAlquilerGuardaLaFechaDeInicioCorrecta() {
    String inicio = /*LocalDate.of(2024, 1, 1);*/"2024-01-01";
    String fin = /*LocalDate.of(2024, 1, 7);*/"2024-01-07";
    
    Alquiler alquiler = sistema.alquilar(usuario, bicicleta, inicio, fin);
    
    // Verificamos que el alquiler guardó correctamente la fecha de inicio.
    assertEquals(inicio, alquiler.getFechaInicio());
}

@Test
void elAlquilerGuardaElUsuarioCorrecto() {
    Alquiler alquiler = sistema.alquilar(
        usuario, bicicleta,
        /*LocalDate.of(2024, 1, 1),
        LocalDate.of(2024, 1, 7)*/
        "2024-01-01",
        "2024-01-07"
    );

    // Verificamos que el alquiler referencia al usuario correcto.
    assertEquals(usuario, alquiler.getUsuario());
}
}
