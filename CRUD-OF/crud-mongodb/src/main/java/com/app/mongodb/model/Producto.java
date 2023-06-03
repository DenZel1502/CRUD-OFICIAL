package com.app.mongodb.model;

import java.awt.Image;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document
public class Producto {
	@Id
	private String id;
	private String categoria;
	private String nombre;
	private double precio;
	private int stock;
	
	
	public Producto() {
		super();
	}


	public Producto(String id, String categoria, String nombre, double precio, int stock) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;	
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
