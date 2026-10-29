package src;

/**
 * Clase Arista que representa una Arista entre dos vértices.
 * Ayuda a clasificar y listar las aristas originales y las agregadas.
 */
class Arista {

    private Vertice origen; // Vértice de origen de la arista
    private Vertice destino; // Vértice de destino de la arista
    private boolean original; // Indica si la arista es original o agregada por reducción

    /**
     * Constructor para crear una Arista
     * 
     * @param origen Vértice de origen
     * @param destino Vértice de destino
     * @param original Indica si la arista es original o agregada
     */
    public Arista(Vertice origen, Vertice destino, boolean original) {
        this.origen = origen;
        this.destino = destino;
        this.original = original;
    }

    public Vertice getOrigen() {
        return origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public boolean esOriginal() {
        return original;
    }

    /**
     * Método toString para representar la arista en formato legible.
     * 
     * @return Cadena que representa la arista.
     */
    @Override
    public String toString() {
        return "(" + origen.getEtiqueta() + ", " + destino.getEtiqueta() + ")";
    }
}