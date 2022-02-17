package proyecto.servicesimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.models.Role;
import proyecto.repositories.RoleRepository;
import proyecto.service.RoleServices;
@Service
public class RoleServiceImp implements RoleServices {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public List<Role> allPermisos() {
		return(List<Role>) roleRepo.findAll();
	}

}
