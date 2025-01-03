package repositorio;

import java.util.List;
import java.util.Optional;

import com.curso.modelo.Comentario;
import com.curso.modelo.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * Implementación del repositorio para la entidad {@link Comentario}.
 * Esta clase proporciona métodos para realizar operaciones en la base de datos
 * utilizando JPA.
 * @author Sergio Castro
 * @version 1.0 2024/12/26
 */
public class ComentarioRepositoryImpl implements IComentarioRepository {
	
	private EntityManager em;
	
	public ComentarioRepositoryImpl(EntityManager entityManager) {
		this.em = entityManager;
		
	}
	
	public List<Comentario> findAll() {
		TypedQuery<Comentario> consulta = em.createNamedQuery("Comentario.findAll", Comentario.class);
		List<Comentario> comentarios = consulta.getResultList();
		return comentarios;
	}

	public List<Comentario> findByAutor(String autor) {
		TypedQuery<Comentario> consulta = em.createNamedQuery("Comentario.findByAutor", Comentario.class);
		consulta.setParameter("autor", autor);	
		List<Comentario> comentarios = consulta.getResultList();
		
		return comentarios;
	}
	public Optional<List<Comentario>> findComentariosByNoticia(String titulo) {
		
		Noticia noticia = em.find(Noticia.class, titulo);
		
		if (noticia != null) {

            return Optional.of(noticia.getComentarios());

        } else {

            return Optional.empty();

        }

	}

}
