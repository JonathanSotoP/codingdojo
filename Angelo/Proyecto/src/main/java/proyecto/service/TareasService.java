package proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto.models.Tareas;
import proyecto.models.User;

@Service
public interface TareasService {

	List<Tareas> listaTareas();

//	List<Tareas> TareasSinUsuarios(long id);

	Tareas encontrarPorId(long id);

	Tareas crear(Tareas tarea) throws Exception;

	Tareas actualizar(long id, Tareas tarea) throws Exception;

	void Eliminar(long id);

	List<Tareas> EncontrarPorCreador(User user);

}
