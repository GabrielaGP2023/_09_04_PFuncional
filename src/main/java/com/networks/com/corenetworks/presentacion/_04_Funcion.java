package com.networks.com.corenetworks.presentacion;

import com.networks.modelo.Stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_Funcion {
    public static void main(String[] args) {
        // Lista de números de ejemplo
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Función que filtra los números pares
        Function<List<Integer>, List<Integer>> filtrarPares = lista ->
                lista.stream()                   // Convertimos la lista a un stream
                        .filter(n -> n % 2 == 0)     // Filtramos los números pares
                        .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> filtrarPares2 = lista ->{
            List<Integer> resultadoList = new ArrayList<>();
            for(Integer i: lista) {
            if (i % 2 == 0) {
                resultadoList.add(i);
            }}
            return resultadoList;
        };// Convertimos el stream de vuelta a una lista

        // Aplicamos la función a la lista de números
        List<Integer> numerosPares = filtrarPares.apply(numeros);
        List<Integer> numerosPares2 = filtrarPares2.apply(numeros);

        // Imprimimos el resultado
        System.out.println("Números pares: " + numerosPares);

        // Lista de números de ejemplo
        List<Integer> numeros_3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Función para calcular el mínimo usando forEach
        Function<List<Integer>, Integer> calcularMin = (lista) -> {
            final int[] min = {lista.get(0)};

            lista.forEach(numero -> {
                if (numero < min[0]) {
                    min[0] = numero;
                }
            });
            return min[0];
        };

        // Función para calcular el máximo usando forEach
        Function<List<Integer>, Integer> calcularMax = (lista) -> {
            final int[] max = {lista.get(0)};
            lista.forEach(numero -> {
                if (numero > max[0]) {
                    max[0] = numero;
                }
            });
            return max[0];
        };


        // Función para calcular la media usando forEach
        Function<List<Integer>, Double> calcularMedia = (lista) -> {
            final int[] suma = {0};
            lista.forEach(numero -> suma[0] += numero);
            return (double) suma[0] / lista.size();
        };

        Function<List<Integer>,Stats>  estadisticaFinal = lista -> {
            int min = calcularMin.apply(numeros);
            int max = calcularMax.apply(numeros);
            double media = calcularMedia.apply(numeros);
            return new Stats(min, max, media);

        };
        System.out.println("---Ejercicio 2 ---");
        System.out.println(estadisticaFinal.apply(numeros_3));
        // Función para calcular las estadísticas
        Function<List<Integer>, Stats> calcularEstadisticas = lista -> {
            IntSummaryStatistics stats = lista.stream()  // Convertimos la lista a un stream
                    .mapToInt(Integer::intValue) // Mapeamos a int para estadísticas
                    .summaryStatistics();        // Obtenemos las estadísticas

            // Devolvemos un nuevo objeto Stats con el mínimo, máximo y media
            return new Stats(stats.getMin(), stats.getMax(), stats.getAverage());
        };

        // Aplicamos la función a la lista de números
        Stats estadisticas = calcularEstadisticas.apply(numeros_3);

        // Imprimimos las estadísticas
        System.out.println(estadisticas);

        String contrasena = "P@ssw0rd";

        // Función para verificar que la contraseña tiene al menos 8 caracteres
        Function<String, Boolean> tieneLongitudMinima = pass -> pass.length() >= 8;

        // Función para verificar que la contraseña contiene al menos una letra mayúscula

        Function<String, Boolean> tieneMayuscula = pass -> pass.chars().anyMatch(Character::isUpperCase);

        // Función para verificar que la contraseña contiene al menos una letra minúscula
        Function<String, Boolean> tieneMinuscula = pass -> pass.chars().anyMatch(Character::isLowerCase);

        // Función para verificar que la contraseña contiene al menos un número
        Function<String, Boolean> tieneNumero = pass -> pass.chars().anyMatch(Character::isDigit);

        // Función para verificar que la contraseña contiene al menos un carácter especial
        Function<String, Boolean> tieneCaracterEspecial = pass -> pass.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));

        // Combinamos todas las funciones de validación
        Function<String, Boolean> esContrasenaValida = pass ->
                tieneLongitudMinima.apply(pass) &&
                        tieneMayuscula.apply(pass) &&
                        tieneMinuscula.apply(pass) &&
                        tieneNumero.apply(pass) &&
                        tieneCaracterEspecial.apply(pass);

        // Verificamos la contraseña y mostramos el resultado
        boolean resultado = esContrasenaValida.apply(contrasena);
        System.out.println("¿Es la contraseña válida? " + resultado);
    }
}
