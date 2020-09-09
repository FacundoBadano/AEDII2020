

import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHashMap implements INodoTrie {
    private HashMap hijos;
    private boolean esPalabra;

    public TNodoTrieHashMap() {
        hijos = new HashMap();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodo = this;

        for (int c = 0; c < unaPalabra.length(); c++) {
            char caracter = unaPalabra.charAt(c);
            if (!nodo.hijos.containsKey(caracter)) {
                TNodoTrieHashMap nodoHijo = new TNodoTrieHashMap();
                nodo.hijos.put(caracter, nodoHijo);
            }
            nodo = (TNodoTrieHashMap) nodo.hijos.get(caracter);
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);                
            }   
            nodo.hijos.forEach((k,v) -> imprimir(s + k.toString(), (TNodoTrieHashMap) v ) );
        }
    }
    
    @Override
    public void imprimir() {
        imprimir("", this);
    }
    
    private void insertarOrdenado (String unaPalabra, LinkedList<String> listaPalabras) {
        boolean insertado = false;
        for (String palabra : listaPalabras) {
            if (unaPalabra.compareTo(palabra) < 0) {
                listaPalabras.add(listaPalabras.indexOf(palabra), unaPalabra);
                insertado = true;
                break;
            }
        }

        if (!insertado) listaPalabras.add(unaPalabra);
   
    }
      
    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                insertarOrdenado(s, palabras);
                //palabras.add(s);       
            }
            nodo.hijos.forEach((k,v) -> predecir(s+k, prefijo, palabras, (TNodoTrieHashMap) v) );
        } 
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap nodoPrefijo = buscarNodo(prefijo);
        if (nodoPrefijo!=null) {
            nodoPrefijo.predecir(prefijo, prefijo, palabras, nodoPrefijo);
        }
    }

    @Override
    public int buscar(String s) {
        TNodoTrieHashMap nodo = this;        
        for (int i = 0; i < s.length(); i++) {
            char caracter = s.charAt(i);
            if (nodo.hijos.containsKey(caracter)) {
                nodo = (TNodoTrieHashMap) nodo.hijos.get(caracter);
            } else { return 0; }
        }                           
        if (nodo.esPalabra) { return 1; } else return 0; 
    }
    
    private TNodoTrieHashMap buscarNodo (String unaPalabra) {
        TNodoTrieHashMap nodo = this;
        for (int i = 0; i < unaPalabra.length(); i++) {
            char caracter= unaPalabra.charAt(i);
            if (nodo.hijos.containsKey(caracter)) {
                nodo = (TNodoTrieHashMap) nodo.hijos.get(caracter);
            } else return null;             
        }        
        return nodo;
    } 
    
}
