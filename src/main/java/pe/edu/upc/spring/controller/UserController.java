package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.User;
import pe.edu.upc.spring.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
		
	@RequestMapping("/")
	public String irPaginaListadoUsers(Map<String, Object> model) {
		model.put("listaUsers", rService.listar());
		return "listUser";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("user", new User());
		return "user";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute User objUser, BindingResult binRes, Model model)
			throws ParseException
	{
		if (binRes.hasErrors())
			return "user";
		else {
			boolean flag = rService.registrar(objUser);
			if (flag)
				return "redirect:/user/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/user/irRegistrar";
			}
		}
	}
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException 
	{
		Optional<User> objUser = rService.listarId(id);
		if (objUser == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/user/listar";
		}
		else {
			model.addAttribute("user", objUser);
			return "user";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaUsers", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un roche");
			model.put("listaUsers", rService.listar());
			
		}
		return "listUser";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaUsers", rService.listar());
		return "listUser";
	}		
}
