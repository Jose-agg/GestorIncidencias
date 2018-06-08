package asw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.entities.Agent;

@Repository
public interface AgentRepository extends CrudRepository<Agent, Long>{
	
	Agent findByNombre(String nombre);

}
