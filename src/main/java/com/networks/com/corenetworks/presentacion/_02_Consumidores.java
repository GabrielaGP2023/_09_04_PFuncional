package com.networks.com.corenetworks.presentacion;

import com.networks.modelo.Producto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;

public class _02_Consumidores {
    public static void main(String[] args) {
        // Consumidor para imprimir en mayúsculas
        Consumer<String> imprimirEnMayusculas = cadena -> System.out.println(cadena.toUpperCase());

        // Consumidor para imprimir un número y su cuadrado
        Consumer<Integer> imprimirNumeroYCuadrado = numero ->
                System.out.println("Número: " + numero + ", Cuadrado: " + (numero * numero));


        Consumer<Producto> imprimirDetallesProducto = producto ->
                System.out.println(producto);

//        // Consumidor para mostrar un mensaje en un cuadro de diálogo (simulado con un print en consola)
//        Consumer<String> mostrarMensajeDialogo = mensaje ->
//                System.out.println("Cuadro de diálogo: " + mensaje);

        // Ruta del archivo de registro
        String rutaArchivo = "registro.log";

        // Consumidor para escribir en un archivo de registro
        Consumer<String> escribirEnArchivoDeRegistro = mensaje -> {
            try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo, true))) {
                writer.println(mensaje);
                writer.flush();
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo de registro: " + e.getMessage());
            }
        };

        // Ejemplos de uso
        escribirEnArchivoDeRegistro.accept("Evento: Usuario se ha conectado");
        escribirEnArchivoDeRegistro.accept("Evento: Usuario ha realizado una operación");
        escribirEnArchivoDeRegistro.accept("Evento: Usuario se ha desconectado");

        // Confirmación
        System.out.println("Eventos registrados en " + rutaArchivo);

        // Ejemplos de uso
        imprimirEnMayusculas.accept("hola mundo"); // "HOLA MUNDO"
        imprimirNumeroYCuadrado.accept(5); // "Número: 5, Cuadrado: 25"
        Producto producto = new Producto("Laptop", 1500.00);
        imprimirDetallesProducto.accept(producto); // "Producto{nombre='Laptop', precio=1500.0}"
//        mostrarMensajeDialogo.accept("Error de conexión"); // "Cuadro de diálogo: Error de conexión"
        escribirEnArchivoDeRegistro.accept("Usuario se ha desconectado"); // "Registro: Usuario se ha desconectado"

        List<Integer> numeros = List.of(1,2,3,4,5);
        numeros.forEach(imprimirNumeroYCuadrado);
    }
}
