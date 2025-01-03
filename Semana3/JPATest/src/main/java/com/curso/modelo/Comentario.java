package com.curso.modelo;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * Representa un comentario en una noticia de un periódico.
 * Esta clase es una entidad JPA que mapea a una tabla en la base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/26
 *
 */

@Entity
@Table(name="comentarios")
@NamedQueries({
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c"),
@NamedQuery(name="Comentario.findByAutor", query="SELECT c FROM Comentario c WHERE c.autor= :autor")
})
public class Comentario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texto;
    private String autor;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "titulo_noticia")
    private Noticia noticia;

	public Comentario() {
		super();
	}


	public Comentario(String texto, String autor, Noticia noticia) {
		super();
		this.texto = texto;
		this.autor = autor;
		this.noticia = noticia;
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Comentario other = (Comentario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", texto=" + texto + ", autor=" + autor + ", noticia=" + noticia + "]";
	}
    
	
    

}
