# Programa 1: Reducción de Vertex Cover a Dominating Set

## Descripción
Este programa realiza la reducción polinomial del problema de **Cubierta de Vértices** (*Vertex Cover*) al problema de **Conjunto Dominante** (*Dominating Set*) en tiempo $O(|V| + |E|)$.

## Estructura del Programa 1
.
├── ejemplares/
│   ├── ejemplar_si.txt
│   └── ejemplar_no.txt
├── src/
│   ├── Arista.java
│   ├── Grafica.java
│   ├── Main.java
│   ├── Reduccion.java
│   └── Vertice.java
└── README.md

## Compilación

Para compilar el programa desde la raíz, ejecuta:

```bash
javac src/*.java
```

## Ejecución
Para probar desde la raíz, el ejemplar con respuesta SI:
```bash
java src.Main ejemplares/ejemplar_si.txt
```

Para probar el ejemplar con respuesta NO:
```bash
java src.Main ejemplares/ejemplar_no.txt
```