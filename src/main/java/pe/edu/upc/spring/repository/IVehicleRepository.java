package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
	@Query("from Vehicle v where v.nameVehicle like %:nameVehicle%")
	List<Vehicle> buscarNombre(@Param("nameVehicle") String nameVehicle);
	
	@Query("from Vehicle v where v.typeVehicle like %:typeVehicle%")
	List<Vehicle> buscarTipo(@Param("typeVehicle") String typeVehicle);
	
	@Query("from Vehicle v where v.user.nameUsuario like %:nameUsuario%")
	List<Vehicle> buscarPropietario(@Param("nameUsuario") String nameUsuario);
	

}
