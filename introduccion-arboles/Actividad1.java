package com.mycompany.actividad1;

public class Actividad1 {

    public static void main(String[] args) {
        // Nivel 0: raiz
        NodoGeneral<String> raiz = new NodoGeneral<>("Empresa");

        // Nivel 1: areas
        NodoGeneral<String> tecnologia = new NodoGeneral<>("Tecnologia");
        NodoGeneral<String> finanzas = new NodoGeneral<>("Finanzas");
        NodoGeneral<String> recursosHumanos = new NodoGeneral<>("Recursos Humanos");
        raiz.agregarHijo(tecnologia);
        raiz.agregarHijo(finanzas);
        raiz.agregarHijo(recursosHumanos);

        // Nivel 2: equipos
        NodoGeneral<String> desarrollo = new NodoGeneral<>("Desarrollo");
        tecnologia.agregarHijo(desarrollo);
        tecnologia.agregarHijo(new NodoGeneral<>("Infraestructura"));
        finanzas.agregarHijo(new NodoGeneral<>("Contabilidad"));
        finanzas.agregarHijo(new NodoGeneral<>("Tesoreria"));
        recursosHumanos.agregarHijo(new NodoGeneral<>("Seleccion"));
        recursosHumanos.agregarHijo(new NodoGeneral<>("Bienestar"));

        // Nivel 3: especialidades de Desarrollo
        desarrollo.agregarHijo(new NodoGeneral<>("Backend"));
        desarrollo.agregarHijo(new NodoGeneral<>("Frontend"));

        // Total: 12 nodos en 4 niveles (0 a 3)
        System.out.println("Raiz: " + raiz.getDato());
        System.out.println("Jerarquia completa:");
        raiz.imprimir(0);
    }
}
