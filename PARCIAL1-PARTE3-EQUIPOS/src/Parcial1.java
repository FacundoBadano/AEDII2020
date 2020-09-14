
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class Parcial1 {

    public static void main(String[] args) {
        
        Map <Integer, Producto> elAlmacen = new HashMap<>();  
        Map <Integer, TreeSet<String>> lasPalabras = new HashMap<>();
        
        String[] todasPalabras = ManejadorArchivosGenerico.leerArchivo("src\\palabras.txt");
        for (String palabra : todasPalabras) {
            
            TreeSet<String> palabraInsertar = lasPalabras.get(palabra.length());
            if (palabraInsertar==null) {
                palabraInsertar = new TreeSet<>();     
                lasPalabras.put(palabra.length(), palabraInsertar);
            }             
            palabraInsertar.add(palabra.toLowerCase());            
        }
        
        TreeSet lasPlabrasSeis = lasPalabras.get(6);
        String[] guardarP = new String[lasPlabrasSeis.size()];
        int indiceP = 0;
        for (Object palabra :  lasPlabrasSeis) {
            guardarP[indiceP] = palabra.toString();
            System.out.println(palabra);
            indiceP++;
        }
        
        ManejadorArchivosGenerico.escribirArchivo("src\\listadoP.txt", guardarP);
        
             /*
        
        Seleccionar una estructura de datos apropiada para satisfacer las 
        funcionalidades requeridas, y cargarla con los datos provistos
        
        
        
        (archivo “productosCompras.txt”). 
        SE DEBERÁN UTILIZAR PARA ESTO LAS CLASES E INTERFASES DISPONIBLES EN LA API DE COLECCIONES DE JAVA.  
        */
        
        /* Dados los  códigos de producto indicados en el 
        pizarrón imprimir por consola las existencias en el stock 
        y ESCRIBIR ESTE VALOR EN EL ARCHIVO “RESPUESTAS.DOCX”)
        */
        String[] todosProductos = ManejadorArchivosGenerico.leerArchivo("src\\productosCompras.txt");
        for (String producto : todosProductos) {
            String[] datosProducto = producto.split(",");
            int codigo = Integer.parseInt(datosProducto[0]);
            int stock = Integer.parseInt(datosProducto[1]);
            Producto prodInsertar = new Producto(codigo, stock);
            Producto prodBuscado = elAlmacen.get(codigo);
            if (prodBuscado==null) {
                elAlmacen.put(codigo, prodInsertar);
            } else {
                prodBuscado.setStock(prodBuscado.getStock() + stock);
            }

        }
        
        
        
        int codProducto1 = 1473;// indicado en el pizarron
        Producto producto1 = elAlmacen.get(codProducto1);
        if (producto1!=null) {
            System.out.println(producto1.getStock());
        } else {System.out.println("0");}
            
// buscar en el almacen
 //     mostrar por consola el valor del stock
        
 // repetir para todso los codigos de producto indicados
        int codProducto2 = 1306;// indicado en el pizarron
        Producto producto2 = elAlmacen.get(codProducto2);
        if (producto2!=null) {
            System.out.println(producto2.getStock());
        } else {System.out.println("0");}
            
        
        int codProducto3 = 1111;// indicado en el pizarron
        Producto producto3 = elAlmacen.get(codProducto3);
        if (producto3!=null) {
            System.out.println(producto3.getStock());
        } else {System.out.println("0");}
            
            
        
 
 /*Emitir un archivo “listado.txt” con el listado de stock requerido,  
 ordenado por código de producto en forma ascendente, con el formato: 
CODPRODUCTO, CANTIDAD (en cada línea)
*/ 
        
        TreeMap<Integer, Producto> elListado = new TreeMap<>(elAlmacen);
        
        String[] guardar = new String[elListado.size()];
        int indice = 0;
        for (Producto producto : elListado.values()) {
            guardar[indice] = producto.getCodigo() + "," + producto.getStock();
            indice++;
        }

        ManejadorArchivosGenerico.escribirArchivo("src\\listado.txt", guardar);
  
// EMITIR EL ARCHIVO 
    
    }

}
