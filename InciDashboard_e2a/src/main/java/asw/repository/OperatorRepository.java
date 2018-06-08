package asw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.entities.Operator;

@Repository
public interface OperatorRepository extends CrudRepository<Operator, Long>
{
	Operator findByUser(String username);
	List<Operator> findAll();
	
} 
