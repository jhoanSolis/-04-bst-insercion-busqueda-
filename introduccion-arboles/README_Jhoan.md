# Guía 1 – De lo lineal a lo jerárquico

**Asignatura:** Estructura de Datos II – Ingeniería de Software, IV semestre

**Autor:** Jhoan Alveiro Solís Vargas

## Contenido de la carpeta

- `Actividad1.java`: clase principal que construye la jerarquía y la imprime en consola.
- `NodoGeneral.java`: clase genérica que almacena un dato y una lista de hijos.
- `diagrama.pdf`: árbol del organigrama modelado en Draw.io.

## Clasificación de los cuatro escenarios

| Escenario | Clasificación | Justificación |
|---|---|---|
| Sistema de archivos | Jerárquico | Las carpetas contienen archivos y otras carpetas; parte de una raíz y cada elemento tiene un único padre. |
| Organigrama empresarial | Jerárquico | Cada cargo tiene varios subordinados, que a su vez tienen otros; la gerencia general es la raíz. |
| Menú de una aplicación | Jerárquico | El menú principal se divide en submenús y estos en opciones; cada opción pertenece a un solo menú. |
| Árbol genealógico | Jerárquico (mixto si se incluyen las parejas) | Un padre puede tener varios hijos. Si se agregan los dos padres de cada persona, deja de ser un árbol estricto. |

Una estructura lineal solo sirve para recorrer elementos uno tras otro, por ejemplo, los archivos de una misma carpeta.

## Jerarquía implementada (organigrama)

```
- Empresa
   - Tecnologia
      - Desarrollo
         - Backend
         - Frontend
      - Infraestructura
   - Finanzas
      - Contabilidad
      - Tesoreria
   - Recursos Humanos
      - Seleccion
      - Bienestar
```

12 nodos distribuidos en 4 niveles (0 a 3).

## Ejercicios

**Dos ventajas de usar un árbol en lugar de una lista**

1. Permite expresar que un elemento tiene varios descendientes, algo que en una lista no es posible porque cada elemento solo tiene un siguiente.
2. Hace visible el nivel de cada elemento y permite recorrer o consultar una rama completa sin pasar por todos los datos.

**¿Qué pasaría si un nodo pudiera tener más de un padre?**
La estructura dejaría de ser un árbol y pasaría a ser un grafo. Habría varios caminos hacia un mismo nodo, podrían formarse ciclos y los recorridos recursivos tendrían que registrar los nodos visitados para no repetirlos.

## Cómo ejecutar

Abrir el proyecto en NetBeans y ejecutar `Actividad1.java` (clic derecho → Run File, o Shift + F6).

## Reflexión

Un árbol permite representar relaciones en las que un elemento tiene varios descendientes, algo que una lista no expresa con claridad porque cada posición solo conecta con la siguiente. En un organigrama, un menú o un sistema de archivos importa saber quién depende de quién y en qué nivel está cada elemento, y la jerarquía lo muestra directamente.

Para implementarlo en Java usé una clase genérica NodoGeneral que guarda un dato y una lista de hijos. Con esa idea simple se puede construir cualquier jerarquía y recorrerla de forma recursiva, como hace el método imprimir, que muestra cada nodo con sangría según su nivel.

También concluí que la regla de un solo padre por nodo es lo que define al árbol. Si un nodo pudiera tener varios padres, habría varios caminos hacia él y la estructura pasaría a ser un grafo, donde hay que evitar recorrer dos veces el mismo nodo. Por eso elegir la estructura correcta depende de cómo se relacionan los datos.
