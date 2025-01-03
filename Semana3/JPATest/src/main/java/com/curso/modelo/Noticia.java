package com.curso.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Representa una noticia de un periódico.
 * Esta clase es una entidad JPA que mapea a una tabla en la base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/26
 *
 */



@Entity
@Table(name="noticias")
@NamedQueries({
@NamedQuery(name="Noticia.findAll", query="SELECT n FROM Noticia n"),
@NamedQuery(name="Noticia.findByAutor", query="SELECT n FROM Noticia n WHERE n.autor= :autor"),
@NamedQuery(name="Noticia.findByFecha", query="SELECT n FROM Noticia n WHERE n.fecha = :fecha")
})
public class Noticia {
	
	@Id
	private String titulo;
	private String autor;
	private LocalDate fecha;
	
	@OneToMany (mappedBy = "noticia")
	private List<Comentario> comentarios;

	public Noticia() {
		super();
	}

	public Noticia(String titulo) {
		super();
		this.titulo = titulo;
	}

	public Noticia(String titulo, String autor, LocalDate fecha) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Noticia [titulo=" + titulo + ", autor=" + autor + ", fecha=" + fecha + "]";
	}

	
	
	

}
