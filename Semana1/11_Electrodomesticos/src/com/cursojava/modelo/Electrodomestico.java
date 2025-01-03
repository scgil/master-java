package com.cursojava.modelo;

/**
 * Clase que representa un Electrodomestico
 * Crea objetos de tipo Electrodomestico
 * @author Sergio Castro
 * @version 1.0 2024/12/11
 */
public abstract class Electrodomestico {
	
	protected final int PRECIO_BASE = 100;
	protected final int PESO = 5;
	protected final Consumo CONSUMO_ENERGETICO = Consumo.F;
	protected final Color COLOR = Color.BLANCO;
	
	public enum Consumo{
		A,B,C,D,E,F
	}
	public enum Color{
		BLANCO, NEGRO, ROJO, AZUL, GRIS
	}
	protected double precioBase;
	protected Consumo consumoEnergetico;
	protected Color color;
	protected double peso;
	
	public Electrodomestico() {
		this.precioBase = PRECIO_BASE;
		this.consumoEnergetico = CONSUMO_ENERGETICO;
		this.color = COLOR;
		this.peso = PESO;
	}
	public Electrodomestico(int precioBase, int peso) {
		this();
		this.precioBase = precioBase;
		this.peso = peso;
		
	}
	public Electrodomestico(int precioBase, int peso, Consumo consumoEnergetico, Color color ) {
		this(precioBase, peso);
		this.consumoEnergetico = consumoEnergetico;
		this.color = color;
		
	}

}
