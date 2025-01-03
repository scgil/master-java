package com.cursojava.principal;

import com.cursojava.modelo.Coche;

public class Main {

	public static void main(String[] args) throws InterruptedException {
	
		Coche miCoche = new Coche("1234ABC", "Opel", "Corsa", "Rojo");
		
		System.out.println("Matrícula del coche: " + miCoche.getMatricula());
        miCoche.arrancar();
        Thread.sleep(2000);
        miCoche.avanzar(5);
        Thread.sleep(2000);
        miCoche.avanzar(5);
        miCoche.parar();
        
        
        
       
    }

}
