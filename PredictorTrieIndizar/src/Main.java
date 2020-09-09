
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();


        // String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/palabras1.txt");
        // for (String p : palabrasclave) {
        //         trie.insertar(p);
        // }
        // trie.imprimir();  
        // LinkedList<String> resultado = trie.predecir("art");
        
        // System.out.println("------------------------------");
        
        // for (String s : resultado) {
        //     System.out.println(s);
            
        // }
        
        //---------------------------------------------------------------------------------------------

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/PalabrasIndice.txt");
        for (String p : palabrasclave) {
            trie.insertar(p);
        }
        String[] lineasLibro = ManejadorArchivosGenerico.leerArchivo("./src/libro.txt");
        String[] lineasProcesadas = new String[lineasLibro.length];
        for(int i=0; i<lineasLibro.length; i++){
            lineasProcesadas[i] = lineasLibro[i].replaceAll("[^a-zA-Z ]", "").toLowerCase();
        }
        trie.indizarLibro(lineasProcesadas);
        trie.imprimirIndice();


        float f1 = 94f;  
        Float.hashCode(f1);
        
    }
}