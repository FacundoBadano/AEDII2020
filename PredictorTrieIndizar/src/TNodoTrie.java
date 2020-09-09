import java.util.LinkedList;
import java.util.Iterator;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        paginas = new LinkedList<Integer>();
        esPalabra = false;
    }

    public boolean getEsPalabra(){
        return paginas.size() == 0;
    }

    public void añadirPag(int n){
        if(!(paginas.contains(n)))
        this.paginas.add(n);
    }

    public String paginasAString(){
        String result = "";
        if(paginas.isEmpty())
        return result;
        for (Iterator i = paginas.iterator(); i.hasNext();) {
            result += i.next() + " ";
        }
        return result.trim();
    }

    public void imprimirIndice(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s + " " + nodo.paginasAString());
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimirIndice(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }


    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }
    
    @Override
    public void imprimir() {
        imprimir("", this);
    }
    
    public TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }
      
    public void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s+(char)(c + 'a'), prefijo, palabras, nodo.hijos[c]);
                }
            }
        }
       
    }
    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodoPrefijo = buscarNodoTrie(prefijo);
        if (nodoPrefijo!=null) {
            nodoPrefijo.predecir(prefijo, prefijo, palabras, nodoPrefijo);
            
        }
        
        
    }

    @Override
    public int buscar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
