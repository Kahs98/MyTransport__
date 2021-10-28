package pe.edu.upc.spring.controller;

import java.util.List;
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

import pe.edu.upc.spring.model.Servicio;
import pe.edu.upc.spring.model.Admin;

import pe.edu.upc.spring.service.IServiceService;
import pe.edu.upc.spring.service.IAdminService;

@Controller
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private IAdminService dService;
	
	@Autowired
	private IServiceService pService;	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
		
	@RequestMapping("/")
	public String irPaginaListadoServicios(Map<String, Object> model) {
		model.put("listaServices", pService.listar());
		return "listService";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("admin", new Admin());
		model.addAttribute("service", new Servicio());
		
		model.addAttribute("listaAdmins", dService.listar());		
		
		return "service";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Servicio objService, BindingResult binRes, Model model)
			throws ParseException
	{
		if (binRes.hasErrors()) 
			{
				model.addAttribute("listaAdmins", dService.listar());			
				return "service";
			}
		else {
			boolean flag = pService.registrar(objService);
			if (flag)
				return "redirect:/service/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/service/irRegistrar";
			}
		}
	}
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException 
	{
		Optional<Servicio> objService = pService.buscarId(id);
		if (objService == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/service/listar";
		}
		else {
	
			model.addAttribute("listaAdmins", dService.listar());			
					
			if (objService.isPresent())
				objService.ifPresent(o -> model.addAttribute("service", o));
			
			return "service";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaServices", pService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un roche");
			model.put("listaServices", pService.listar());
			
		}
		return "listService";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaServices", pService.listar());
		return "listService";
	}		
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Servicio service) 
	throws ParseException
	{
		pService.listarId(service.getIdService());
		return "listService";
	}	
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("servicio", new Servicio());
		return "buscar";
	}	
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Servicio service)
			throws ParseException
	{
		List<Servicio> listaServices;
		service.setNameService(service.getNameService());
	        listaServices = pService.buscarNombre(service.getNameService());
	        if (listaServices.isEmpty()) {
	        	listaServices = pService.buscarTipo(service.getNameService());
	        }
	        if (listaServices.isEmpty()) {
	        	listaServices = pService.buscarCiudad(service.getNameService());
	        }
	        if (listaServices.isEmpty()) {
	            model.put("mensaje", "No existen coincidencias");
	        }
	        model.put("listaServices", listaServices);	
		return "buscar";
	}		
}
