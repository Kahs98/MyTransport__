package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Admin;



public interface IAdminService {
	public boolean registrar(Admin admin);
	public void eliminar(int idAdmin);
	public Optional<Admin> listarId(int idAdmin);
	List<Admin> listar();	
}
