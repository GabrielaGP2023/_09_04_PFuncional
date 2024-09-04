package com.networks.com.corenetworks.presentacion;

import com.networks.modelo.Configuracion;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class _03_Proveedor {
    public static void main(String[] args) {
        // Proveedor de números aleatorios en un rango especificado
        Supplier<Integer> numeroAleatorio = () -> new Random().nextInt(100); // Rango de 0 a 99

        // Proveedor de una lista predefinida de elementos
        Supplier<List<String>> listaPredefinida = () -> Arrays.asList("Elemento1", "Elemento2", "Elemento3");

        // Proveedor de fecha y hora actual
        Supplier<LocalDateTime> fechaHoraActual = LocalDateTime::now;

        // Proveedor de un nuevo objeto String vacío
        Supplier<String> cadenaVacia = () -> "";

        Supplier<Configuracion> configuracionApp = () ->
                new Configuracion("config.xml", "localhost:8080");


        // Ejemplos de uso
        System.out.println("Número aleatorio: " + numeroAleatorio.get());
        System.out.println("Lista predefinida: " + listaPredefinida.get());
        System.out.println("Fecha y hora actual: " + fechaHoraActual.get());
        System.out.println("Cadena vacía: \"" + cadenaVacia.get() + "\"");
        System.out.println("Configuración de la aplicación: " + configuracionApp.get());
    }
}
