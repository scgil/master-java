package com.cursojava.modelo;

/**
 * Clase que representa una Cafetera
 * Crea objetos Cafetera y su gestión
 * @author Sergio Castro
 * @version 1.0 2024/12/05
 */

public class Cafetera {
	
	private int capacidadMaxima;
	private int cantidadActual;
	
	public Cafetera() {
		this.capacidadMaxima = 1000;
		this.cantidadActual = 0;
		
	}
	
	public Cafetera(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = capacidadMaxima;
	}

	public Cafetera(int capacidadMaxima, int cantidadActual) {
		if(cantidadActual > capacidadMaxima) {
			
			this.cantidadActual = capacidadMaxima;
		}else {
			this.capacidadMaxima = capacidadMaxima;
			this.cantidadActual = cantidadActual;
		}
		
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int capacidadActual) {
		this.cantidadActual = capacidadActual;
	}
	
	public void llenarCafetera() {
		
		setCantidadActual(capacidadMaxima);
		System.out.println("Cafetera llena. Cantidad actual: "+cantidadActual);
		
	}
	
	public void servirTaza(int cantidad) {
		
		if(cantidad <= 0) {
			System.out.println("Cantidad introducida es incorrecta");
		}else if(cantidadActual < cantidad) {
			setCantidadActual(0);
			System.out.println("Cantidad actual insuficiente: se ha servido la siguiente cantidad de cafe"+ cantidad);
		}else {
			
			setCantidadActual(cantidadActual - cantidad);
			System.out.println("Taza servida. Cantidad actual: "+cantidadActual);
		}
		
		
	}
	
	public void vaciarCafetera() {
		setCantidadActual(0);
		System.out.println("Cafetera vacia. Cantidad:"+ cantidadActual);
	}
	
	public void agregarCafe(int cantidad) {
		int espacioLibre = capacidadMaxima - cantidadActual;
		int nuevaCantidad = cantidadActual + cantidad;
		
		if(cantidad <= 0) {
			System.out.println("Cantidad introducida es incorrecta");
		}else if(cantidadActual == capacidadMaxima) {
			System.out.println("Cafetera llena. No se puede agregar cafe");
			
		}else if (nuevaCantidad > capacidadMaxima){
			setCantidadActual(capacidadMaxima);
			System.out.println("Cantidad actual + cantidad agregada supera capacidad Maxima. Solo se introduce: "+espacioLibre+ "de café");
		}else {
			setCantidadActual(nuevaCantidad);
			System.out.println("Cafe introducido correctamente. Cantidad actual: "+cantidadActual);
		}
	}
	
	
	
	

}
