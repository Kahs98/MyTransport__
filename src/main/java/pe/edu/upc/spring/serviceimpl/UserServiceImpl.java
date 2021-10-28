package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.User;
import pe.edu.upc.spring.repository.IUserRepository;
import pe.edu.upc.spring.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository dUser;
	
	@Override
	@Transactional
	public boolean registrar(User user) {
		User objUser = dUser.save(user);
		if (objUser == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idUser) {
		dUser.deleteById(idUser);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> listarId(int idUser) {
		return dUser.findById(idUser);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> listar() {
		return dUser.findAll();
	}

}
