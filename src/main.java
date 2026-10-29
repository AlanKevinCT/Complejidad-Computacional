package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase principal encargada de la ejecución del programa.
 * Lee el archivo de entrada enviado como argumento desde la terminal,
 * construye la gráfica original para Vertex Cover y ejecuta la reducción a Dominating Set.
 */
public class Main {

    public static void main(String[] args) {
        // Validar que se haya pasado la ruta del archivo de ejemplar como parámetro
        if (args.length < 1) {
            System.out.println("Error: Debe proporcionar la ruta del archivo del ejemplar. \n 
                                Uso: java com.FC.Programa1.src.Main <ruta_del_ejemplar>");
            return;
        }

        String rutaArchivo = args[0];
        Grafica g = new Grafica();
        int k = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            
            // Leer el valor de k
            if ((linea = br.readLine()) != null && !linea.trim().isEmpty()) {
                k = Integer.parseInt(linea.trim());
            }

            // Leer los vértices
            if ((linea = br.readLine()) != null && !linea.trim().isEmpty()) {
                String[] tokensVertices = linea.trim().split("\\s+");
                for (String etiqueta : tokensVertices) {
                    g.agregarVertice(etiqueta, true);
                }
            }

            // Leer las aristas
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                
                String[] ext = linea.split("\\s+");
                if (ext.length >= 2) {
                    g.agregarArista(ext[0], ext[1], true);
                }
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo del ejemplar: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.err.println("Error: El formato de 'k' en el archivo no es un número entero válido.");
            return;
        }

        // Realizar la reducción polinomial (VC -> DS)
        Grafica gPrima = Reduccion.reducir(g, k);
        Reduccion.mostrarReducción(g, gPrima, k);
    }
}