package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Vehicle;

public interface IVehicleService {
	public boolean registrar(Vehicle vehicle);
	public void eliminar(int idVehicle);
	public Optional<Vehicle> listarId(int idVehicle);
	public Optional<Vehicle> buscarId(int idVehicle);
	List<Vehicle> listar();
	List<Vehicle> buscarNombre(String nameVehicle);
	List<Vehicle> buscarTipo(String typeVehicle);
	List<Vehicle> buscarPropietario(String nameUsuario);	
}
