package com.FC.Programa1.src;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase que representa una Gráfica no dirigida mediante listas de adyacencia.
 * Se encarga de construir la gráfica, agregar vértices y aristas.
 */
public class Grafica {

    private List<Vertice> vertices; // lista de vértices que componen la gráfica
    private List<Arista> aristas; // lista de aristas que componen la gráfica

    /**
     * Constructor para inicializar una gráfica.
     */
    public Grafica() {
        this.vertices = new LinkedList<>();
        this.aristas = new LinkedList<>();
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    /**
     * Busca un vértice en la gráfica a partir de su etiqueta.
     * 
     * @param etiqueta Identificador del vértice.
     * @return El Vertice si se encuentra, null en caso contrario.
     */
    public Vertice buscarVertice(String etiqueta) {
        for (Vertice v : vertices) {
            if (v.getEtiqueta().equals(etiqueta)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Agrega un vértice a la gráfica si no existe previamente.
     * 
     * @param etiqueta Identificador del vértice.
     * @param original Indica si es un vértice original o agregado por reducción.
     * @return El vértice recién creado o el vértice existente.
     */
    public Vertice agregarVertice(String etiqueta, boolean original) {
        Vertice existente = buscarVertice(etiqueta);
        if (existente == null) {
            Vertice nuevo = new Vertice(etiqueta, original);
            vertices.add(nuevo);
            return nuevo;
        }
        return existente;
    }

    /**
     * Agrega una arista no dirigida entre dos vértices representados por sus etiquetas.
     * 
     * @param uEtiqueta Etiqueta del primer vértice.
     * @param vEtiqueta Etiqueta del segundo vértice.
     * @param esOriginal Indica si la arista es original o agregada.
     */
    public void agregarArista(String uEtiqueta, String vEtiqueta, boolean esOriginal) {
        Vertice u = buscarVertice(uEtiqueta);
        Vertice v = buscarVertice(vEtiqueta);

        if (u == null || v == null) {
            System.out.println("Error: Uno o ambos vértices no existen en la gráfica. Asegúrese de agregarlos antes de crear la arista.");
            return;
        }
        if(v.getVecinos().contains(u) || u.getVecinos().contains(v)){
            System.out.println("Error: La arista entre " + uEtiqueta + " y " + vEtiqueta + " ya existe.");
            return;
        }

        u.agregarVecino(v);
        v.agregarVecino(u);
        aristas.add(new Arista(u, v, esOriginal));
    }

    /**
     * Muestra la estructura de la gráfica con sus listas de adyacencia.
     */
    public void mostrarGrafica() {
        for (Vertice v : vertices) {
            System.out.print(v.getEtiqueta() + " (Original: " + v.getOriginal() + ") -> ");
            for (Vertice vecino : v.getVecinos()) {
                System.out.print(vecino.getEtiqueta() + " ");
            }
            System.out.println();
        }
    }
}