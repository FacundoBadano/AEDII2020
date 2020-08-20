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

    public Integer insertar(String palabra, int pagina) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        return raiz.insertar(palabra, pagina);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    public TNodoTrie getRaiz(){
        return raiz;
    }
    
    public Integer buscar(String palabra){
        return raiz.busqueda(palabra);
    }
    
    public Integer altura(TNodoTrie nodo){
        if (raiz == null){
            return 0;
        }else{
            return raiz.altura(nodo);
        }
    }
    
    public Integer tamanio (TNodoTrie nodo){
        if(raiz == null){
            return 0;
        }else{
            return raiz.tamanio(nodo);
        }
    }
}
