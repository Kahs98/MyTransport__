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

import pe.edu.upc.spring.model.Vehicle;
import pe.edu.upc.spring.model.User;

import pe.edu.upc.spring.service.IVehicleService;
import pe.edu.upc.spring.service.IUserService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private IUserService dService;
	
	@Autowired
	private IVehicleService pService;	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
		
	@RequestMapping("/")
	public String irPaginaListadoVehiculos(Map<String, Object> model) {
		model.put("listaVehicles", pService.listar());
		return "listVehicle";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaUsers", dService.listar());
		model.addAttribute("user", new User());
		model.addAttribute("vehicle", new Vehicle());		
		return "vehicle";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Vehicle objVehicle, BindingResult binRes, Model model)
			throws ParseException
	{
		if (binRes.hasErrors()) 
			{
				model.addAttribute("listaUsers", dService.listar());			
				return "vehicle";
			}
		else {
			boolean flag = pService.registrar(objVehicle);
			if (flag)
				return "redirect:/vehicle/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/vehicle/irRegistrar";
			}
		}
	}
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException 
	{
		Optional<Vehicle> objVehicle = pService.buscarId(id);
		if (objVehicle == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/vehicle/listar";
		}
		else {
	
			model.addAttribute("listaUsers", dService.listar());			
					
			if (objVehicle.isPresent())
				objVehicle.ifPresent(o -> model.addAttribute("vehicle", o));
			
			return "vehicle";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaVehicles", pService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un roche");
			model.put("listaVehicles", pService.listar());
			
		}
		return "listVehicle";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaVehicles", pService.listar());
		return "listVehicle";
	}		
	@RequestMapping("/listaUser")
	public String listaUser(Map<String, Object> model) {
		model.put("listaVehicles", pService.listar());
		return "listUserE";
	}
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Vehicle vehicle) 
	throws ParseException
	{
		pService.listarId(vehicle.getIdVehicle());
		return "listVehicle";
	}	
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("vehicle", new Vehicle());
		return "buscarV";
	}	
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Vehicle vehicle)
			throws ParseException
	{
		List<Vehicle> listaVehicles;
		vehicle.setNameVehicle(vehicle.getNameVehicle());
	        listaVehicles = pService.buscarNombre(vehicle.getNameVehicle());
	        if (listaVehicles.isEmpty()) {
	        	listaVehicles = pService.buscarTipo(vehicle.getNameVehicle());
	        }
	        if (listaVehicles.isEmpty()) {
	        	listaVehicles = pService.buscarPropietario(vehicle.getNameVehicle());
	        }
	        if (listaVehicles.isEmpty()) {
	            model.put("mensaje", "No existen coincidencias");
	        }
	        model.put("listaVehicles", listaVehicles);	
		return "buscarV";
	}		
}
