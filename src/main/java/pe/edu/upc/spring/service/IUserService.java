package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.User;

public interface IUserService {
	public boolean registrar(User user);
	public void eliminar(int idUser);
	public Optional<User> listarId(int idUser);
	List<User> listar();	
}
