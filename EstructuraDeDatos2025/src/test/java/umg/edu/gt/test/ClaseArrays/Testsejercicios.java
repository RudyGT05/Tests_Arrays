package umg.edu.gt.test.ClaseArrays;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testsejercicios {

	 @Test
	    void testclientemasrico() {
		 
	        int[][] cuentas = {{1, 2, 3}, {3, 2, 1}};
	        
	        assertEquals(6, EjercicioArrays.clientemasrico(cuentas));
	    }
	 
	 @Test
	    void testclientemasrico10falla() {
	        int[][] cuentas = {{6, 8, 3}, {3, 2, 1}};
	        assertEquals(6, EjercicioArrays.clientemasrico(cuentas));
	    }
	    @Test
	    void testordenardiagonales() {
	        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
	        int[][] esperado = {{1, 1, 1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3}};
	        assertArrayEquals(esperado, EjercicioArrays.ordenardiagonales(mat));
	    }

	    @Test
	    void testordenardiagonales1() {
	        int[][] mat = {{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}};
	        int[][] esperado = {{5, 17, 4, 1, 52, 7}, {11, 11, 25, 45, 8, 69}, {14, 23, 25, 44, 58, 15}, {22, 27, 31, 36, 50, 66}, {84, 28, 75, 33, 55, 68}};
	        assertArrayEquals(esperado, EjercicioArrays.ordenardiagonales(mat));
	    }
	 @Test
	    void testsumarmatriz() {
	        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	        assertEquals(45, EjercicioArrays.sumarmatriz(mat));
	    }


	    @Test
	    void testsumarmatriz1falla() {
	        int[][] mat = {{1, 2}, {3, 4}};
	       
	        assertEquals(9, EjercicioArrays.sumarmatriz(mat));
	    }
	 
}
	


