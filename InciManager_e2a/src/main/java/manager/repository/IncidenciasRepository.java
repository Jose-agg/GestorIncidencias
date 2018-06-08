package manager.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import manager.entities.Incidencia;

public interface IncidenciasRepository extends CrudRepository<Incidencia, Long> {

	@Query("SELECT i FROM Incidencia i WHERE i.agent.id = ?1")
	List<Incidencia> incidenciasAgente(Long id);

	@Query("SELECT i FROM Incidencia i WHERE i.fecha = ?1 and i.agent.id = ?2")
	Incidencia findByDateAndAgent(Date date, Long id);
}