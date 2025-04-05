package umg.edu.gt.test.EjercicioTree;

import org.junit.jupiter.api.Test;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class TestEjerciciosTree {
    
    @Test
    public void testFrecuenciaPalabras() {
        String archivoPrueba = "test.txt";


        try (PrintWriter writer = new PrintWriter(archivoPrueba)) {
            writer.println("Hola mundo, hola amigo!");
            writer.println("Mundo es grande y bonito. Hola mundo!");
        } catch (Exception e) {
            fail("No se pudo crear el archivo de prueba.");
        }

       
        Map<String, Integer> resultado = EjercicioTreeSetAndMap.analizarFrecuenciaPalabras(archivoPrueba);


        assertNotNull(resultado);
        assertEquals(3, resultado.get("hola"));
        assertEquals(3, resultado.get("mundo"));
        assertEquals(1, resultado.get("amigo"));
        assertEquals(1, resultado.get("es"));
        assertEquals(1, resultado.get("grande"));
        assertEquals(1, resultado.get("y"));
        assertEquals(1, resultado.get("bonito"));
    }
    
    @Test
    public void testRastreadorVersiones() {
 
        EjercicioTreeSetAndMap.agregarVersion("System.out.println('Hola Mundo');");
        EjercicioTreeSetAndMap.agregarVersion("System.out.println('Hola Java');");


        assertEquals("System.out.println('Hola Java');", EjercicioTreeSetAndMap.obtenerUltimaVersion());


        assertEquals("System.out.println('Hola Mundo');", EjercicioTreeSetAndMap.obtenerVersion(1));

                EjercicioTreeSetAndMap.eliminarVersion(1);
        assertEquals("Versión no encontrada", EjercicioTreeSetAndMap.obtenerVersion(1));
    }
    @Test
    void testAgregarEvento() {
        LocalDateTime fechaEvento = LocalDateTime.of(2025, 4, 15, 14, 0);
        EjercicioTreeSetAndMap.agregarEvento(fechaEvento, "Taller de Machine Learning", "Sala 3");

        assertEquals(1, EjercicioTreeSetAndMap.eventos.size());
           }

    @Test
    void testMostrarEventos() {
        LocalDateTime fechaEvento1 = LocalDateTime.of(2025, 4, 15, 14, 0);
        LocalDateTime fechaEvento2 = LocalDateTime.of(2025, 5, 10, 10, 0);
        EjercicioTreeSetAndMap.agregarEvento(fechaEvento1, "Taller de Machine Learning", "Sala 3");
        EjercicioTreeSetAndMap.agregarEvento(fechaEvento2, "Conferencia de Java", "Auditorio A");

        EjercicioTreeSetAndMap.mostrarEventos();      }

    @Test
    void testObtenerProximoEvento() {
        LocalDateTime fechaEvento1 = LocalDateTime.of(2025, 4, 15, 14, 0);
        LocalDateTime fechaEvento2 = LocalDateTime.of(2025, 5, 10, 10, 0);
        EjercicioTreeSetAndMap.agregarEvento(fechaEvento1, "Taller de Machine Learning", "Sala 3");
        EjercicioTreeSetAndMap.agregarEvento(fechaEvento2, "Conferencia de Java", "Auditorio A");

        assertEquals("Taller de Machine Learning", EjercicioTreeSetAndMap.obtenerProximoEvento().getNombre());
    }

    @Test
    void testEliminarEventosPasados() {
        LocalDateTime fechaEventoPasado = LocalDateTime.of(2020, 4, 15, 14, 0);
        LocalDateTime fechaEventoFuturo = LocalDateTime.of(2025, 4, 15, 14, 0);
        EjercicioTreeSetAndMap.agregarEvento(fechaEventoPasado, "Evento Pasado", "Sala 1");
        EjercicioTreeSetAndMap.agregarEvento(fechaEventoFuturo, "Evento Futuro", "Sala 2");

        EjercicioTreeSetAndMap.eliminarEventosPasados();

        assertEquals(1, EjercicioTreeSetAndMap.eventos.size());
    }
}
