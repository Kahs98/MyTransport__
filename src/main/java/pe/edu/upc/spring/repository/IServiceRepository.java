package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Servicio;

@Repository
public interface IServiceRepository extends JpaRepository<Servicio, Integer> {
	@Query("from Servicio s where s.nameService like %:nameService%")
	List<Servicio> buscarNombre(@Param("nameService") String nameService);
	
	@Query("from Servicio s where s.typeService like %:typeService%")
	List<Servicio> buscarTipo(@Param("typeService") String typeService);
	
	@Query("from Servicio s where s.cityService like %:cityService%")
	List<Servicio> buscarCiudad(@Param("cityService") String cityService);
}
