package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Servicio;
import pe.edu.upc.spring.repository.IServiceRepository;
import pe.edu.upc.spring.service.IServiceService;

@Service
public class ServiceServiceImpl implements IServiceService {

	@Autowired
	private IServiceRepository dService;
	
	@Override
	@Transactional
	public boolean registrar(Servicio service) {
		Servicio objService = dService.save(service);
		if (objService == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idService) {
		dService.deleteById(idService);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Servicio> listarId(int idService) {
		return dService.findById(idService);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Servicio> buscarId(int idService) {
		return dService.findById(idService);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Servicio> listar() {
		return dService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Servicio> buscarNombre(String nameService) {
		return dService.buscarNombre(nameService);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Servicio> buscarTipo(String typeService) {
		return dService.buscarTipo(typeService);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Servicio> buscarCiudad(String cityService) {
		return dService.buscarCiudad(cityService);
	}		

}
