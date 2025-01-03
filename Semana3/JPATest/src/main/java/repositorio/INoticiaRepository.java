package repositorio;

import java.time.LocalDate;
import java.util.List;

import com.curso.modelo.Noticia;
/**
 * Interfaz para el repositorio de la entidad {@link Noticia}.
 * Define los métodos deben ser implementados para gestionar lss noticias en la base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/26
 */
public interface INoticiaRepository {
	public List<Noticia> findAll();
	public List<Noticia> findByAutor(String autor);
	public List<Noticia> findByFecha(LocalDate fecha);
	

}
