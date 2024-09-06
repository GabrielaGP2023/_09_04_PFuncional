package com.networks.modelo;

public class Orden {
	//1. Atributos
	private int idOrden;
	private int idProducto;
	private double precio;
	private int Quantity;


	@Override
	public String toString() {
	return "Orden [idOrden=" + idOrden + ", idProducto=" + idProducto + ", precio=" + precio
	+ ", Quantity=" + Quantity + "]\n";
	}


	public Orden() {
	super();
	}


	public Orden(int idOrden, int idProducto, double precio, int Quantity) {
	super();
	this.idOrden = idOrden;
	this.idProducto = idProducto;
	this.precio = precio;
	this.Quantity = Quantity;
	}


	public Orden(int idOrden, int idProducto) {
	super();
	this.idOrden = idOrden;
	this.idProducto = idProducto;
	}

	public Orden(int idOrden, int idProducto, int quantity) {
		super();
		this.idOrden = idOrden;
		this.idProducto = idProducto;
		Quantity = quantity;
	}


	public int getIdOrden() {
	return idOrden;
	}


	public void setIdOrden(int idOrden) {
	this.idOrden = idOrden;
	}


	public int getIdProducto() {
	return idProducto;
	}


	public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
	}


	public double getPrecio() {
	return precio;
	}


	public void setPrecio(double precio) {
	this.precio = precio;
	}


	public int getQuantity() {
	return Quantity;
	}


	public void setQuantity(int Quantity) {
	this.Quantity = Quantity;
	}

}
