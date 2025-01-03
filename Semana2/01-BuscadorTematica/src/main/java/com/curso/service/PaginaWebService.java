package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.PaginaWeb;

public class PaginaWebService {
	
	List<PaginaWeb> paginasWeb = List.of(new PaginaWeb("http://www.marca.com", "Prensa", "Noticas de diferentes deportes."),
			new PaginaWeb("http://www.20minutos.com", "Prensa", "Noticias de interes general."),
			new PaginaWeb("http://www.instagram.com", "Redes sociales", "Especializada en fotografías."),
			new PaginaWeb("http://www.twitter.com", "Redes sociales", "Especializada en texto o tweets"));

		
	
	public List<PaginaWeb> paginasWebPorTematica(String tematica) {
		List<PaginaWeb> paginas = new ArrayList<>();
		for(PaginaWeb pagina :paginasWeb) {
			if(pagina.getTematica().equals(tematica)) {
				paginas.add(pagina);
			}
			
		}
		return paginas;
		
	}
	
	public List<String> tematicas(){
		List<String> tematicas = new ArrayList<>();
		for(PaginaWeb pagina :paginasWeb) {
			
			if(!tematicas.contains(pagina.getTematica())) {
				tematicas.add(pagina.getTematica());
			}
			
		}
		return tematicas;
	}
	
	public boolean tematicaExistente(String tematica){
		
		
		List<String> tematicas = tematicas();
		for(String tema :tematicas) {
			
			if(tema.equals(tematica)) {
				return true;
			}
			
		}
		return false;
	}

}
	

