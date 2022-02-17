package proyecto.servicesimp;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import proyecto.models.User;
import proyecto.repositories.RoleRepository;
import proyecto.repositories.UserRepository;
import proyecto.service.RoleServices;
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

	@Override
	@Transactional
	public void createUserNormal(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_USER"));
		userRepository.save(user);
	}
	
	@Override
	@Transactional
	public void createUserAdmin(User user) {
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
}