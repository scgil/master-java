package repositorio;

import java.util.List;
import java.util.Optional;

import com.curso.modelo.Comentario;
/**
 * Interfaz para el repositorio de la entidad {@link Comentario}.
 * Define los métodos deben ser implementados para gestionar los comentarios en la base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/26
 */
public interface IComentarioRepository {
	public List<Comentario> findAll();
	public List<Comentario> findByAutor(String autor);
	public Optional<List<Comentario>> findComentariosByNoticia(String titulo);
}
