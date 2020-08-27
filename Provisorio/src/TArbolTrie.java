/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Facundo Badano
 */
public class TArbolTrie {

    private TNodoTrie raiz;

    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    4
// COMPLETAR EL MÉTODO DE BUSCAR, COMO INDICA LA LETRA DEL EJERCICIO.
public static void main(String[] args) {
// Crear una instancia de un arbol Trie.
// Leer un archivo palabras.txt
// Para cada palabra encontrada, insertarla en el Trie
// Por último, imprimir el trie.
// Ejemplo de uso del Trie.
        TArbolTrie trie = new TArbolTrie();
        trie.insertar("casa");
        trie.insertar("casamiento");
        trie.insertar("caño");
        trie.insertar("arbol");
        trie.insertar("grito");
        trie.imprimir();
        System.out.println(trie.buscar("casamientos"));
    }
}
