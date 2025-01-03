package com.curso.principal;

import com.curso.dao.PeliculaDAO;

public class Main {

	public static void main(String[] args) {
		
		PeliculaDAO pdao = new PeliculaDAO();
		
		System.out.println("Todas las peliculas: ");
		pdao.findAll();
		
		System.out.println("Peliculas por nombre director: ");
		pdao.findByDirectorNombre();
		
		System.out.println("Peliculas por nombre director Like: ");
		pdao.findByDirectorLikeNombre();
		
		System.out.println("Peliculas por nombre director In: ");
		pdao.findByDirectorIn();
		
		System.out.println("Peliculas por precio:");
		pdao.findByPrecio();

	}

}
