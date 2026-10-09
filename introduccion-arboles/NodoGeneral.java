package com.mycompany.actividad1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Nodo general para construir estructuras jerarquicas.
 * Cada nodo almacena un dato y una lista de hijos.
 *
 * @param <T> tipo de dato almacenado en el nodo.
 */
public class NodoGeneral<T> {

    private final T dato;
    private final List<NodoGeneral<T>> hijos;

    public NodoGeneral(T dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo hijo al nodo actual.
     */
    public void agregarHijo(NodoGeneral<T> hijo) {
        if (hijo == null) {
            throw new IllegalArgumentException("El nodo hijo no puede ser null.");
        }
        hijos.add(hijo);
    }

    public T getDato() {
        return dato;
    }

    /**
     * Devuelve una vista de solo lectura de los hijos.
     */
    public List<NodoGeneral<T>> getHijos() {
        return Collections.unmodifiableList(hijos);
    }

    /**
     * Indica si el nodo no tiene hijos.
     */
    public boolean esHoja() {
        return hijos.isEmpty();
    }

    /**
     * Imprime el arbol con sangria segun el nivel (recorrido recursivo).
     */
    public void imprimir(int nivel) {
        System.out.println("   ".repeat(nivel) + "- " + dato);
        for (NodoGeneral<T> hijo : hijos) {
            hijo.imprimir(nivel + 1);
        }
    }
}
