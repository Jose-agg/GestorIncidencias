package asw.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.entities.CamposCriticos;

@Repository
public interface CamposCriticosRepository extends CrudRepository<CamposCriticos, Long>
{
	CamposCriticos findByClave(String clave);
	Page<CamposCriticos> findAll(Pageable page);
} 
