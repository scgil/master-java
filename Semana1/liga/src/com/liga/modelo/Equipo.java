package com.liga.modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	private String nombre;
	private List<Jugador> jugadores;
	
	public Equipo(String nombre) {
		jugadores = new ArrayList<>();
		nombre = this.nombre;
		
	}

}
