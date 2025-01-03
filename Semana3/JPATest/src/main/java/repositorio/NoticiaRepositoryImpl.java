package repositorio;

import java.time.LocalDate;
import java.util.List;

import com.curso.modelo.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * Implementación del repositorio para la entidad {@link Noticia}.
 * Esta clase proporciona métodos para realizar operaciones en la base de datos
 * utilizando JPA.
 * @author Sergio Castro
 * @version 1.0 2024/12/26
 */
public class NoticiaRepositoryImpl implements INoticiaRepository {
	private EntityManager em;
	
	public NoticiaRepositoryImpl(EntityManager entityManager) {
		this.em = entityManager;
		
	}
	
	public List<Noticia> findAll() {
		TypedQuery<Noticia> consulta = em.createNamedQuery("Noticia.findAll", Noticia.class);
		List<Noticia> noticias = consulta.getResultList();
		return noticias;
	}

	public List<Noticia> findByAutor(String autor) {
		TypedQuery<Noticia> consulta = em.createNamedQuery("Noticia.findByAutor", Noticia.class);
		consulta.setParameter("autor", autor);	
		List<Noticia> noticias = consulta.getResultList();
		
		return noticias;
	}

	public List<Noticia> findByFecha(LocalDate fecha) {
		TypedQuery<Noticia> consulta = em.createNamedQuery("Noticia.findByFecha", Noticia.class);
		consulta.setParameter("fecha", fecha);	
		List<Noticia> noticias = consulta.getResultList();
		
		return noticias;
	}

}
