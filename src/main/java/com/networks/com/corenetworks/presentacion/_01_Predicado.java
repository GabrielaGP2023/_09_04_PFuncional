package com.networks.com.corenetworks.presentacion;

import java.util.function.Predicate;

public class _01_Predicado {
    public static class _01_Ejercicios_Predicado {
        public static void main(String[] args) {
            // Predicado para verificar si un número es positivo
            Predicate<Integer> esPositivo = numero -> numero > 0;

            // Predicado para verificar si una cadena no está vacía
            Predicate<String> noEstaVacia = cadena -> cadena != null && !cadena.isEmpty();

            // Predicado para verificar si un número es par
            Predicate<Integer> esPar = numero -> numero % 2 == 0;

            // Predicado para verificar si un número es mayor que un valor específico
            final int valorReferencia = 10;
//            valorReferencia = 15;
            Predicate<Integer> esMayorQue = numero -> numero > valorReferencia;

            // Predicado para verificar si un número es primo
            Predicate<Integer> esPrimo = numero -> {
                if (numero <= 1) return false;
                for (int i = 2; i <= Math.sqrt(numero); i++) {
                    if (numero % i == 0) return false;
                }
                return true;
            };

            // Ejemplos de uso
            System.out.println("¿5 es positivo? " + esPositivo.test(5)); // true
            System.out.println("¿La cadena \"Hola\" no está vacía? " + noEstaVacia.test("Hola")); // true
            System.out.println("¿4 es par? " + esPar.test(4)); // true
            System.out.println("¿15 es mayor que 10? " + esMayorQue.test(15)); // true
            System.out.println("¿7 es primo? " + esPrimo.test(7)); // true
        }
    }
}
