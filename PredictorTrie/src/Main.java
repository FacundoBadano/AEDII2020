
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        trie.imprimir();  
        LinkedList<String> resultado = trie.predecir("art");
        
        System.out.println("------------------------------");
        
        for (String s : resultado) {
            System.out.println(s);
            
        }
        
        //System.out.println(resultado.getFirst());
        
        
        
    }
}