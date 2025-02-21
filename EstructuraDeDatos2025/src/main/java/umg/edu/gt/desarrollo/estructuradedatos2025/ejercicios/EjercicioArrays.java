package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.ArrayList;
import java.util.Collections;

public class EjercicioArrays {

    public static int clientemasrico(int[][] cuentas) {
        if (cuentas.length < 1 || cuentas.length > 50) {
            throw new IllegalArgumentException("El número de clientes debe estar entre 1 y 50");
        }
        for (int[] cliente : cuentas) {
            if (cliente.length < 1 || cliente.length > 50) {
                throw new IllegalArgumentException("El número de cuentas por cliente debe estar entre 1 y 50");
            }
            for (int cuenta : cliente) {
                if (cuenta < 1 || cuenta > 100) {
                    throw new IllegalArgumentException("Cada cuenta debe contener entre 1 y 100 unidades monetarias");
                }
            }
        }

        int maxRiqueza = 0;
        for (int[] cliente : cuentas) {
            int riquezaActual = 0;
            for (int cuenta : cliente) {
                riquezaActual += cuenta;
            }
            maxRiqueza = Math.max(maxRiqueza, riquezaActual);
        }
        return maxRiqueza;
    }

    public static int[][] ordenardiagonales(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("La matriz no puede ser nula o vacía.");
        }
        int m = mat.length;
        int n = mat[0].length;
        if (m < 1 || m > 100 || n < 1 || n > 100) {
            throw new IllegalArgumentException("El tamaño de la matriz debe estar entre 1x1 y 100x100.");
        }

        for (int[] fila : mat) {
            for (int elemento : fila) {
                if (elemento < 1 || elemento > 100) {
                    throw new IllegalArgumentException("Los valores de la matriz deben estar entre 1 y 100.");
                }
            }
        }

        for (int j = 0; j < n; j++) {
            ordenarladiagonal(mat, 0, j);
        }

        for (int i = 1; i < m; i++) {
            ordenarladiagonal(mat, i, 0);
        }

        return mat;
    }

    private static void ordenarladiagonal(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;
        ArrayList<Integer> diagonal = new ArrayList<>();

        int fila = i, columna = j;
        while (fila < m && columna < n) {
            diagonal.add(mat[fila][columna]);
            fila++;
            columna++;
        }

        Collections.sort(diagonal);

        fila = i;
        columna = j;
        for (int k = 0; k < diagonal.size(); k++) {
            mat[fila][columna] = diagonal.get(k);
            fila++;
            columna++;
        }
    }

    public static int sumarmatriz(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("La matriz no puede estar vacia.");
        }
        int m = mat.length;
        int n = mat[0].length;
        if (m < 1 || m > 100 || n < 1 || n > 100) {
            throw new IllegalArgumentException("El tamaño de la matriz debe estar entre 1x1 y 100x100");
        }

        for (int[] fila : mat) {
            for (int elemento : fila) {
                if (elemento < 1 || elemento > 1000) {
                    throw new IllegalArgumentException("Los valores de la matriz deben estar entre 1 y 1000");
                }
            }
        }

        int suma = 0;
        for (int[] fila : mat) {
            for (int elemento : fila) {
                suma += elemento;
            }
        }

        return suma;
    }
}

	

	/** INSTRUCCIONES
	 	Escriba el algoritmo que resuelve el problema en esta clase.
		Debe crear un package llamado umg.edu.gt.test.ClaseArrays que corresponda al Test de esta clase.
		Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
		y compararlo con el esperado.
	 */
	
	/* EJERCICIO 1:
	Se le da una cuadrícula de enteros m x n cuentas donde cuentas[i][j] es la cantidad de dinero que el i-ésimo cliente tiene en el j-ésimo banco. Devuelve la riqueza que tiene el cliente más rico.
	La riqueza de un cliente es la cantidad de dinero que tiene en todas sus cuentas bancarias. El cliente más rico es el que tiene el máximo patrimonio. 

	Ejemplo 1:
	Entrada: cuentas = [[1,2,3],[3,2,1]]
	Salida: 6
	Explicación:
	1er cliente tiene riqueza = 1 + 2 + 3 = 6
	El 2º cliente tiene riqueza = 3 + 2 + 1 = 6
	Ambos clientes se consideran los más ricos con una riqueza de 6 cada uno, por lo que devuelve 6.
	Ejemplo 2:
	Entrada: cuentas = [[1,5],[7,3],[3,5]]
	Salida: 10
	Explicación: 
	1er cliente tiene riqueza = 6
	El 2º cliente tiene un patrimonio = 10 
	El 3er cliente tiene una riqueza = 8
	El 2º cliente es el más rico con una riqueza de 10.
	Ejemplo 3
	Entrada: cuentas = [[2,8,7],[7,1,3],[1,9,5]]
	Salida: 17
	Restricciones:
	m == cuentas.longitud
	n == cuentas[i].longitud
	1 <= m, n <= 50
	1 <= cuentas[i][j] <= 100	
	*/
	
	/* Ejercicio 2
	Una diagonal de matriz es una línea diagonal de celdas que comienza en alguna celda de la fila superior o de la columna más a la izquierda y continúa en dirección inferior derecha hasta llegar al final de la matriz. 
	Por ejemplo, la diagonal de matriz que comienza en mat[2][0], donde mates una 6 x 3matriz, incluye las celdas mat[2][0], mat[3][1]y mat[4][2].
	Dada una m x nmatriz matde números enteros, ordena cada diagonal de la matriz en orden ascendente y devuelve la matriz resultante .
	Ejemplo 1:
	Entrada: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
	Salida: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
	Ejemplo 2:
	Entrada: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
	Salida : [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
	Restricciones:	
		m == mat.length
		n == mat[i].length
		1 <= m, n <= 100
		1 <= mat[i][j] <= 100 	 
	 */
	
	/* Ejercicio 3
	Dada una matriz m x n de números enteros, calcula la suma de todos los elementos de la matriz.

	Ejemplo 1
	Entrada: mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
	Salida: 45
	Explicación:
	1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45	
	Ejemplo 2
	Entrada: mat = [[10, 20], [30, 40]]
	Salida: 100
	Explicación:
	10 + 20 + 30 + 40 = 100

	Restricciones
	1 <= m, n <= 100
	1 <= mat[i][j] <= 1000
	 */


