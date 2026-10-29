package com.FC.Programa1.src;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase encargada de ejecutar la reducción polinomial de Vertex Cover a Dominating Set.
 * Construye la gráfica reducida G' aplicando la regla del gadget del triángulo para cada arista.
 */
public class Reduccion {

    /**
     * Aplica la reducción  clonando los vértices originales y agregando un nuevo vértice para cada arista de la gráfica original.
     * Agrega una arista entre cada vértice original y el nuevo vértice asociado a la arista.
     * Conserva las aristas originales en la gráfica reducida.
     * 
     * @param g Gráfica G correspondiente a Cubierta de Vértices (Vertex Cover).
     * @param k Límite k del ejemplar original.
     * @return Grafica G' para  Conjunto Dominante (Dominating Set).
     */
    public static Grafica reducir(Grafica g, int k) {
        Grafica gPrima = new Grafica();

        // Copiamos los vertices originales a G'
        for (Vertice v : g.getVertices()) {
            gPrima.agregarVertice(v.getEtiqueta(), true);
        }

        List<Arista> aristasOriginales = new LinkedList<>(g.getAristas());

        // Obtenemos las aristas originales y aplicamos la regla del gadget del triángulo para cada arista
        for (Arista arista : aristasOriginales) {
            String vEtiqueta = arista.getOrigen().getEtiqueta();
            String wEtiqueta = arista.getDestino().getEtiqueta();

            gPrima.agregarArista(vEtiqueta, wEtiqueta, true); // arista original

            String etiquetaNuevoVertice = vEtiqueta + wEtiqueta; // v,w -> vw

            // Crear el nuevo vértice asociado a la arista
            gPrima.agregarVertice(etiquetaNuevoVertice, false);

            // Agregar las dos nuevas aristas para conectar el vértice vw a sus extremos
            gPrima.agregarArista(vEtiqueta, etiquetaNuevoVertice, false);
            gPrima.agregarArista(wEtiqueta, etiquetaNuevoVertice, false);
        }

        return gPrima;
    }

    /**
     * Imprime en consola la gráfica original G y la gráfica reducida G' con el valor k.
     * 
     * @param g Gráfica original G.
     * @param gPrima Gráfica reducida G'.
     * @param k Parámetro k conservado.
     */
    public static void imprimirResultado(Grafica g, Grafica gPrima, int k) {
        System.out.println("1. EJEMPLAR ORIGINAL: VERTEX COVER");
        System.out.println("Valor de k = " + k);
        g.mostrarDetallesCompleto();

        System.out.println("\n2. EJEMPLAR RESULTANTE: DOMINATING SET (G')");
        System.out.println("Valor de k = " + k);
        gPrima.mostrarDetallesCompleto();
    }
}