package src;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase que representa un Vértice de una gráfica.
 * Cuenta con una lista de adyacencias (sus vértices vecinos).
 */
public class Vertice {

    private String etiqueta; // identificador único del vértice
    private List<Vertice> vecinos; // lista de adyacencia que contiene los vértices vecinos
    private boolean original; // indica si el vértice es original del problema de cobertura o fue agregado por la reducción

    /**
     * Constructor para crear un nuevo vértice.
     * 
     * @param etiqueta sirve para identificar vértice
     * @param original indica si el vértice es original del problema de cobertura o fue agregado por la reducción.
     */
    public Vertice(String etiqueta, boolean original) {
        this.etiqueta = etiqueta;
        this.original = original;
        this.vecinos = new LinkedList<>();
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public boolean getOriginal(){
        return original;
    }

    public List<Vertice> getVecinos() {
        return vecinos;
    }

    /**
     * Agrega un vecino a la lista de adyacencia de este vértice.
     * Evita duplicados para mantener la estructura de gráfica simple.
     * 
     * @param vecino vértice que se añadirá como vecino.
     */
    public void agregarVecino(Vertice vecino) {
        if (vecino != null && !vecinos.contains(vecino)) {
            vecinos.add(vecino);
        }
    }

    /**
     * Método para representar la etiqueta del vértice como cadena
     * 
     * @return la etiqueta del vértice en formato: (etiqueta)
     */

    @Override
    public String toString() {
        return "(" + etiqueta + ")";
    }
}