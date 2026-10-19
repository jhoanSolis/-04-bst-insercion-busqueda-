/**
 * Árbol Binario de Búsqueda (BST) de enteros.
 *
 * Propiedad BST (convención adoptada):
 *   - Los valores MENORES al del nodo van en el subárbol izquierdo.
 *   - Los valores MAYORES O IGUALES van en el subárbol derecho.
 *
 * Gracias a esta propiedad, insertar y buscar siguen un ÚNICO camino
 * desde la raíz, por lo que el costo depende de la altura del árbol:
 *   - Árbol razonablemente balanceado: O(log n)
 *   - Árbol degenerado (datos ordenados): O(n)
 *
 * Además de insertar y buscar, esta clase cuenta las comparaciones y
 * registra el camino recorrido para poder analizar la eficiencia.
 */
public class ArbolBST {

    /** Raíz del árbol (null si está vacío). */
    private NodoArbol<Integer> raiz;

    /** Nodos visitados en la ÚLTIMA búsqueda realizada. */
    private int comparaciones;

    /** Camino recorrido en la ÚLTIMA búsqueda (ej: "50 -> 70 -> 60"). */
    private StringBuilder camino;

    // ------------------------------------------------------------------
    // INSERCIÓN
    // ------------------------------------------------------------------

    /**
     * Inserta un valor en el árbol manteniendo la propiedad BST.
     *
     * @param valor código (entero) a insertar
     */
    public void insertar(int valor) {
        // Se reasigna la raíz porque, si el árbol está vacío, cambia.
        raiz = insertarRec(raiz, valor);
    }

    /**
     * Inserción recursiva.
     * Caso base: si se llega a una posición vacía (null), se crea el nodo ahí.
     * Caso recursivo: se desciende a la izquierda o a la derecha según el valor.
     *
     * @param nodo  nodo actual de la recursión
     * @param valor valor a insertar
     * @return la raíz del subárbol ya actualizada
     */
    private NodoArbol<Integer> insertarRec(NodoArbol<Integer> nodo, int valor) {
        if (nodo == null) return new NodoArbol<>(valor);   // caso base

        if (valor < nodo.getDato()) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), valor));
        } else {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), valor));
        }
        return nodo;
    }

    // ------------------------------------------------------------------
    // BÚSQUEDA
    // ------------------------------------------------------------------

    /**
     * Busca un valor en el árbol. Antes de buscar reinicia el contador de
     * comparaciones y el camino, para medir solo esta búsqueda.
     *
     * @param valor código a buscar
     * @return true si existe, false si no
     */
    public boolean buscar(int valor) {
        comparaciones = 0;
        camino = new StringBuilder();
        return buscarRec(raiz, valor);
    }

    /**
     * Búsqueda recursiva.
     * Casos base: nodo null (no encontrado) o dato igual (encontrado).
     * Caso recursivo: ir a la izquierda si es menor, a la derecha si es mayor.
     *
     * @param nodo  nodo actual
     * @param valor valor buscado
     * @return true si se encontró
     */
    private boolean buscarRec(NodoArbol<Integer> nodo, int valor) {
        if (nodo == null) {                 // llegamos al final sin encontrarlo
            camino.append("null");
            return false;
        }

        comparaciones++;                    // visitamos un nodo más
        camino.append(nodo.getDato()).append(" -> ");

        if (valor == nodo.getDato()) return true;   // encontrado

        return valor < nodo.getDato()
                ? buscarRec(nodo.getIzquierdo(), valor)
                : buscarRec(nodo.getDerecho(), valor);
    }

    // ------------------------------------------------------------------
    // ANÁLISIS DE EFICIENCIA
    // ------------------------------------------------------------------

    /**
     * Calcula la altura del árbol como número de NIVELES
     * (un árbol vacío tiene altura 0; solo la raíz, altura 1).
     *
     * @return altura del árbol
     */
    public int altura() {
        return alturaRec(raiz);
    }

    /**
     * Altura recursiva: 1 + la mayor altura entre los dos subárboles.
     */
    private int alturaRec(NodoArbol<Integer> nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(alturaRec(nodo.getIzquierdo()),
                            alturaRec(nodo.getDerecho()));
    }

    /** @return nodos visitados en la última búsqueda */
    public int getComparaciones() { return comparaciones; }

    /** @return camino recorrido en la última búsqueda */
    public String getCamino() { return camino.toString(); }
}
