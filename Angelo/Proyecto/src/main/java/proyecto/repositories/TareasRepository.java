package proyecto.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proyecto.models.Tareas;
import proyecto.models.User;

@Repository
public interface TareasRepository extends CrudRepository<Tareas, Long> {
//	List<Tareas>findByIdnotIn( Collection<Long> User);
	List<Tareas> findByUsuarioCreador(User user );

}
