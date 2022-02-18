package proyecto.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import proyecto.models.Tareas;
import proyecto.models.User;
import proyecto.service.TareasService;
import proyecto.service.UserServices;
import proyecto.validator.UserValidator;

@Controller
public class MainController {
	
	@Autowired
	private UserServices userService;
	@Autowired
	private TareasService tareaService;
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
			userService.createWithUserRole(user);
			return"redirect:/tuttitask";
		}
	}
	@GetMapping("/registerAdmin")
	public String registerAdmin(@Valid @ModelAttribute("admin")User user, Model model) {
		model.getAttribute("errorMessage");
		return "registerAdmin.jsp";
	}
	@PostMapping("/registrar")
	public String registrarAdministrador(@Valid @ModelAttribute("admin")User user, BindingResult result) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return"registerAdmin.jsp";
		}
		else {
			userService.createWithAdminRole(user);
			return"redirect:/tuttitask";
		}
	}
	@GetMapping("/login")
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
		User usuario = userService.findByEmail(username);
		model.addAttribute("usuario", userService.findByEmail(username));
		model.addAttribute("tareas",tareaService.EncontrarPorCreador(usuario));
		model.addAttribute("listaDeTareas");
		return"dashboard.jsp";	
	}
	@GetMapping("/admin/tareas/{id}")
	public String mostrarTarea(Principal principal, @PathVariable("id")long id, Model model) {
//		String Username = principal.getName();
		model.addAttribute("tarea", tareaService.encontrarPorId(id));
		//model.addAttribute("usuarioActual", userService.findByEmail(Username));
		return"mostrarTarea.jsp";
	}
	@GetMapping("/admin/crear")
	public String tareas( @ModelAttribute("tarea")Tareas tarea,Model model,Principal principal){
		String usuario = principal.getName();
		User user = userService.findByEmail(usuario);
		long idUser = user.getId();
		model.addAttribute("usuario", idUser);
		return"crearTarea.jsp";
	}
	@PostMapping("/admin/crearTarea")
	public String crearTarea(@Valid @ModelAttribute("tarea")Tareas tarea, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return"crearTarea.jsp";
		}
		else {
			tareaService.crear(tarea);
			return"redirect:/dashboard";
		}
	}
	@GetMapping("/admin/editar/{id}")
	public String editarTarea(@PathVariable("id")long id, Model model) {
		Tareas tarea = tareaService.encontrarPorId(id);
		model.addAttribute("tarea", tarea);
		return"editarTarea.jsp";
	}
	@PutMapping("/admin/{id}")
	public String editar(@Valid @ModelAttribute("Tarea")Tareas tarea, @PathVariable("id")long id, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return"redirect:/admin/editar/"+id;
		}
		else {
			this.tareaService.actualizar(id, tarea);
			return"redirect:/dashboard";
		}
	}
	@DeleteMapping("/admin/delete/{id}")
	public String eliminarTarea(@PathVariable("id")long id) throws Exception {
		tareaService.Eliminar(id);
		return"redirect:/dashboard";
	}
//	@GetMapping("/admin/AñadirTareas")
//	public String AgregarTareas(Principal principal, Model model) {
//		String usuario = principal.getName();
//		User user = userService.findByEmail(usuario);
//		model.addAttribute("idUsuario", user.getId());
//		model.addAttribute("usuarios", userService.listaDeUsuarios());
//		model.addAttribute("tareasDelUsuario", tareaService.EncontrarPorCreador(user.getId()));
//		return "añadirTareas.jsp";
//		
//		
//	}
//	@PostMapping("/admin/añadirTarea")
//	public String añadirTareaAUsuario(@RequestParam("idUsuario")long idUsuario, @RequestParam("idTarea")long idTarea){
//		userService.AñadirTarea(idTarea, idUsuario);
//		return"redirect:/dashboard";
//	}
}
