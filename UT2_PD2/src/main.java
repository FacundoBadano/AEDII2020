/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Facundo Badano
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TArbolTrie arbol = new TArbolTrie();
        arbol.insertar("ala", 1);
        arbol.insertar("ala", 3);
        arbol.insertar("ala", 88);
        arbol.insertar("alimana", 11);
        arbol.insertar("alimana", 22);
        arbol.insertar("alabastro", 4);
        arbol.insertar("perro", 5);
        arbol.insertar("perro", 8);
        arbol.insertar("pera", 7);
        arbol.insertar("pera", 12);
        arbol.insertar("alimento", 9);
        arbol.insertar("casa", 11);
        arbol.insertar("casa", 13);
        arbol.insertar("casada", 1);
        arbol.insertar("cazar", 33);
        arbol.insertar("programa", 22);
        arbol.insertar("programa", 67);
        arbol.insertar("programar", 16);
        arbol.insertar("programar", 15);
        arbol.insertar("programacion", 15);
        
        
        /*
    3. Responde las siguientes preguntas:
        • ¿Cuántas comparaciones realiza el algoritmo de búsqueda si el argumento es “Programa”?
            8
        • ¿Cuántas comparaciones realiza el algoritmo de búsqueda si el argumento es “Proselitismo?
            0
        • ¿Cuántas comparaciones se realizan para insertar la palabra “cazadores”?
            9
        • ¿cuál es la altura del árbol trie resultante?
            14
        • ¿cuál es su tamaño?
            
        */
        System.out.println("Comparaciones en la búsqueda Programa: " + arbol.buscar("programa"));
        System.out.println("Comparaciones en la búsqueda Proselitismo: " + arbol.buscar("proselitismo"));
        System.out.println("Comparaciones en la inserción de Cazadores: " + arbol.insertar("cazadores", 89));
        System.out.println("Altura del arbol: " + arbol.altura(arbol.getRaiz()));
        System.out.println("Tamanio del arbol: " + arbol.tamanio(arbol.getRaiz()));
        
    }
    
    
}
