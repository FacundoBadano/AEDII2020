

import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    public void indizarLibro(String[] libro) {
        int nLinea = 0;
        int nPagina = 1;
        for(String linea : libro){
            if (nLinea == 50){
                nPagina++;
                nLinea = 0;
            }
            String[] palabras = linea.split(" ");
            for(String palabra : palabras){
                TNodoTrie nodo = this.buscarNodoTrie(palabra);
                if(nodo != null){
                    nodo.añadirPag(nPagina);
                }
            }
            nLinea++;
        }
    }

    public void imprimirIndice(){
        if (raiz != null) {
            raiz.imprimirIndice("",raiz);
        }
    }

    public TNodoTrie buscarNodoTrie(String s) {
        if (raiz == null) {
            return null;
        }
        return raiz.buscarNodoTrie(s);
    }

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public TNodoTrie buscar(String palabra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<>();
        if (raiz!=null) {
            raiz.predecir(prefijo, palabras);
        }
        
        return palabras;
        
    }
    
    
}
