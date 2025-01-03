package com.liga.modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Partido {
	private Equipo local;
	private Equipo visitante;
	Map<Jugador, Integer> golesLocal;
	Map<Jugador, Integer> golesVisitante;
	int resultadoLocal = resultadoLocal();
	int resultadoVisitante = resultadoLocal();
	
	public Partido(Equipo local, Equipo visitante, Map<Jugador, Integer> golesLocal, Map<Jugador, Integer> golesVisitante) {
		local = this.local;
		visitante = this.visitante;
		golesLocal = new HashMap<>();
		golesVisitante = new HashMap<>();		
	}
	
	public Equipo getEquipoLocal() {
		return this.local;
	}
	
	public Equipo getEquipoVisitante() {
		return this.visitante;
	}
	
	public Map<Jugador, Integer> getGolesLocal() {
		return this.golesLocal;
	}
	public Map<Jugador, Integer> getGolesVisitante() {
		return this.golesVisitante;
	}
	
	public void setEquipoLocal(Equipo local) {
		this.local = local;
	}
	public void setEquipoVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	
	public void setGolesVisitante(Map<Jugador, Integer> golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	
	private int resultadoLocal() {
		int resultado = 0;
		if(golesLocal.isEmpty()) {
			return resultado;
			
		}else {
			for (Map.Entry<Jugador, Integer> entry : golesLocal.entrySet()) {
		        resultado += entry.getValue();
		    }
		    
		}
		
	    return resultado;
	}
	
	private int resultadoVisitante() {
		int resultado = 0;
		if(golesVisitante.isEmpty()) {
			return resultado;
			
		}else {
			for (Map.Entry<Jugador, Integer> entry : golesVisitante.entrySet()) {
		        resultado += entry.getValue();
		    }
		    
		}
		
	    return resultado;
	}
	

}
