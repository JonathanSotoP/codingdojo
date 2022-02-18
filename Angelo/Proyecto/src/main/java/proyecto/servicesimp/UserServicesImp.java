package proyecto.servicesimp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import proyecto.models.Tareas;
import proyecto.models.User;
import proyecto.repositories.RoleRepository;
import proyecto.repositories.UserRepository;
import proyecto.service.RoleServices;
import proyecto.service.TareasService;
import proyecto.service.UserServices;

@Service
public class UserServicesImp implements UserServices{
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RoleRepository roleRepo;


	@Autowired
	@Lazy
	private UserRepository userRepository;
	@Autowired
	@Lazy
	private RoleServices RoleService;
	@Autowired
	@Lazy
	private TareasService tareaService;
	@Override
	public List<User>listaDeUsuarios(){
		return(List<User>)userRepository.findAll();
	}
	@Override
	@Transactional
	public void createWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_USER"));
		userRepository.save(user);
	}
	
	@Override
	@Transactional
	public void createWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
		userRepository.save(user);
	}
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public User encontrarPorId(long id) {
		Optional<User> otp = userRepository.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		return null;
	}
//	@Override
//	@Transactional
//	public User AñadirTarea(long idTarea, long idUser) {
//	User usuario = encontrarPorId(idUser);
//	Tareas tarea = tareaService.encontrarPorId(idTarea);
//	usuario.getTareas().add(tarea);
//	return userRepository.save(usuario);
//	}
	
	@Override
	@Transactional
	public User eliminarTarea(long idCurso, long idUser) {
		User usuario = encontrarPorId(idUser);
		Tareas tarea = tareaService.encontrarPorId(idCurso);
		usuario.getTareas().remove(tarea);
		return userRepository.save(usuario);
	}
	
	public List<User> usuariosSinTarea(long id){
		List<Long> ids = new ArrayList<Long>(); 
		Tareas t =  tareaService.encontrarPorId(id);
		if(!t.getUsuarios().isEmpty()) {	
			for(User c: t.getUsuarios()) {
				ids.add(c.getId());
			}
			return(List<User>)userRepository.findByIdNotIn(ids);
		}
		else {
			return listaDeUsuarios();
		}
	}

}