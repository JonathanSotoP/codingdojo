package proyecto.service;

import java.util.List;

import proyecto.models.User;

public interface UserServices {

	User encontrarPorId(long id);

	User findByEmail(String email);




	List<User> listaDeUsuarios();

	User eliminarTarea(long idCurso, long idUser);

	void createWithUserRole(User user);

	void createWithAdminRole(User user);
	

}
