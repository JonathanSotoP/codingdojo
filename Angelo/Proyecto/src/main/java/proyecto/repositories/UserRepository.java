package proyecto.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proyecto.models.User;



@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	User findByEmail(String email);
	List<User>findByIdNotIn(Collection<Long> usuarios);
	
	
}
