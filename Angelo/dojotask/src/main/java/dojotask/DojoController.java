package dojotask;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoController {
	@RequestMapping("/")
	public String Task() {
		return "index.jsp";
	}
	@RequestMapping(value="/results", method=RequestMethod.POST)
	public String formulario(HttpSession session,@RequestParam(value="nombre") String name,@RequestParam(value="city") String city,@RequestParam(value="favorite") String favorite,@RequestParam(value="coment") String coment) {
		session.setAttribute("name", name);
		session.setAttribute("city", city);
		session.setAttribute("favorite", favorite);
		session.setAttribute("coment", coment);
		if(favorite.equals("Java")) {
			return "redirect:/java";
		}
		else return "redirect:/result";
	}
	@RequestMapping("/result")
	public String Result() {
		return "result.jsp";
	}
	@RequestMapping("/java")
	public String javalover() {
		return "java.jsp";
	}
}
