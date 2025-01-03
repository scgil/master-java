package com.cursojava.principal;

import com.cursojava.modelo.*;
import com.cursojava.modelo.Instrumento.Tipo;

/**
 * Clase que representa la Orquesta
 * Clase en la que se tocan los instrumentos
 * @author Sergio Castro / ViewNext
 * @version 1.0, 2024/12/04 
 */

public class Orquesta {

	public static void main(String[] args) {
		
		
		Flauta f1 = new Flauta("Flauta",Tipo.VIENTO,"modelo flauta");
		GuitarraElectrica g1 = new GuitarraElectrica("Guitarra electrica",Tipo.CUERDA, 6, 50);
		Tambor t1 = new Tambor("Tambor",Tipo.PERCUSION,"Grande");
		
		Instrumento[] instrumentos = {f1, g1, t1};
		
		for(int i=0; i<instrumentos.length; i++) {
			if(instrumentos[i] instanceof Tambor) {
				Tambor t = (Tambor) instrumentos[i];
				t.aporrear();
			}else {
				instrumentos[i].tocar();
			}
		}

	}

}
