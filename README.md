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

Para compilar el proyecto desde la raíz del mismo, ejecuta:

```bash
javac com/FC/Programa1/src/*.java
```


## Ejecución
Para probar el ejemplar con respuesta SI:
```bash
java com.FC.Programa1.src.Main ejemplares/ejemplar_si.txt
```

Para probar el ejemplar con respuesta NO:
```bash
java com.FC.Programa1.src.Main ejemplares/ejemplar_no.txt
```