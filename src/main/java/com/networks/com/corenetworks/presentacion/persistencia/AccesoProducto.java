package com.networks.com.corenetworks.presentacion.persistencia;





import com.networks.modelo.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AccesoProducto extends Conexion{
	



	public List<Producto> consultarTodos() throws ClassNotFoundException, SQLException {
		//0. Declarar variables
		List<Producto> resultado = new ArrayList<Producto>();
		Statement sentencia;
		ResultSet rejilla;
		String sql = "Select product_id, product_name, unit_price,units_in_stock, category_id from products ";
		//1. Abrir la conexion
		abrirConexion();
		//2. Obtener  el Statement de la conexion
		sentencia = miConexion.createStatement();
		//asignar valor al parámetro
		//3. Ejecutar
		rejilla = sentencia.executeQuery(sql);
		//4. Recorrer el resulset
		while (rejilla.next()) {
			Producto p1 = new Producto(rejilla.getInt("product_id"),
					rejilla.getString("product_name"),
					rejilla.getDouble("unit_price"),
					rejilla.getInt("units_in_stock"),
					rejilla.getInt("category_id"));
			resultado.add(p1);
		}
		//5. Cerrar resulset, statement, conexion
		rejilla.close();
		sentencia.close();
		cerrarConexion();
		//6. Devolver el producto
		return resultado;

	}



}
