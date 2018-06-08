package manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import manager.entities.Etiqueta;

public interface EtiquetasRepository extends CrudRepository <Etiqueta, Long> {
	
	@Query("SELECT e FROM Etiqueta e WHERE e.incidencia.id = ?1")
	List<Etiqueta> findByIncidenciaId(Long id);
	
}