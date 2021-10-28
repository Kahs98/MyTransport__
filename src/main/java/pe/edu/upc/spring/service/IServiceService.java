package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Servicio;

public interface IServiceService {
	public boolean registrar(Servicio servicio);
	public void eliminar(int idPet);
	public Optional<Servicio> listarId(int idService);
	public Optional<Servicio> buscarId(int idService);
	List<Servicio> listar();
	List<Servicio> buscarNombre(String nameService);
	List<Servicio> buscarTipo(String typeService);
	List<Servicio> buscarCiudad(String cityService);	
}
