package proyecto.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import proyecto.models.User;
import proyecto.service.UserServices;
import proyecto.validator.UserValidator;

@Controller
public class MainController {
	
	@Autowired
	private UserServices userService;
	@Autowired
	private UserValidator userValidator;
	
	
	@GetMapping("/tuttitask")
	public String tuttiTask() {
		return"tuttitask.jsp";
	}
	@GetMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("user")User user, Model model) {
		model.getAttribute("errorMessage");
		return "registerUser.jsp";
	}
	@PostMapping("/registrarUsuario")
	public String registrarUsuario(@Valid @ModelAttribute("user")User user, BindingResult result) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return"registerUser.jsp";
		}
		else {
			userService.createUserNormal(user);
			return"redirect:/tuttitask";
		}
	}
	@GetMapping("/registerAdmin")
	public String registerAdmin(@Valid @ModelAttribute("user")User user, Model model) {
		model.getAttribute("errorMessage");
		return "registerAdmin.jsp";
	}
	@PostMapping("/registrar")
	public String registrarAdministrador(@Valid @ModelAttribute("user")User user, BindingResult result) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return"registerAdmin.jsp";
		}
		else {
			userService.createUserAdmin(user);
			return"redirect:/tuttitask";
		}
	}
	@GetMapping("/loginPage")
	public String loginPage() {
		return"login.jsp";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required = false)String error, @RequestParam(value="logout", required= false )String logout, Model model) {
		if(error != null) {
			model.addAttribute("error", "Error, usuario o  Contraseña Erroneo, Intente de nuevo.");
		}
		if(logout != null) {
			model.addAttribute("logout", "Se cerro Su session de forma Exitosa!");
			return"redirect:/tuttitask";
		}
		else {
			return"redirect:/dashboard";
		}
	}
	@GetMapping("/dashboard")
	public String dashboard(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("usuario", username);
		return"dashboard.jsp";	
	}
	@GetMapping("/Admin/create")
	public String tareas(){
		return"tarea.jsp";
	}

}
