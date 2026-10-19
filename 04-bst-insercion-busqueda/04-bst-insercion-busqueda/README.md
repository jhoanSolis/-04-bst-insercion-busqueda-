# Guía 4. BST I: inserción y búsqueda

**Asignatura:** Estructura de Datos II – Ingeniería de Software / Sistemas – Semestre IV
**Ecosistema:** Java / GitHub

## Objetivo
Implementar inserción y búsqueda recursiva en un Árbol Binario de Búsqueda (BST)
y analizar su eficiencia comparando datos aleatorios frente a datos ordenados
(reto "Catálogo inteligente").

## Estructura de la carpeta
```
04-bst-insercion-busqueda/
├── NodoArbol.java        # Nodo genérico del árbol
├── ArbolBST.java         # BST: insertar, buscar, altura (recursivos)
├── Main.java             # Pruebas y comparación aleatorio vs ordenado
├── diagramas/
│   ├── 00-ejercicio-guia.mmd
│   ├── 01-insercion-aleatoria.mmd
│   └── 02-insercion-ordenada.mmd
└── README.md
```

## Cómo ejecutar
```bash
javac *.java
java Main
```

## Propiedad BST
Menores a la izquierda; mayores o iguales a la derecha (convención adoptada).
Esto permite buscar e insertar siguiendo un único camino desde la raíz.

## Ejercicio de la guía
Inserción: `50, 30, 70, 20, 40, 60, 80` (altura 3).

| Búsqueda | Resultado | Camino |
|---|---|---|
| 60 | Encontrado | 50 → 70 → 60 |
| 65 | No encontrado | 50 → 70 → 60 → null |

## Reto "Catálogo inteligente": 15 códigos de producto

- **Aleatorio:** 420, 150, 780, 90, 310, 600, 920, 230, 480, 700, 55, 370, 850, 180, 640
- **Ordenado:** 10, 20, 30, …, 150

Diagramas: `diagramas/01-insercion-aleatoria.mmd` y `diagramas/02-insercion-ordenada.mmd`
(agrega aquí las imágenes PNG exportadas de Draw.io).

### Tabla comparativa de altura y comparaciones

| Caso | Altura | Comparaciones (5 búsquedas) | Promedio | Complejidad |
|---|---|---|---|---|
| Aleatorio | 5 | 370→4, 640→5, 55→4, 920→3, 999→3 | 3,8 | ≈ O(log n) |
| Ordenado | 15 | 10→1, 80→8, 150→15, 140→14, 155→15 | 10,6 | ≈ O(n) |

*Las comparaciones cuentan los nodos visitados; la altura cuenta niveles.*

## Análisis O(log n) frente a O(n)
- **Datos aleatorios:** el árbol queda razonablemente balanceado (altura 5 para
  15 nodos). En cada paso se descarta un subárbol completo, por lo que el costo
  crece de forma logarítmica: ≈ O(log n).
- **Datos ordenados:** cada valor nuevo es mayor que todos los anteriores y siempre
  va a la derecha. El árbol se degenera en una lista (altura 15) y la búsqueda
  puede recorrer casi todos los nodos: ≈ O(n).
- **Conclusión:** la forma del árbol depende del orden de inserción. Si los datos
  llegan ordenados, el BST pierde su ventaja; por eso existen árboles
  autobalanceados (como el AVL).

## Por qué insertar datos ordenados degrada el rendimiento
Al insertar valores crecientes, cada uno se compara con todos los anteriores y termina
como hijo derecho del último nodo. No se crean ramas izquierdas, así que el árbol se
comporta como una lista enlazada y la altura es igual a n.
