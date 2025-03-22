package umg.edu.gt.test.EjercicioLinkedList;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkedList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;

class TestEjerciciosLinkedList {

  
    @Test
    void testEliminarDuplicados() {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(2);
        lista.add(4);
        lista.add(1);
        
        LinkedList<Integer> resultadoEsperado = new LinkedList<>();
        resultadoEsperado.add(1);
        resultadoEsperado.add(2);
        resultadoEsperado.add(3);
        resultadoEsperado.add(4);
        
        assertEquals(resultadoEsperado, EjercicioLinkedList.eliminarDuplicados(lista));
    }

    
    @Test
    void testEliminarDuplicadosFalla() {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(2);
        lista.add(4);
        lista.add(1);
        
        LinkedList<Integer> resultadoEsperado = new LinkedList<>();
        resultadoEsperado.add(1);
        resultadoEsperado.add(2);
        resultadoEsperado.add(3);
        
        assertEquals(resultadoEsperado, EjercicioLinkedList.eliminarDuplicados(lista));
    }

   
    @Test
    void testInvertirLista() {
        LinkedList<String> lista = new LinkedList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("D");
        
        LinkedList<String> resultadoEsperado = new LinkedList<>();
        resultadoEsperado.add("D");
        resultadoEsperado.add("C");
        resultadoEsperado.add("B");
        resultadoEsperado.add("A");
        
        assertEquals(resultadoEsperado, EjercicioLinkedList.invertirLista(lista));
    }

       @Test
    void testIntercalarListas() {
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);
        
        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);
        
        LinkedList<Integer> resultadoEsperado = new LinkedList<>();
        resultadoEsperado.add(1);
        resultadoEsperado.add(2);
        resultadoEsperado.add(3);
        resultadoEsperado.add(4);
        resultadoEsperado.add(5);
        resultadoEsperado.add(6);
        
        assertEquals(resultadoEsperado, EjercicioLinkedList.intercalarListas(lista1, lista2));
    }

  
    @Test
    void testIntercalarListasFalla() {
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);
        
        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);
        
        LinkedList<Integer> resultadoEsperado = new LinkedList<>();
        resultadoEsperado.add(1);
        resultadoEsperado.add(2);
        resultadoEsperado.add(3);
        resultadoEsperado.add(4);
        resultadoEsperado.add(5);
        
        assertEquals(resultadoEsperado, EjercicioLinkedList.intercalarListas(lista1, lista2));
    }

}
