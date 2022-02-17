package proyecto.service;

import proyecto.models.User;

public interface UserServices {

	User encontrarPorId(long id);

	void createUserNormal(User user);

	void createUserAdmin(User user);

	User findByEmail(String email);
	

}
