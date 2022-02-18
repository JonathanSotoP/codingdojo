package proyecto.servicesimp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.models.Tareas;
import proyecto.models.User;
import proyecto.repositories.TareasRepository;
import proyecto.service.TareasService;
import proyecto.service.UserServices;

@Service
public class TareasServiceImp implements TareasService{
	@Autowired
	private TareasRepository tareaRepo;
	@Autowired
	@Lazy
	private UserServices userService;
	@Override
	public List<Tareas> listaTareas(){
		return (List<Tareas>) tareaRepo.findAll();
		
		
	}
	@Override
	public List<Tareas> EncontrarPorCreador(User user) {

	return(List<Tareas>)tareaRepo.findByUsuarioCreador(user);
	}
	
		
//	}
//	@Override
//	public List<Tareas> TareasSinUsuarios(long id){
//		List<Long> ids = new ArrayList<Long>();
//		User u = userService.encontrarPorId(id);
//		if(!u.getTareas().isEmpty()) {
//			for(Tareas t: u.getTareas()) {
//				ids.add(t.getId());
//			}
//		return(List<Tareas>)tareaRepo.findByIdnotIn(ids);
//		}
//		else {
//			return listaTareas();
//		}
//	}
	
	@Override
	public Tareas encontrarPorId(long id){
		Optional<Tareas> otp = tareaRepo.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		return null;
	}
	@Override
	@Transactional
	public Tareas crear(Tareas tarea) throws Exception {
		try {
			Tareas t = tareaRepo.save(tarea);
			return t;
		} catch(Exception a) {
			a.printStackTrace();
			throw a;
		}
	}
	@Override
	@Transactional
	public Tareas actualizar(long id, Tareas tarea) throws Exception{
		try {
			Tareas t = this.encontrarPorId(id);
			if(t!= null) {
				t.setNombre(tarea.getNombre());
				t.setDescripcion(tarea.getDescripcion());
				t.setTiempo(tarea.getTiempo());
				tareaRepo.save(t);
				return t;
			}
			else {
				throw new Exception("No se puede actualizar una Tarea que no existe!");
			}
			}catch (Exception b) {
				b.printStackTrace();
				throw b;
			}
		}
	@Override
	@Transactional
	public void Eliminar(long id) {
		Tareas t = this.encontrarPorId(id);
		tareaRepo.delete(t);
	}
}

