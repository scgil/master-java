package com.cursojava.colegio;

import java.util.Objects;

public class Nota {
	private String asignatura;
	private double valor;
	public Nota(String asignatura, double valor) {
		this.asignatura = asignatura;
		this.valor = valor;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(asignatura, valor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(asignatura, other.asignatura)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
	public boolean esMismaAsignatura(Nota nota2) {
		if(this.getAsignatura().equals(nota2.getAsignatura())) {
			return true;
		}
		return false;
	}
	
	public boolean esMayor(Nota nota2) {
		if(this.esMismaAsignatura(nota2)) {
			if(this.getValor()>nota2.getValor()) {
				return true;
			}else {
				return false;
			}
		}else {
			throw new RuntimeException("Las notas no son comparables porque no son de la misma asignatura");
		}
	}
	
	
}
