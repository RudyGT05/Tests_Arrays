package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.LinkedList;
import java.util.HashSet;

public class EjercicioLinkedList {

    // Problema 1: Eliminar duplicados
    public static LinkedList<Integer> eliminarDuplicados(LinkedList<Integer> lista) {
        HashSet<Integer> conjunto = new HashSet<>();
        LinkedList<Integer> listaSinDuplicados = new LinkedList<>();

        for (Integer numero : lista) {
            if (!conjunto.contains(numero)) {
                conjunto.add(numero);
                listaSinDuplicados.add(numero);
            }
        }
        return listaSinDuplicados;
    }

    // Problema 2: Invertir la lista de String
    public static LinkedList<String> invertirLista(LinkedList<String> lista) {
        LinkedList<String> listaInvertida = new LinkedList<>();
        
        
        for (String elemento : lista) {
            listaInvertida.addFirst(elemento);
        }
        return listaInvertida;
    }

    // Problema 3: Intercalar dos listas ordenadas
    public static LinkedList<Integer> intercalarListas(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
        LinkedList<Integer> listaIntercalada = new LinkedList<>();
        int i = 0, j = 0;

        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {
                listaIntercalada.add(lista1.get(i));
                i++;
            } else {
                listaIntercalada.add(lista2.get(j));
                j++;
            }
        }

   
        while (i < lista1.size()) {
            listaIntercalada.add(lista1.get(i));
            i++;
        }

     
        while (j < lista2.size()) {
            listaIntercalada.add(lista2.get(j));
            j++;
        }

        return listaIntercalada;
    }

}



	
	
	/** INSTRUCCIONES
 	Escriba el algoritmo que resuelve el problema en esta clase.
	Debe crear un package llamado umg.edu.gt.test.EjercicioLinkedList que corresponda al Test de esta clase.
	Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
	y compararlo con el esperado.
	 */
	
	// Usando LinkedList de Java Collections, resuelva los siguientes problemas
	// Problema 1: Dada una LinkedList<Integer>, escribir un método que elimine los valores duplicados, dejando solo la primera aparición de cada número.
	// Problema 2: Implementar un método que invierta los elementos de una LinkedList<String> sin usar otra lista o ArrayList.
	// Problema 3: Dadas dos listas enlazadas ordenadas de enteros, escribir un método que devuelva una nueva LinkedList<Integer> con los elementos de ambas listas intercalados en orden.
