package umg.edu.gt.estructuradedatos2025.lombokprueba;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Persona {
    private String nombre;
    private int edad;
    private String email;
}