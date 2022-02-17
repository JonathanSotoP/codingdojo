package proyecto.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import proyecto.models.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {
	List<Role> findByName(String name);
	
	List<Role> findAll();


}
