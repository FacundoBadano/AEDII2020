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
    
    public String buscar(String n){
        
        return "FALTA HACER";
    }
}
