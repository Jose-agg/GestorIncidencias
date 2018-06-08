package manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import manager.entities.Campo;

public interface CamposRepository extends CrudRepository<Campo, Long> {
	
	@Query("SELECT c FROM Campo c WHERE c.incidencia.id = ?1")
	List<Campo> findByIncidenciaId(Long id);

}