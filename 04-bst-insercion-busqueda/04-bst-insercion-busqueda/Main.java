/**
 * Reto "Catálogo inteligente" - Guía 4: BST I (inserción y búsqueda).
 *
 * Construye dos BST con 15 códigos de producto:
 *   1) insertados en orden ALEATORIO  -> árbol razonablemente balanceado
 *   2) insertados en orden ORDENADO   -> árbol degenerado (forma de lista)
 * y compara altura y número de comparaciones en cinco búsquedas cada uno.
 */
public class Main {

    public static void main(String[] args) {

        // --- Ejercicio 1 de la guía: 50,30,70,20,40,60,80 ---------------
        ArbolBST ejemplo = new ArbolBST();
        for (int v : new int[]{50, 30, 70, 20, 40, 60, 80}) ejemplo.insertar(v);

        System.out.println("=== EJERCICIO DE LA GUIA (50,30,70,20,40,60,80) ===");
        System.out.println("Altura: " + ejemplo.altura());
        mostrarBusqueda(ejemplo, 60);   // existente
        mostrarBusqueda(ejemplo, 65);   // inexistente
        System.out.println();

        // --- Reto: 15 códigos de producto -------------------------------
        int[] aleatorio = {420, 150, 780, 90, 310, 600, 920, 230,
                           480, 700, 55, 370, 850, 180, 640};
        int[] ordenado  = {10, 20, 30, 40, 50, 60, 70, 80,
                           90, 100, 110, 120, 130, 140, 150};

        // Cinco búsquedas por caso (incluye una inexistente)
        int[] busquedasAleatorio = {370, 640, 55, 920, 999};
        int[] busquedasOrdenado  = {10, 80, 150, 140, 155};

        probar("ALEATORIO", aleatorio, busquedasAleatorio);
        probar("ORDENADO", ordenado, busquedasOrdenado);
    }

    /**
     * Inserta los datos, muestra la altura y ejecuta las búsquedas
     * calculando el promedio de comparaciones.
     */
    static void probar(String titulo, int[] datos, int[] busquedas) {
        ArbolBST arbol = new ArbolBST();
        for (int d : datos) arbol.insertar(d);

        System.out.println("=== " + titulo + " === Altura: " + arbol.altura());

        int total = 0;
        for (int b : busquedas) {
            mostrarBusqueda(arbol, b);
            total += arbol.getComparaciones();
        }
        System.out.println("Promedio de comparaciones: "
                + (double) total / busquedas.length + "\n");
    }

    /** Busca un valor e imprime resultado, comparaciones y camino. */
    static void mostrarBusqueda(ArbolBST arbol, int valor) {
        boolean ok = arbol.buscar(valor);
        System.out.println("Buscar " + valor + ": "
                + (ok ? "Encontrado" : "No encontrado")
                + " | Comparaciones: " + arbol.getComparaciones()
                + " | Camino: " + arbol.getCamino());
    }
}
