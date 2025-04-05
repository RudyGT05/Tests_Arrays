package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class EjercicioTreeSetAndMap {
    public static TreeSet<Evento> eventos = new TreeSet<>();
    private static TreeMap<Integer, String> versiones = new TreeMap<>();
    private static int ultimaVersion = 0;


    public static Map<String, Integer> analizarFrecuenciaPalabras(String archivo) {
        Map<String, Integer> frecuenciaPalabras = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
    
                linea = linea.toLowerCase().replaceAll("[^a-záéíóúüñ]", " ");
                String[] palabras = linea.split("\\s+");

                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return frecuenciaPalabras;
    }

    public static void imprimirFrecuenciaPalabras(Map<String, Integer> frecuenciaPalabras) {
        for (Map.Entry<String, Integer> entry : frecuenciaPalabras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public static void agregarVersion(String contenido) {
        ultimaVersion++;
        versiones.put(ultimaVersion, contenido);
        System.out.println("Agregar versión " + ultimaVersion + ": \"" + contenido + "\"");
    }

    public static String obtenerVersion(int numeroVersion) {
        return versiones.getOrDefault(numeroVersion, "Versión no encontrada");
    }

    public static String obtenerUltimaVersion() {
        if (versiones.isEmpty()) {
            return "No hay versiones disponibles";
        }
        return versiones.get(ultimaVersion);
    }

    public static void eliminarVersion(int numeroVersion) {
        if (versiones.containsKey(numeroVersion)) {
            versiones.remove(numeroVersion);
            System.out.println("Versión " + numeroVersion + " eliminada.");
        } else {
            System.out.println("Versión no encontrada.");
        }
    }

 
    public static void agregarEvento(LocalDateTime fecha, String nombre, String ubicacion) {
        Evento evento = new Evento(fecha, nombre, ubicacion);
        eventos.add(evento);
        System.out.println("Evento agregado: " + evento);
    }

    public static void mostrarEventos() {
        System.out.println("Lista de eventos:");
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }

    public static Evento obtenerProximoEvento() {
        eliminarEventosPasados();
        return eventos.isEmpty() ? null : eventos.first();
    }

    public static void eliminarEventosPasados() {
        LocalDateTime ahora = LocalDateTime.now();
        eventos.removeIf(evento -> evento.getFecha().isBefore(ahora));
    }

    
    public static class Evento implements Comparable<Evento> {
        private LocalDateTime fecha;
        private String nombre;
        private String ubicacion;

        public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
            this.fecha = fecha;
            this.nombre = nombre;
            this.ubicacion = ubicacion;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public String getNombre() {
            return nombre;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        @Override
        public int compareTo(Evento otro) {
            return this.fecha.compareTo(otro.fecha);
        }

        @Override
        public String toString() {
            return "\"" + nombre + "\", " + fecha + ", " + ubicacion;
        }
    }
    
    
    
}

    
	//Ejercicio 3//
	
	
	/** INSTRUCCIONES
 	Escriba el algoritmo que resuelve el problema en esta clase.
	Debe crear un package llamado umg.edu.gt.test.EjercicioTree que corresponda al Test de esta clase.
	Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
	y compararlo con el esperado.
	 */
	
	/* EJERCICIO 1: Análisis de Frecuencia de Palabras (TreeMap)
	 * 📜 Descripción: Escriba un programa que lea un texto de un archivo y cuente la frecuencia de cada palabra, ordenándolas alfabéticamente.
		🔹 Instrucciones:
			Leer un archivo de texto (.txt).			
			Dividir el texto en palabras (ignorando puntuaciones y convirtiéndolas a minúsculas).
			Almacenar cada palabra en un TreeMap<String, Integer>, donde la clave es la palabra y el valor es el número de veces que aparece.
			Imprimir las palabras en orden alfabético junto con su frecuencia.
	 */
	
	
	/* EJERCICIO 2: Rastreador de Versiones de Código (TreeMap)
		📜 Descripción: Desarrolle un programa que simule un rastreador de versiones de archivos en un sistema de control de versiones.
		🔹 Instrucciones:
			Utilice un TreeMap<Integer, String>, donde la clave representa el número de versión y el valor es el contenido de esa versión del código.			
			Debe permitir:			
			Agregar una nueva versión con una clave autoincrementada.			
			Obtener una versión específica dada su clave.			
			Obtener la última versión disponible.			
			Eliminar una versión específica si es necesario.
			
			Salida:
				Agregar versión 1: "System.out.println('Hola Mundo');"
				Agregar versión 2: "System.out.println('Hola Java');"
				Última versión: "System.out.println('Hola Java');"
				Versión 1: "System.out.println('Hola Mundo');"

	 * 
	 */
	
	/** EJERCICIO 3: Sistema de Gestión de Eventos (TreeSet)
		📜 Descripción: Implemente un sistema para administrar eventos ordenados cronológicamente.		
		🔹 Instrucciones:		
			Utilice un TreeSet<Evento>, donde cada Evento debe contener:		
			fecha (LocalDateTime)		
			nombre (String)		
			ubicación (String)		
			Los eventos deben ordenarse automáticamente por fecha y hora.		
			Debe permitir:		
				Agregar un nuevo evento.		
				Mostrar la lista de eventos en orden cronológico.		
				Obtener el próximo evento a ocurrir.		
				Eliminar un evento pasado automáticamente después de una consulta.
				
			Salida:
				Próximo evento: "Conferencia de Java", 2025-05-10 10:00, Auditorio A  
				Lista de eventos:  
				1. "Taller de Machine Learning", 2025-04-15 14:00, Sala 3  
				2. "Conferencia de Java", 2025-05-10 10:00, Auditorio A  

	 */
	
	



