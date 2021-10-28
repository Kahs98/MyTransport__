package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Vehicle;
import pe.edu.upc.spring.repository.IVehicleRepository;
import pe.edu.upc.spring.service.IVehicleService;

@Service
public class VehicleServiceImpl implements IVehicleService {

	@Autowired
	private IVehicleRepository dVehicle;
	
	@Override
	@Transactional
	public boolean registrar(Vehicle vehicle) {
		Vehicle objVehicle = dVehicle.save(vehicle);
		if (objVehicle == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idVehicle) {
		dVehicle.deleteById(idVehicle);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vehicle> listarId(int idVehicle) {
		return dVehicle.findById(idVehicle);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Vehicle> buscarId(int idVehicle) {
		return dVehicle.findById(idVehicle);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Vehicle> listar() {
		return dVehicle.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vehicle> buscarNombre(String nameVehicle) {
		return dVehicle.buscarNombre(nameVehicle);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Vehicle> buscarTipo(String typeVehicle) {
		return dVehicle.buscarTipo(typeVehicle);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Vehicle> buscarPropietario(String nameUsuario) {
		return dVehicle.buscarPropietario(nameUsuario);
	}		

}
