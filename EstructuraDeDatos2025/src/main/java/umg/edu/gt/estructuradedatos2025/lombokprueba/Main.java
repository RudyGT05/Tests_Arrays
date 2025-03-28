package umg.edu.gt.estructuradedatos2025.lombokprueba;

public class Main {
    public static void main(String[] args) {
        // Uso del Builder generado por Lombok
        Persona persona = Persona.builder()
                .nombre("Mauricio")
                .edad(25)
                .email("Mauricio2025@gmail.com")
                .build();

     
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());


        System.out.println("\nDatos completos:\n" + persona);
    }
}