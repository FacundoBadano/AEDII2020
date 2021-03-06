
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Facundo Badano
 */
public class TNodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private ArrayList<Integer> paginas = new ArrayList<Integer>();

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    public int insertar(String unaPalabra, int pagina) {
        TNodoTrie nodo = this;
        int comparaciones=0;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            comparaciones++;
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.paginas.add(pagina);
        return comparaciones;
    }

    public int busqueda(String unaPalabra){
        TNodoTrie nodo = this;
        int comparaciones=0;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return 0;
            } else {
                comparaciones++;
                nodo = nodo.hijos[indice];
            }
        }
        if(nodo.esPalabra){
            return comparaciones;
        } else {
            return 0;
        }
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s + ", " + nodo.paginas.toString());
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }
    
    public void imprimir() {
        imprimir("", this);
    }
    
    public int altura(TNodoTrie nodo){
        int altura = 1;
        if (nodo != null) {
            for (TNodoTrie hijo : nodo.hijos) {
                altura = Math.max(altura, altura(hijo)+1 );
            }
        }
        return altura;
    }
    
    public int tamanio (TNodoTrie nodo){
        int tamanio = 1;
        if (nodo != null){
            for (TNodoTrie aux : nodo.hijos){
                tamanio ++;
            }
        }
        return tamanio;
    }
 
       
    
}
