package asw.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.entities.Incidencia;
import asw.entities.Operator;

@Repository
public interface IncidenceRepository extends CrudRepository<Incidencia, Long>{	
	
	@Query("SELECT r FROM Incidencia r WHERE r.operadorAsignado = ?1 AND r.estado <> 'ANULADA' AND r.estado <> 'CERRADO' ORDER BY r.id ASC ")
	Page<Incidencia> findAllByUser(Pageable pageable, Operator user);
	
	List<Incidencia> findAll();
	
	
}