package com.curso.principal;

import com.curso.clases.Factura;
import com.curso.clases.Pagina;
import com.cursojava.interfaces.Imprimible;

public class GestionDeImpresion {

	public static void main(String[] args) {
		Pagina p1 = new Pagina(20, 35);
		
		p1.informeCorto();
		p1.informeLargo();
		
		Factura f1 = new Factura(20001,11);
		
		f1.informeCorto();
		f1.informeLargo();
	//Hacer un array e ir invocando a los métodos	
		System.out.println("===================================================");			
		Imprimible p2 = new Pagina(25, 33);
		Imprimible f2 = new Factura(33333, 99);
	
		p2.informeCorto();
		p2.informeLargo();
		
		f2.informeCorto();
		f2.informeLargo();
		
		
	//	Imprimible[]  xxx  ={ p2, f2, p3, p4, f3,p5 ,f4}
		
		Imprimible[] impresora = {p2, f2};
		
		for(int i=0; i<impresora.length; i++) {
			impresora[i].informeCorto();
			impresora[i].informeLargo();
			
		}
		

	}

}
