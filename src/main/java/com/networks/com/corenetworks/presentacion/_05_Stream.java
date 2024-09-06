package com.networks.com.corenetworks.presentacion;

import com.networks.com.corenetworks.presentacion.persistencia.AccesoProducto;
import com.networks.com.corenetworks.presentacion.persistencia.Conexion;
import com.networks.modelo.Producto;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_Stream {
    public static void main(String[] args) {
        AccesoProducto ap1 = new AccesoProducto();
        try {
            List<Producto> lista = ap1.consultarTodos();
           // System.out.println(lista);
            //Obtener los productos cuya categoría sea 2
            Predicate<Producto> filtroCategoria2 = p -> p.getCategoria()==2;
//            lista.stream()
//                    .filter(filtroCategoria2)
//                    .forEach(System.out::println);
            //Productos que comiencen con N


//            lista.stream()
//                    .filter(p -> p.getNombreProducto().startsWith("N"))
//                    .forEach(System.out::println);
            //Ordenar los productos de forma ascendente por nombre de producto
//            lista.stream()
//                    .sorted(Comparator.comparing(Producto::getNombreProducto))
//                    .forEach(System.out::println);
            //Obtener el producto con el precio máximo
           Producto precioMaximo =lista.stream()
                    .max(Comparator.comparing(Producto::getPrecio))
                    .orElse(new Producto());

            System.out.println(precioMaximo);

            double precioPromedio =lista.stream()
                    .mapToDouble(Producto::getPrecio)
                    .average()
                        .orElse(0);
            System.out.println(precioPromedio);

            Map<Integer, Long> stockPorCategoria = lista.stream()
                    .collect(Collectors.groupingBy(
                            Producto::getCategoria, // Agrupa por categoría
                            Collectors.counting() // Suma los stocks
                    ));

            // Mostrar los resultados
            stockPorCategoria.forEach((categoria, totalStock) -> {
                System.out.println("Categoría: " + categoria + ", Stock total: " + totalStock);
            });




        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}
