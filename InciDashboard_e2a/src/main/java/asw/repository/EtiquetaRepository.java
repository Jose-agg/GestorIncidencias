package asw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import asw.entities.Etiqueta;

public interface EtiquetaRepository extends CrudRepository<Etiqueta, Long>{
	List<Etiqueta> findAll();
	
	
	@Query("SELECT eq.valor FROM Etiqueta eq GROUP BY eq.valor ORDER BY COUNT(eq.valor) desc")
	List<String> etiquetaMasUtilizada();
}
