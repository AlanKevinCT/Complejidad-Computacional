package com.FC.Programa1.src;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase que representa un Vértice de una gráfica.
 * Cuenta con una lista de adyacencias (sus vértices vecinos).
 */
public class Vertice {

    private String etiqueta;
    private List<Vertice> vecinos;
    private boolean original;

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

    /**
     * Obtiene la etiqueta que identifica al vértice.
     * 
     * @return La etiqueta del vértice.
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Dice si el vértice es original del problema de cobertura o fue agregado por la reducción.
     * 
     * @return true si ya estaba antes de la reducción, false en caso contrario.
     */
    public boolean getOriginal(){
        return original;
    }

    /**
     * Obtiene los vecinos adyacentes a este vertice.
     * 
     * @return Lista de vértices adyacentes.
     */
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