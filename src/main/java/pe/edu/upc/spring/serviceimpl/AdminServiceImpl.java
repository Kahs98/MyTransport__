package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Admin;
import pe.edu.upc.spring.repository.IAdminRepository;
import pe.edu.upc.spring.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository dAdmin;
	
	@Override
	@Transactional
	public boolean registrar(Admin admin) {
		Admin objAdmin = dAdmin.save(admin);
		if (objAdmin == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idAdmin) {
		dAdmin.deleteById(idAdmin);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Admin> listarId(int idAdmin) {
		return dAdmin.findById(idAdmin);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Admin> listar() {
		return dAdmin.findAll();
	}

}
