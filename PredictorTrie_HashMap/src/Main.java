
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TTrieHashMap trie = new TTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        trie.imprimir();  
        
        //System.out.println(trie.buscar("po"));
        
        LinkedList<String> resultado = trie.predecir("09");
        
        System.out.println("------------------------------");
        
        for (String s : resultado) {
            System.out.println(s);
            
        }
        
        //System.out.println(resultado.getFirst());
        
        
        
    }
}