package com.cursojava.principal;

import com.cursojava.modelo.Cuenta;
import com.cursojava.modelo.Cuenta.Estado;

public class Main {

	public static void main(String[] args) {
		
		try {
			Cuenta c1 = new Cuenta("Sergio");
			double cantidad = c1.getCantidad();
			System.out.println(cantidad);
			c1.setCantidad(5.0);
			System.out.println(c1.getCantidad());
			//c1.ingresar(-100);
			c1.setEstado(Estado.BLOQUEADA);
			c1.ingresar(-100);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
